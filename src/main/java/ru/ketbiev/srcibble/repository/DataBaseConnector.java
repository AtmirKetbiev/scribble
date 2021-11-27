package ru.ketbiev.srcibble.repository;

import org.springframework.beans.factory.annotation.Value;

import java.sql.*;

public class DataBaseConnector {

    @Value("${urlDB}")
    private String urlDB;

    @Value("${userDB}")
    private String userDB;

    @Value("${passwordDB}")
    private String passwordDB;

    public void doGet() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/scribble",
                    "postgres",
                    "root");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT login from users");

            while (rs.next()) {
                System.out.println(rs.getString("login"));
            }

            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
