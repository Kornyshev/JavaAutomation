package me.kornyshev.properties;

import lombok.extern.slf4j.Slf4j;

import java.io.FileReader;
import java.util.Properties;

@Slf4j
public class PropertyLoader {

    private static final Properties PROPERTIES = new Properties();

    static {
        try (FileReader reader = new FileReader("src/test/resources/user.properties")) {
            PROPERTIES.load(reader);
        } catch (Exception e) {
            log.error("Something went wrong: {}", e.getMessage());
        }
    }

    public static String getUserName() {
        return PROPERTIES.getProperty("name");
    }

    public static String getUserEmail() {
        return PROPERTIES.getProperty("email");
    }

    public static String getUserPassword() {
        return PROPERTIES.getProperty("password");
    }

}
