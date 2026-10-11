package com.mcnz.jdbc.sqlserver;
import java.math.BigDecimal;
import java.util.Scanner;

public class BudgetInput {
    private final Scanner scanner = new Scanner(System.in);

    public String getCategoryInput() {
        System.out.print("Enter budget category: ");
        return scanner.nextLine();
    }
    public BigDecimal getAmountInput() {
        System.out.print("Enter budget amount: ");
        try {
            return new BigDecimal(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount format. Please enter a valid decimal number.");
            return null;
        }
    }
}
