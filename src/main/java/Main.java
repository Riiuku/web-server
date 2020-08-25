import config.ServerProperties;

import java.io.IOException;
import java.io.PrintWriter;
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
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

    }
}
