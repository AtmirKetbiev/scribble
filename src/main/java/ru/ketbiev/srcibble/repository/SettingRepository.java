package ru.ketbiev.srcibble.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import ru.ketbiev.srcibble.dto.SettingDTO;

import java.sql.*;

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

    public SettingDTO get(int id) throws Exception {
        try {
            Connection con = DriverManager.getConnection(urlDB, userDB, passwordDB);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(String.format("SELECT * FROM settings WHERE id = %s", id));
            con.close();
            rs.next();
            return new SettingDTO(rs.getInt("id"),
                    rs.getInt("user_id"),
                    rs.getString("color"),
                    rs.getBoolean("is_mkd"));
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }

    public boolean update(SettingDTO setting) throws Exception {
        try {
            Connection con = DriverManager.getConnection(urlDB, userDB, passwordDB);
            Statement st = con.createStatement();
            int i = st.executeUpdate(String.format("UPDATE settings " +
                            "SET (user_id, color, is_mkd) " +
                            "VALUES ('%s' ,'%s' ,'%s') " +
                            "WHERE id = %s;",
                    setting.getUserId(),
                    setting.getTheme(),
                    setting.getIsMkd(),
                    setting.getId()));
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
            int i = st.executeUpdate(String.format("DELETE FROM settings WHERE id = %s;", id));
            con.close();
            return i == 1;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
