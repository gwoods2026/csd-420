// Garrett Woods Module 9

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    //tries connecting to the database
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/databasedb";
        String user = "student1";
        String password = "pass";

        System.out.println("Trying to connect to SQL database");

        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            //Message is you're able to connect
            if (conn != null) {
                System.out.println("\nSuccessfully connected");
                conn.close();

            }
            //Message is you're unable to connect
        } catch (SQLException e) {
            System.out.println("\nConnection failed");
            e.printStackTrace();
        }
    }
}
