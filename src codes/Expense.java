package com.mcnz.jdbc.sqlserver;

import java.math.BigDecimal;
import java.util.Date;

public class Expense {
    private int expenseId;
    private int userId;
    private BigDecimal amount;
    private String category;
    private Date date;

    public Expense(int expenseId, Date date, BigDecimal amount, String category, int userId) {
        this.expenseId = expenseId;
        this.date = date;
        this.amount = amount;
        this.category = category;
        this.userId = userId;
    }

    public int getExpenseId() { return expenseId; }
    public Date getDate() { return date; }
    public BigDecimal getAmount() { return amount; }
    public String getCategory() { return category; }
    public int getUserId() { return userId; }
}
