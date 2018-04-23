package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionConfiguration {

    public static Connection getConnection() {
        Connection connection = null;

        try {
            Properties prop = new Properties();
            prop.load(ConnectionConfiguration.class.getClassLoader().getResourceAsStream("database.properties"));
            String baseUrl = prop.getProperty("MySQL.path");
            String user = prop.getProperty("MySQL.user");
            String password = prop.getProperty("MySQL.pass");
            String databaseName = prop.getProperty("MySQL.database");
            String URL = String.format("%s/%s?user=%s&password=%s&useSSL=false", baseUrl, databaseName, user, password);
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static void main(String[] args) {
        System.out.println(ConnectionConfiguration.getConnection());
    }
}