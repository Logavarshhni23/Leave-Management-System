import java.sql.Connection;
import java.sql.DriverManager;

public class App {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3307/studentleavedb";
        String user = "root";         // your MySQL username
        String password = "1234"; // your MySQL password

        try {
            // Establish connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println(" Database connected successfully!");
            
            // Close connection
            con.close();
        } catch (Exception e) {
            System.out.println(" Database connection failed!");
            e.printStackTrace();
        }
    }
}
