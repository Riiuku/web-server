package web.server;

import web.server.config.ServerProperties;
import web.server.domain.HttpMethod;
import web.server.domain.Request;
import web.server.exception.HttpRequestException;
import web.server.exception.PortAssignedException;
import web.server.factory.RequestHandlerFactory;
import web.server.handler.request.RequestHandler;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


import static web.server.config.Contract.EMPTY;
import static web.server.config.Contract.SERVER_PORT;


public class Main {


    public static void main(String... args) {
        try (ServerSocket socket = new ServerSocket(Integer.parseInt(ServerProperties.has(SERVER_PORT) ? ServerProperties.get(SERVER_PORT) : "8080"), 0, InetAddress.getByName(null))) {
            while (true) {
                connection(socket.accept());
            }
        } catch (IOException e) {
            throw new PortAssignedException("Port assigned");
        }
    }

    public static void connection(Socket clientSocket) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

        String firstLine = in.readLine();
        String method = firstLine.split(EMPTY)[0];
        if (!HttpMethod.contains(method))
            throw new HttpRequestException("Problem occurred, when tried to read request");

        HttpMethod httpMethod = HttpMethod.valueOf(method);

        RequestHandler requestHandler = RequestHandlerFactory.createRequestHandler(httpMethod);
        requestHandler.handle(new Request(httpMethod, firstLine.split(EMPTY)[1], null), out);


        out.close();
        in.close();
        clientSocket.close();


    }
}
