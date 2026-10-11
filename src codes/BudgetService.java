package com.mcnz.jdbc.sqlserver;

import java.math.BigDecimal;

public class BudgetService {

    public boolean validateBudget(int userId, String category, BigDecimal amount) {
        if (category == null || amount == null) {
            return false;
        }
        if (category.length() < 3 || category.length() > 50) {
            return false;
        }
        if (!category.matches("[A-Za-z0-9 ]+")) {
            return false;
        }
        String[] validCategories = {"groceries", "rent", "entertainment", "transportation", "utilities"};
        boolean isValidCategory = false;
        for (String valid : validCategories) {
            if (valid.equalsIgnoreCase(category.trim())) {
                isValidCategory = true;
                break;
            }
        }
        if (!isValidCategory) {
            return false;
        }
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            return false;
        }
        return true;
    }

}
