package ru.ketbiev.srcibble.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import ru.ketbiev.srcibble.dto.UserDTO;

import java.sql.*;

@Repository
public class UserRepository {

    private final String urlDB;
    private final String userDB;
    private final String passwordDB;

    public UserRepository(@Value("${urlDB}") String urlDB,
                          @Value("${userDB}") String userDB,
                          @Value("${passwordDB}") String passwordDB) {
        this.urlDB = urlDB;
        this.userDB = userDB;
        this.passwordDB = passwordDB;
    }

    public int create(UserDTO user) throws Exception {
        try {
            Connection con = DriverManager.getConnection(urlDB, userDB, passwordDB);
            Statement st = con.createStatement();
            int i = st.executeUpdate(String.format("INSERT INTO users " +
                            "(create_account, last_login, login, password, signature, username) " +
                            "VALUES ('%s' ,'%s' ,'%s' ,'%s' ,'%s' ,'%s');",
                    user.getCreateAccount(),
                    user.getLastLogin(),
                    user.getLogin(),
                    user.getPassword(),
                    user.getSignature(),
                    user.getUsername()));
            con.close();
            return i;
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }

    public int get(int id) throws Exception {
        try {
            Connection con = DriverManager.getConnection(urlDB, userDB, passwordDB);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(String.format("SELECT * FROM users WHERE id = %s", id));
            rs.next();
            con.close();
            return rs.getInt("id");
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }

    public int update(int id, UserDTO user) throws Exception {
        try {
            Connection con = DriverManager.getConnection(urlDB, userDB, passwordDB);
            Statement st = con.createStatement();
            int i = st.executeUpdate(String.format("UPDATE users " +
                            "SET (create_account, last_login, login, password, signature, username) = " +
                            "('%s' ,'%s' ,'%s' ,'%s' ,'%s' ,'%s') " +
                            "WHERE id = %s;",
                    user.getCreateAccount(),
                    user.getLastLogin(),
                    user.getLogin(),
                    user.getPassword(),
                    user.getSignature(),
                    user.getUsername(),
                    id));
            con.close();
            return i;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public int delete(int id) throws Exception {
        try {
            Connection con = DriverManager.getConnection(urlDB, userDB, passwordDB);
            Statement st = con.createStatement();
            int i = st.executeUpdate(String.format("DELETE FROM users WHERE id = %s;", id));
            con.close();
            return i;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
