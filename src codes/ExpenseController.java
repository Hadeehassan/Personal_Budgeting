package com.mcnz.jdbc.sqlserver;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

/**
 * Class for add Expense and show it
 * @author Reyad Youssif
 * @version 1.0 
 */
public class ExpenseController {
	private final ExpenseRepository expenseRepository = new ExpenseRepository();
	private final ExpenseInput expenseInput = new ExpenseInput();
	private final ExpenseService expenseService = new ExpenseService();

	public void enterExpense() {
		User currentUser = UserContext.getInstance().getCurrentUser();
		int userId = currentUser.getId();

		String category = expenseInput.getCategoryInput();
		BigDecimal amount = expenseInput.getAmountInput();
		String date = expenseInput.getDateInput();
		if (expenseService.validateExpense(amount)) {
			expenseRepository.saveExpense(userId, category, date, amount);
			System.out.println(" Expense data saved successfully.");
		}
	}
    public void showExpenses() {
        User currentUser = UserContext.getInstance().getCurrentUser();
        int userId = currentUser.getId();
        List<Expense> expenses = expenseRepository.getExpenses(userId);
        System.out.println("=== Your Expense Records ===");
        for (Expense expense : expenses) {
            System.out.println("Category: " + expense.getCategory() +
                    ", Amount: " + expense.getAmount() +
                    ", Date: " + expense.getDate()
                    );
        }
    }
}
