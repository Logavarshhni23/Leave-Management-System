import java.sql.*;

public class DBManager {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3307/studentleavedb";
        String user = "root";
        String pass = "1234"; 
        return DriverManager.getConnection(url, user, pass);
    }
}