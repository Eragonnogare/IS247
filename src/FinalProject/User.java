package FinalProject;

import java.util.Random;

public abstract class User implements ILogin {
    private String username;
    private String password;
    private int userId;  // Hidden userId

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.userId = new Random().nextInt(10000); // Generate random userId
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public abstract void login();
}