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

    public DataBaseConnector(@Value("${urlDB}") String urlDB,
                             @Value("${userDB}") String userDB,
                             @Value("${passwordDB}") String passwordDB) {
        try {
            Class.forName ("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(urlDB, userDB, passwordDB);
            DatabaseMetaData dma = con.getMetaData ();

            // Печать сообщения об успешном соединении
            System.out.println ("\n*** SQLConnection completed ***");
            System.out.println("Connected to - " + dma.getURL());
            System.out.println("Driver       - " + dma.getDriverName());
            System.out.println("Version      - " + dma.getDriverVersion());
            System.out.println("\n");

            // Закрыть соединение
            con.close();

            this.urlDB = urlDB;
            this.userDB = userDB;
            this.passwordDB = passwordDB;
        } catch (SQLException e) {
            System.out.println ("\n*** SQLException caught ***\n");
            while (e != null) {
                System.out.println ("SQLState: " + e.getSQLState ());
                System.out.println ("Message: " + e.getMessage ());
                System.out.println ("Vendor: " + e.getErrorCode ());
                e = e.getNextException ();
            }
        } catch (java.lang.Exception ex) {
            ex.printStackTrace ();
        }
    }

    public void doGet() {

    }

}
