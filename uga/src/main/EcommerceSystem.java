package main;

import java.util.Scanner;

import entities.Account;
import service.EcommerceService;

public class EcommerceSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EcommerceService ecommerceService = new EcommerceService();
        Account loggedInAccount = null;

            while (true) {
                System.out.println("----------------------");
                System.out.println("Welcome to Uga Ecommerce");
                System.out.println("----------------------");
                System.out.println("1. Login");
                System.out.println("2. Create Account");
                System.out.println("3. Exit");
                System.out.println("----------------------");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        loggedInAccount = ecommerceService.login();
                        if (loggedInAccount != null) {
                            ecommerceService.processUserOptions(loggedInAccount);
                        }
                        break;
                    case 2:
                        ecommerceService.createAccount();
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        }
    }

