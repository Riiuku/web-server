package web.server;

import web.server.config.ServerProperties;
import web.server.domain.HttpMethod;
import web.server.exception.HttpRequestException;
import web.server.exception.PortAssignedException;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import static web.server.config.Contract.SERVER_PORT;


public class Main {
    private static final String EMPTY = " ";

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

        switch (httpMethod) {
            case GET:
            case PUT:
            case POST:
            case PATCH:
            case DELETE:
            case OPTIONS:
        }


        out.write("HTTP/1.1 200 OK\r\n");
        out.write("\r\n");
        out.write("<TITLE>XDDD</TITLE>");
        out.close();
        in.close();
        clientSocket.close();


    }
}
