package p1;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        // Connector strings
        String url = "//phpmyadmin.cdgwdgkn5fuv.us-west-2.rds.amazonaws.com";
        String db_name = "eric_db";
        String user = "db_eric";
        String password = "Way2Go";
        String connect = "jdbc:mysql:" + url + ":3306/" + db_name;

        Connection connection = null;

        // Load MySQL Driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Driver not loaded");
        }

        // Connect to the database
        try {
            connection = DriverManager.getConnection(connect, user, password);
            System.out.println("Connection succeeded");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection failed");
        }

        // Get the information from the database
        try {
            Statement s = null;
            if (connection != null) {
                s = connection.createStatement();
            }
            ResultSet rs = null;
            if (s != null) {
                rs = s.executeQuery("SELECT * FROM address");
            }

            if (rs != null) {
                while (rs.next()) {
                    System.out.println(rs.getString(2) +
                        " lives in apartment " + rs.getString(3));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL Error");
        }
    }
}
