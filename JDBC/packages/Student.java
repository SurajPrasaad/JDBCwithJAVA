package packages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Student {
    public void connectionEstablish() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bca", "root",
                    "Suraj@1234");
            System.out.println("Connection successful!");
            connection.close(); // Close the connection
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
        }
    }

    public void createTable() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bca", "root",
                    "Suraj@1234");
            Statement smt = connection.createStatement();
            String query = "create table Student1 (rollno int primary key, sname varchar(50),emails varchar(50))";
            smt.executeUpdate(query);
            System.out.println("Table Created Successfully!");
            connection.close(); // Close the connection
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertData() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bca", "root",
                    "Suraj@1234");
            String query = "INSERT INTO Student1 (rollno,sname,emails) values(?,?,?)";
            PreparedStatement psmt = connection.prepareStatement(query);
            // String query = "INSERT INTO Student1 (rollno,sname,emails)
            // values(1,\"Suraj\",\"surajprasad311004@gmail.com\")";
            psmt.setInt(1, 2);
            psmt.setString(2, "Niraj");
            psmt.setString(3, "niraj@2112@gmail.com");

            psmt.executeUpdate();
            System.out.println("Data inserted Successfully!");
            connection.close(); // Close the connection
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readData() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bca", "root",
                    "Suraj@1234");
            String query = "select * from student1";
            PreparedStatement psmt = connection.prepareStatement(query);
            // String query = "INSERT INTO Student1 (rollno,sname,emails)
            // values(1,\"Suraj\",\"surajprasad311004@gmail.com\")";
            ResultSet set = psmt.executeQuery();
            while(set.next()){
                System.out.println("id "+set.getInt(1));
                System.out.println("name "+set.getString(2));
                System.out.println("emails "+set.getString(3));
            }
            System.out.println("Data Display Successfully!");
            connection.close(); // Close the connection
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateData(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bca", "root",
                    "Suraj@1234");
            String query = "update student1 set emails= ? where rollno = ? ";
            PreparedStatement psmt = connection.prepareStatement(query);
            // String query = "INSERT INTO Student1 (rollno,sname,emails)
            // values(1,\"Suraj\",\"surajprasad311004@gmail.com\")";
            psmt.setString(1, "surajprasad@gmail.com");
            psmt.setInt(2, 1);
            psmt.execute();
            
            System.out.println("Data Update Successfully!");
            connection.close(); // Close the connection
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteData(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bca", "root",
                    "Suraj@1234");
            String query = "delete from student1 where rollno = ?";
            PreparedStatement psmt = connection.prepareStatement(query);
            // String query = "INSERT INTO Student1 (rollno,sname,emails)
            // values(1,\"Suraj\",\"surajprasad311004@gmail.com\")";
            psmt.setInt(1, 2);
           psmt.executeUpdate();
            System.out.println("Data Deleted Successfully!");
            connection.close(); // Close the connection
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
