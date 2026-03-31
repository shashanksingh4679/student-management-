package student.managment.system;
import java.sql.*;

public class Conn {
    Connection connection;

    public Conn() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres",
                    "postgres",
                    "hidden"
            );
        } catch (Exception e) {
            System.err.println("DB Connection Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}