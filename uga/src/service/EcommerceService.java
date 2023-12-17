package service;

import entities.Account;
import entities.Admin;
import entities.Customer;
import entities.User;
import service.Cart;

import java.util.HashSet;

import java.util.Scanner;
import java.util.Set;

public class EcommerceService {
    private Scanner scanner = new Scanner(System.in);
    private Set<String> existingUsernames = new HashSet<>();
    private Account currentAccount;

    public Account login() {
        System.out.println("Enter username: ");
        String username = scanner.next();
        System.out.println("Enter password: ");
        String password = scanner.next();

        if (isValidLogin(username, password)) {
            System.out.println("Login successful!");
            return new Account(username, password, 0);
        } else {
            System.out.println("Login failed. Invalid credentials.");
            return null;
        }
    }

    private boolean isValidLogin(String username, String password) {
        // Implemente a lógica real de autenticação aqui
        // Exemplo: Verificar se as credenciais correspondem a uma conta existente
        return true; // Implemente a lógica de autenticação real
    }

    public void createAccount() {
        System.out.println("Enter full name: ");
        scanner.nextLine();
        String fullName = scanner.nextLine();

        System.out.println("Enter username: ");
        String username = scanner.next();

        // Uniqui username check
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
        User newUser = new Customer(username, password); // Cria um usuário do tipo Customer por padrão
        newUser.setFullName(fullName);

        if (role == 1) {
            newUser = new Admin(username, password); // create admin user
        }

        Account newAccount = new Account(newUser, role);
        System.out.println("Account created successfully! ID: " + newAccount.getAccountId());
    }

    public void processUserOptions(Account account) {
        Cart cart = new Cart();
        

        while (true) {
            System.out.println("------------------------");
            System.out.println("Bem vindo!");
            System.out.println("1. Add item");
            System.out.println("2. Cart");
            System.out.println("3. Edit profile");
            System.out.println("4. Logout");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Falta adição de item ao carrinho
                    break;
                case 2:
                    // Falta carrinho
                    break;
                case 3:
                    // Falta edição de perfil
                    break;
                case 4:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
