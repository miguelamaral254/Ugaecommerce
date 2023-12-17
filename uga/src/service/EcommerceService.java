package service;

import entities.Account;
import entities.Admin;
import entities.Customer;
import entities.User;
import service.Cart;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

public class EcommerceService {
    private Scanner scanner = new Scanner(System.in);
    private Set<String> existingUsernames = new HashSet<>();
    private List<Account> createdAccounts = new ArrayList<>(); // Adicione esta linha
    private Account currentAccount;

    public Account login() {
        System.out.println("Enter username: ");
        String username = scanner.next();
        System.out.println("Enter password: ");
        String password = scanner.next();

        if (isValidLogin(username, password)) {
            System.out.println("Login successful!");
            return findAccountByUsername(username);
        } else {
            System.out.println("Login failed. Invalid credentials.");
            return null;
        }
    }

    private boolean isValidLogin(String username, String password) {
        // Implemente a lógica real de autenticação aqui
        // Verificar se as credenciais correspondem a uma conta existente
        for (Account account : createdAccounts) {
            if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
                return true; // Credenciais válidas
            }
        }
        return false; // Credenciais inválidas
    }

    private Account findAccountByUsername(String username) {
        for (Account account : createdAccounts) {
            if (account.getUsername().equals(username)) {
                return account;
            }
        }
        return null;
    }

    public void createAccount() {
        System.out.println("Enter full name: ");
        scanner.nextLine();
        String fullName = scanner.nextLine();

        System.out.println("Enter username: ");
        String username = scanner.next();

        // Unique username check
        while (existingUsernames.contains(username)) {
            System.out.println("Username already in use. Choose a different one: ");
            username = scanner.next();
        }

        existingUsernames.add(username);

        System.out.println("Enter password: ");
        String password = scanner.next();
        System.out.println("Enter role (0 for customer, 1 for admin): ");
        int role = scanner.nextInt();

        // Lógica fictícia de criação de conta, você deve implementar a lógica real aqui
        // Exemplo: Criar uma nova conta no sistema
        User newUser;
        if (role == 1) {
            newUser = new Admin(username, password); // cria usuário administrador
        } else {
            newUser = new Customer(username, password); // cria usuário cliente
        }

        newUser.setFullName(fullName);
        Account newAccount = new Account(newUser, role);
        createdAccounts.add(newAccount); // Adiciona a nova conta à lista de contas criadas
        System.out.println("Account created successfully! ID: " + newAccount.getAccountId());

        // Chama o menu adequado com base no papel do usuário
        if (role == 1) {
            displayAdminMenu();
        } else {
            displayCustomerMenu();
        }
    }

    public void processUserOptions(Account account) {
        Cart cart = new Cart();
        currentAccount = account;

        while (true) {
            System.out.println("------------------------");
            System.out.println("Bem vindo! ");
            System.out.println("1. Adicionar item ao carrinho");
            System.out.println("2. Visualizar carrinho");
            System.out.println("3. Editar perfil");
            System.out.println("4. Logout");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Implemente a lógica de adição de item ao carrinho
                    break;
                case 2:
                    // Implemente a lógica do carrinho
                    break;
                case 3:
                    // Implemente a lógica de edição de perfil
                    break;
                case 4:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Escolha inválida. Tente novamente.");
            }
        }
    }

    private void displayCustomerMenu() {
        // Adicione as opções específicas do cliente aqui
    }

    private void displayAdminMenu() {
        while (true) {
            System.out.println("------------------------");
            System.out.println("Bem vindo, Administrador!");
            System.out.println("1. Relatório de vendas");
            System.out.println("2. Fazer pedido");
            System.out.println("3. Cadastrar funcionário");
            System.out.println("4. Logout");

            int adminChoice = scanner.nextInt();

            switch (adminChoice) {
                case 1:
                    // Implemente a lógica do relatório de vendas
                    break;
                case 2:
                    // Implemente a lógica para fazer pedido
                    break;
                case 3:
                    // Implemente a lógica para cadastrar funcionário
                    break;
                case 4:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Escolha inválida. Tente novamente.");
            }
        }
    }
}
