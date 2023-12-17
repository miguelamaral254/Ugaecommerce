package entities;

public class Account {
    private static int nextAccountId = 1;
    private int accountId;
    private String username;
    private String password;
    private String fullName;
    private int role;
    private User user; 

    public Account(String username, String password, int role) {
        this.accountId = getNextAccountId();
        this.username = username;
        this.password = password;
        this.role = role;
        this.user = new Customer(username, password); 
    }

    public Account(String username, String password, String fullName, int role) {
        this.accountId = getNextAccountId();
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.role = role;
        this.user = (role == 1) ? new Admin(username, password) : new Customer(username, password);
    }

    public Account(User newUser, int role2) {
    }

    private static int getNextAccountId() {
        return nextAccountId++;
    }

    
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    

    public int getAccountId() {
        return accountId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getRole() {
        return role;
    }

    public User getUser() {
        return user;
    }
}
