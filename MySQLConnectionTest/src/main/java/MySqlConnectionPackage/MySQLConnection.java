package MySqlConnectionPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnection {
    public static void main(String[] args) throws SQLException {
        // Registering Driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found. Please include the JDBC driver in your project.");
            e.printStackTrace();
            return; // exit if driver is not found
        }

        // Database credentials
        String dbURL = "jdbc:mysql://localhost:3306/training?useSSL=false";
        String user = "root";
        String password = "WJ28@krhps";

        Connection conn = null;
        try {
            // Establishing connection
            conn = DriverManager.getConnection(dbURL, user, password);
            Statement st = conn.createStatement();

            // Update query
            String updateQuery = "UPDATE student SET Sname = 'George' WHERE Sname ='Sachin'";
            int rowsAffected = st.executeUpdate(updateQuery);

            // Check if the update was successful
            if (rowsAffected > 0) {
                System.out.println("Updated " + rowsAffected + " row(s).");
            } else {
                System.out.println("Update unsuccessful");
            }

            // Select query to retrieve data from the student table
            String selectQuery = "SELECT Sno, Sname, marks FROM student";
            ResultSet rs = st.executeQuery(selectQuery);

            // Display the results
            while (rs.next()) {
                int Sno = rs.getInt("Sno");
                String Sname = rs.getString("Sname");
                int marks = rs.getInt("marks");
                System.out.println(Sno + " " + Sname + " " + marks);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the connection if it's not null
            if (conn != null) {
                conn.close();
            }
        }
    }
}

           
	


