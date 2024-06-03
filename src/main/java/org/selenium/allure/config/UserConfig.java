package org.selenium.allure.config;

import java.io.InputStream;
import java.util.Properties;

/**
 * Класс конфигурации пользователя.
 * Загружает данные пользователя из файла свойств.
 */
public class UserConfig {
    private static final Properties properties = new Properties();

    // Статический блок инициализации для загрузки свойств из файла.
    static {
        try (InputStream input = UserConfig.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Получить имя пользователя.
     *
     * @return Имя пользователя из файла свойств.
     */
    public static String getUser() {
        return properties.getProperty("user");
    }

    /**
     * Получить адрес пользователя.
     *
     * @return Адрес пользователя из файла свойств.
     */
    public static String getUserAddress() {
        return properties.getProperty("user_address");
    }

    /**
     * Получить телефон пользователя.
     *
     * @return Телефон пользователя из файла свойств.
     */
    public static String getUserPhone() {
        return properties.getProperty("user_phone");
    }

    /**
     * Получить электронную почту пользователя.
     *
     * @return Электронная почта пользователя из файла свойств.
     */
    public static String getUserEmail() {
        return properties.getProperty("user_email");
    }

    /**
     * Получить комментарий пользователя.
     *
     * @return Комментарий пользователя из файла свойств.
     */
    public static String getUserComment() {
        return properties.getProperty("user_comment");
    }
}
