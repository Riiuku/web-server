import config.ServerProperties;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

import static config.Contract.SERVER_PORT;


public class Main {


    public static void main(String... args) {
        try (ServerSocket socket = new ServerSocket(Integer.parseInt(ServerProperties.has(SERVER_PORT) ? ServerProperties.get(SERVER_PORT) : "8080"), 0, InetAddress.getByName(null))) {
            while (true) {
                connection(socket.accept());
            }
        } catch (IOException e) {
            throw new RuntimeException("Port assigned");
        }
    }

    public static void connection(Socket clientSocket) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));


        String s;
        while ((s = in.readLine()) != null) {
            System.out.println(s);
            if (s.isEmpty()) {
                break;
            }
        }

        out.write("HTTP/1.1 200 OK\r\n");
        out.write("\r\n");
        out.write("<TITLE>XDDD</TITLE>");
        out.close();
        in.close();
        clientSocket.close();



    }
}
