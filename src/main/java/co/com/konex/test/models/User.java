package co.com.konex.test.models;

public class User {


    private String email;
    private String password;

    public User(String email, String password) {
        this.password = password;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
