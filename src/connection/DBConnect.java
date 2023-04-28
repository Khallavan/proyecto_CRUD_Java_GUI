package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
    protected Connection connection;

    protected void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/application?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8",
                    "root", "admin");
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }

    protected void disconnect() {
        try {
            connection.close();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }
}
