package org.selenium.allure.config;

import java.io.InputStream;
import java.util.Properties;

public class UserConfig {
    private static Properties properties = new Properties();

    static {
        try (InputStream input = UserConfig.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getUser() {
        return properties.getProperty("user");
    }

    public static String getUserAddress() {
        return properties.getProperty("user_address");
    }

    public static String getUserPhone() {
        return properties.getProperty("user_phone");
    }

    public static String getUserEmail() {
        return properties.getProperty("user_email");
    }

    public static String getUserComment() {
        return properties.getProperty("user_comment");
    }
}
