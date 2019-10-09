package edu.acc.java3.login;

public class User implements java.io.Serializable {
    private String username;
    private String password;
    private int id;
    
    public User() {}
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" + "username=" + username + ", password=" + password + ", id=" + id + '}';
    }

    
}
