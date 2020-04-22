package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    public static Connection getConnection(){
        Connection connection=null;

        String url="jdbc:mysql://localhost:3306/test?useSSL=false";
        String useName="root";
        String password="Daikahuynh01091995";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection(url,useName,password);
            System.out.println("Connected successfully");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        DBConnect.getConnection();
    }
}
