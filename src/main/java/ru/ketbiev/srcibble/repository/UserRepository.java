package ru.ketbiev.srcibble.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.ketbiev.srcibble.model.User;

import java.sql.*;

@Component
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

    public void create(User user) {
        try {
            Connection con = DriverManager.getConnection(urlDB, userDB, passwordDB);
            Statement st = con.createStatement();
            st.execute(String.format("INSERT INTO " +
                            "users (create_account, last_login, login, password, signature, username) " +
                            "VALUES ('%s' ,'%s' ,'%s' ,'%s' ,'%s' ,'%s');",
                    user.getCreateAccount(),
                    user.getLastLogin(),
                    user.getLogin(),
                    user.getPassword(),
                    user.getSignature(),
                    user.getUsername()));
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User get(int id) throws Exception {
        try {
            Connection con = DriverManager.getConnection(urlDB, userDB, passwordDB);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(String.format("SELECT %s from users", id));
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setLogin(rs.getString("login"));
            con.close();
            return user;
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }

    public void update() {

    }

    public void delete() {

    }

}
