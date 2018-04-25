package com.hafidzniioman;

import sun.java2d.pipe.DrawImage;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:D:\\databases\\testjava.db");

            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS contacts" +
                    "(name TEXT, phone INTEGER, email TEXT)");

           /* statement.execute("INSERT INTO contacts (name, phone, email)" +
                    " VALUES('Joe',+6285724040445,'hafidzniioman@gmail.com')");

            statement.execute("INSERT INTO contacts (name, phone, email)" +
                    " VALUES('James',+6285724040445,'hafidzniioman@gmail.com')");

            statement.execute("INSERT INTO contacts (name, phone, email)" +
                    " VALUES('Milner',+6285724040445,'hafidzniioman@gmail.com')");
           statement.execute("UPDATE contacts SET phone=56789 WHERE name='James'");
           statement.execute("DELETE FROM contacts WHERE name='Hafidz'");

            statement.execute("UPDATE contacts SET phone=56789 WHERE name='Joe'");
*/
            statement.execute("SELECT * FROM contacts");
            ResultSet result = statement.getResultSet();
            while (result.next()) {
                System.out.println(result.getString("name") + " " +
                        result.getInt("phone") + " " +
                        result.getString("email"));
            }
            result.close();

            statement.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Something went wrong " + e.getMessage());
        }
    }
}
