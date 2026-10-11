package com.mcnz.jdbc.sqlserver;
import java.math.BigDecimal;
import java.util.Scanner;

public class ExpenseInput {
    private Scanner scanner = new Scanner(System.in);
    public String getCategoryInput() {
        System.out.print("Enter Expense Category: ");
        return scanner.nextLine();
    }
    public BigDecimal getAmountInput() {
        System.out.print("Enter Amount: ");
        try {
            return new BigDecimal(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount. Please enter a valid decimal number.");
            return null;
        }
    }
    public String getDateInput() {
        System.out.print("Enter Date (yyyy-mm-dd): ");
        return scanner.nextLine();
    }
}

