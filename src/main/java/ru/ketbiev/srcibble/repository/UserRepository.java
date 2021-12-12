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

    public UserDTO create(UserDTO user) throws Exception {
        try {
            Connection con = DriverManager.getConnection(urlDB, userDB, passwordDB);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(String.format("with idNote as (" +
                            "INSERT INTO users " +
                            "(login, password, username, signature, create_account, last_login) " +
                            "VALUES ('%s' ,'%s' ,'%s' ,'%s' ,'%s' ,'%s') " +
                            "RETURNING id" +
                            ") " +
                            "SELECT * FROM idNote",
                    user.getLogin(),
                    user.getPassword(),
                    user.getUsername(),
                    user.getSignature(),
                    user.getCreateAccount(),
                    user.getLastLogin()));
            con.close();
            rs.next();
            user.setId(rs.getInt("id"));
            return user;
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }

    public UserDTO get(int id) throws Exception {
        try {
            Connection con = DriverManager.getConnection(urlDB, userDB, passwordDB);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(String.format("SELECT * FROM users WHERE id = %s", id));
            con.close();
            rs.next();
            return new UserDTO(rs.getInt("id"),
                    rs.getString("login"),
                    rs.getString("password"),
                    rs.getString("username"),
                    rs.getString("signature"),
                    rs.getString("create_account"),
                    rs.getString("last_login"));
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }

    public boolean update(UserDTO user) throws Exception {
        try {
            Connection con = DriverManager.getConnection(urlDB, userDB, passwordDB);
            Statement st = con.createStatement();
            int i = st.executeUpdate(String.format("UPDATE users " +
                            "SET (login, password, username, signature, create_account, last_login) " +
                            "= ('%s' ,'%s' ,'%s' ,'%s' ,'%s' ,'%s') " +
                            "WHERE id = %s;",
                    user.getLogin(),
                    user.getPassword(),
                    user.getUsername(),
                    user.getSignature(),
                    user.getCreateAccount(),
                    user.getLastLogin(),
                    user.getId()));
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
            int i = st.executeUpdate(String.format("DELETE FROM users WHERE id = %s;", id));
            con.close();
            return i == 1;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
