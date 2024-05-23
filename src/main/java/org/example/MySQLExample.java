package org . example;
import java.sql.*;
public class MySQLExample {
    // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/cinema";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";
    static Connection connection = null;

    public static void main(String[] args) {


    try {
        // Register MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish connection to MySQL database
        connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

        if (connection != null) {
            System.out.println("Connected to the database coin coin!");
            // You can perform database operations here
            Statement statement = connection.createStatement();
            //Execute a SQL query
            String sqlQuery = "SELECT * FROM acteur";
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            //Process the result set
            while (resultSet.next()){
//                Retrive data from the result set
                int id= resultSet.getInt("Id_acteur");
                String nom= resultSet.getString("nom");
                String prenom= resultSet.getString("prenom");
                String photo= resultSet.getString("photo");

                System.out.println("ID: "+ id +" , Name: "+nom+" "+prenom+ " "+photo);
            }
        }
    } catch (SQLException | ClassNotFoundException e) {
        throw new RuntimeException(e);
    }
    }
}
