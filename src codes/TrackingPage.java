package com.mcnz.jdbc.sqlserver;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

/**
 * Tracking page for track the income data or accept the data
 * @author hady hassan
 * @version 1.0
 */
public class TrackingPage {
    IncomeRepository incomeRepository = new IncomeRepository();

    public void enterIncome() {
        Scanner scanner = new Scanner(System.in);
        User currentUser = UserContext.getInstance().getCurrentUser();
        int userId = currentUser.getId();

        System.out.println("=== Enter New Income ===");
        System.out.print("Enter Income Source: ");
        String source = scanner.nextLine();

        System.out.print("Enter Amount: ");
        BigDecimal amount = new BigDecimal(scanner.nextLine());

        System.out.print("Enter Date (yyyy-mm-dd): ");
        String dateStr = scanner.nextLine();

        try {
            incomeRepository.saveIncome(userId, source, dateStr, amount);
            System.out.println(" Income data saved successfully.");
        } catch (Exception e) {
            System.out.println(" Failed to save income: " + e.getMessage());
        }
    }

    public void showIncomes() {
        User currentUser = UserContext.getInstance().getCurrentUser();
        int userId = currentUser.getId();

        try {
            List<Income> incomes = incomeRepository.getIncomes(userId);
            System.out.println("=== Your Income Records ===");
            incomes.forEach(income -> {
                System.out.println("Source: " + income.getSource() +
                        ", Amount: " + income.getSalary() +
                        ", Date: " + income.getDate());
            });
        } catch (Exception e) {
            System.out.println(" Failed to load incomes: " + e.getMessage());
        }
    }


}
