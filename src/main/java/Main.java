import config.ServerProperties;

import java.util.Properties;

public class Main {

    public static void main(String ...args) {
        System.out.println(ServerProperties.get("server.port"));
    }
}
