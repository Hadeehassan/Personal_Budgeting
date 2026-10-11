package com.mcnz.jdbc.sqlserver;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Budget {
    private int budgetId;
    private int userId;
    private String category;
    private BigDecimal amount;
    private Timestamp createdAt;

    public Budget(int budgetId, int userId, String category, BigDecimal amount, Timestamp createdAt) {
        this.budgetId = budgetId;
        this.userId = userId;
        this.category = category;
        this.amount = amount;
        this.createdAt = createdAt;
    }

    public int getBudgetId() {
        return budgetId;
    }

    public int getUserId() {
        return userId;
    }

    public String getCategory() {
        return category;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

}
