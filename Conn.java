package student.managment.system;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {

    Connection connection;

    public Conn() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student_management",
                    "root",
                    "yourpassword"
            );
            System.out.println("Connected successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}