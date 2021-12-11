package ru.ketbiev.srcibble.repository;

import org.springframework.beans.factory.annotation.Value;
import ru.ketbiev.srcibble.dto.NoteDTO;
import ru.ketbiev.srcibble.dto.UserDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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

    public int create(UserDTO userDTO, NoteDTO noteDTO) throws Exception {
        try {
            Connection con = DriverManager.getConnection(urlDB, userDB, passwordDB);
            Statement st = con.createStatement();
            String f = "BEGIN;" +
                    "INSERT INTO notes (name, create_note) VALUES ('%s' ,'%s');" +
                    "INSERT INTO users_notes (user_id, note_id)VALUES ('%s', 6);" +
                    "COMMIT";
            int i = st.executeUpdate(String.format(f, noteDTO.getName(), noteDTO.getCreateDateTime(), userDTO.getId()));
            con.close();
            return i;
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }
}
