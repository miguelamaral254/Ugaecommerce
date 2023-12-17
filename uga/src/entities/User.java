package entities;

public class User {
    private static int nextUserId = 1;

    protected int userId;
    protected String username;
    protected String password;
    protected String fullName;

    public User(String username, String password) {
        this.userId = nextUserId++;
        this.username = username;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
