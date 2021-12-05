package ru.ketbiev.srcibble.model;

public class User {

    private int id;
    private String createAccount;
    private String lastLogin;
    private String login;
    private String password;
    private String signature;
    private String username;

    public User() {
    }

    public User(String createAccount, String lastLogin, String login, String password, String signature, String username) {
        this.createAccount = createAccount;
        this.lastLogin = lastLogin;
        this.login = login;
        this.password = password;
        this.signature = signature;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreateAccount() {
        return createAccount;
    }

    public void setCreateAccount(String createAccount) {
        this.createAccount = createAccount;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
