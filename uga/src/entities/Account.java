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

    public Account(User newUser, int role2) {
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
    

    // Outros métodos conforme necessário
}