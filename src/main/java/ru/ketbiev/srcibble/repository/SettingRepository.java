package ru.ketbiev.srcibble.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import ru.ketbiev.srcibble.dto.SettingDTO;
import ru.ketbiev.srcibble.dto.UserDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class SettingRepository {
    private final String urlDB;
    private final String userDB;
    private final String passwordDB;

    public SettingRepository(@Value("${urlDB}") String urlDB,
                          @Value("${userDB}") String userDB,
                          @Value("${passwordDB}") String passwordDB) {
        this.urlDB = urlDB;
        this.userDB = userDB;
        this.passwordDB = passwordDB;
    }

    public int create(SettingDTO setting) throws Exception {
        try {
            Connection con = DriverManager.getConnection(urlDB, userDB, passwordDB);
            Statement st = con.createStatement();
            int i = st.executeUpdate(String.format("INSERT INTO settings " +
                            "(user_id, color, is_mkd) " +
                            "VALUES ('%s' ,'%s' ,'%s');",
                    setting.getUserId(),
                    setting.getTheme(),
                    setting.getIsMkd()));
            con.close();
            return i;
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }
}
