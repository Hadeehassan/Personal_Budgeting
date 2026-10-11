package com.mcnz.jdbc.sqlserver;
import java.util.List;
import java.math.BigDecimal;
import java.util.Scanner;

public class BudgetUI {
	private final BudgetRepository budgetRepository = new BudgetRepository();
	private final BudgetInput budgetInput = new BudgetInput();
	private final BudgetService budgetService = new BudgetService();
	private User currentUser = UserContext.getInstance().getCurrentUser();

	public void showBudgetInput() {
		if (currentUser == null) {
			System.out.println("No user is currently logged in. Please log in.");
			return;
		}

		try {
			int userId = currentUser.getId();
			String category = budgetInput.getCategoryInput();
			BigDecimal amount = budgetInput.getAmountInput();

			// Validate and save the budget if valid
			if (amount != null && budgetService.validateBudget(userId, category, amount)) {
				budgetRepository.saveBudget(userId, category, amount);
				System.out.println("Budget saved successfully :) ");
			} else {
				System.out.println("Invalid budget entry. Please check your category and amount.");
			}
		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
		}
	}
	public void showUserBudgets() {
		if (currentUser == null) {
			System.out.println("No user is logged in. Please log in to view your budgets.");
			return;
		}

		List<Budget> budgets = budgetRepository.getBudgets(currentUser.getId());

		if (budgets.isEmpty()) {
			System.out.println("You have no budgets.");
		} else {
			System.out.println("=== Your Budgets ===");
			for (Budget b : budgets) {
				System.out.println("Category: " + b.getCategory() +
						", Amount: " + b.getAmount() +
						", Date: " + b.getCreatedAt());
			}
		}
	}
}
