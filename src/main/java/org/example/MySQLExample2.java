package org.example;
import java.sql.*;

public class MySQLExample2 {
    // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/cinema";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";
    public static void main(String[] args) {
        PreparedStatement preparedStatement= null;
        Connection connection = null;

    try {
        // Register MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish connection to MySQL database
        connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

        if (connection != null) {
            System.out.println("Connected to the database cinema");
            // You can perform database operations here

            //Execute a SQL query
            String sqlInsert = "INSERT INTO acteur (nom,prenom,photo) VALUES (?,?,?)";
            preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setString(1,"Black");
            preparedStatement.setString(2,"Jack");
            preparedStatement.setString(3,"bj.jpg");
            preparedStatement.executeUpdate();

            preparedStatement.close();
        }
    } catch (SQLException | ClassNotFoundException e) {
        throw new RuntimeException(e);
    }
    }
}
