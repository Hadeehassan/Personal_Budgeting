package com.mcnz.jdbc.sqlserver;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AccountController accountController = new AccountController();
        CredentialValidator validator = new CredentialValidator();
        UserRepository userRepository = new UserRepository();
        SessionManager sessionManager = new SessionManager();
        SignUp signUp = new SignUp();
        LogIn logIn = new LogIn(validator, userRepository, sessionManager);
        ReminderUI reminderUI = new ReminderUI();

        while (true) {
            System.out.println("=== Welcome to Personal Budgeting App ===");
            System.out.println("1. Login");
            System.out.println("2. Sign Up");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.print("Enter username: ");
                String username = scanner.nextLine();

                System.out.print("Enter password: ");
                String password = scanner.nextLine();

                boolean success = logIn.signIn(username, password);
                if (success) {
                    System.out.println("Welcome, " + UserContext.getInstance().getCurrentUser().getUserName() + "!");
                    runUserDashboard(scanner, reminderUI);
                } else {
                    System.out.println("Login failed.");
                }

            } else if (choice.equals("2")) {
                signUp.startSignUp();

            } else if (choice.equals("3")) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    private static void runUserDashboard(Scanner scanner, ReminderUI reminderUI) {
        TrackingPage trackingPage = new TrackingPage();
        BudgetUI budgetUI = new BudgetUI();
        ExpenseController expenseController = new ExpenseController();

        while (true) {
            System.out.println("\n=== Dashboard Menu ===");
            System.out.println("1. Add Income");
            System.out.println("2. Show Incomes");
            System.out.println("3. Add Budget");
            System.out.println("4. Show Budgets");
            System.out.println("5. Add Expense");
            System.out.println("6. Show Expenses");
            System.out.println("7. View Reminders");
            System.out.println("8. Add Reminder");
            System.out.println("9. Log Out");
            System.out.print("Choose an option: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    trackingPage.enterIncome();
                    break;
                case "2":
                    trackingPage.showIncomes();
                    break;
                case "3":
                    budgetUI.showBudgetInput();
                    break;
                case "4":
                    budgetUI.showUserBudgets();
                    break;
                case "5":
                    expenseController.enterExpense();
                    break;
                case "6":
                	expenseController.showExpenses();
                    break;
                case "7":
                	reminderUI.showReminders();
                    break;
                case "8":
                    reminderUI.showReminderInput();
                    break;
                case "9":
                    UserContext.getInstance().setCurrentUser(null);
                    System.out.println("You have been logged out.");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
