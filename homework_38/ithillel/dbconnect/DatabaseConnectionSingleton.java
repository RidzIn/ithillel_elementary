package ua.ithillel.dbconnect;

import ua.ithillel.util.AppConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionSingleton {
    private static DatabaseConnectionSingleton instance;
    private Connection connection;

    public static synchronized DatabaseConnectionSingleton getInstance() {
        if (instance == null) {
            instance = new DatabaseConnectionSingleton();
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                Connection con = DriverManager.getConnection(
                        AppConfig.getProperty("url"),
                        AppConfig.getProperty("user"),
                        AppConfig.getProperty("password")
                );
                System.out.println("Connection got");
                connection = con;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
