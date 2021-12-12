package ru.ketbiev.srcibble.repository;

import org.springframework.beans.factory.annotation.Value;
import ru.ketbiev.srcibble.dto.NoteDTO;
import ru.ketbiev.srcibble.dto.UserDTO;

import java.sql.*;

public class NoteRepository {
    private final String urlDB;
    private final String userDB;
    private final String passwordDB;

    public NoteRepository(@Value("${urlDB}") String urlDB,
                          @Value("${userDB}") String userDB,
                          @Value("${passwordDB}") String passwordDB) {
        this.urlDB = urlDB;
        this.userDB = userDB;
        this.passwordDB = passwordDB;
    }

    public int create(int userid, NoteDTO note) throws Exception {
        try {
            Connection con = DriverManager.getConnection(urlDB, userDB, passwordDB);
            Statement st = con.createStatement();
            String f = "with idNote as (" +
                    "INSERT INTO notes (name, text, create_note) " +
                    "VALUES ('%s', '%s', %s') " +
                    "RETURNING id" +
                    ") " +
                    "INSERT INTO users_notes (user_id, note_id) VALUES (%s, (SELECT * FROM idNote))";
            int i = st.executeUpdate(String.format(f, note.getName(), note.getText(), note.getCreateDateTime(), userid));
            con.close();
            return i;
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }

    public NoteDTO get(int id) throws Exception {
        try {
            Connection con = DriverManager.getConnection(urlDB, userDB, passwordDB);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(String.format("SELECT * FROM notes WHERE id = %s", id));
            con.close();
            rs.next();
            return new NoteDTO(rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("text"),
                    rs.getString("create_note"));
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }

    public boolean update(NoteDTO note) throws Exception {
        try {
            Connection con = DriverManager.getConnection(urlDB, userDB, passwordDB);
            Statement st = con.createStatement();
            int i = st.executeUpdate(String.format("UPDATE notes " +
                            "SET (name, text, create_note) " +
                            "= ('%s' ,'%s' ,'%s') " +
                            "WHERE id = %s;",
                    note.getName(),
                    note.getText(),
                    note.getCreateDateTime(),
                    note.getId()));
            con.close();
            return i == 1;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public boolean delete(int id) throws Exception {
        try {
            Connection con = DriverManager.getConnection(urlDB, userDB, passwordDB);
            Statement st = con.createStatement();
            int i = st.executeUpdate(String.format("DELETE FROM notes WHERE id = %s;", id));
            con.close();
            return i == 1;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    String f = "with idNote as (" +
            "INSERT INTO notes (name, create_note) " +
            "VALUES ('Test note' ,'2021-12-10 12:00:00') " +
            "RETURNING id" +
            "), idUser as (" +
            "INSERT INTO users (create_account, last_login, login, password, signature, username) " +
            "VALUES ('2021-12-10 12:00:00' ,'2021-12-10 12:00:00' ,'Test login' ,'super pas' ,'its me' ,'name') " +
            "RETURNING id" +
            ") " +
            "INSERT INTO users_notes (user_id, note_id) VALUES ((SELECT * FROM idUser), (SELECT * FROM idNote))";
}
