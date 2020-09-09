package web.server.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ServerProperties {

    private static Map<String, String> props = new HashMap<String, String>();

    public static String get(String key) {
        return props.get(key);
    }

    public static boolean has(String key) {
        return props.containsKey(key);
    }

    static {
        final File fileWithProperties = new File("src/main/resources/app.proprties");
        try {
            FileInputStream inputStream = new FileInputStream(fileWithProperties);
            Properties properties = new Properties();
            properties.load(inputStream);
            properties.keySet().forEach(
                    key ->
                            props.putIfAbsent(key.toString(), properties.getProperty(key.toString()))
                    );
        } catch (IOException e) {

        }


    }


}
