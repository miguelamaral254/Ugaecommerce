package entities;

public class Account {
    private static int nextAccountId = 1;
    private int accountId;
    private String username;
    private String password;
    private String fullName; // Adiciona o campo fullName
    private int role;

    public Account(String username, String password, int role) {
        this.accountId = nextAccountId++;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    
    public Account(String username, String password, String fullName, int role) {
        this.accountId = getNextAccountId();
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.role = role;
    }
    private static int getNextAccountId() {
        return nextAccountId++;
    }

    // Métodos getters e setters para fullName
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    // Restante dos métodos getters e setters

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

    // Outros métodos conforme necessário
}
