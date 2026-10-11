package com.mcnz.jdbc.sqlserver;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class ExpenseMapper {
    public static Expense map(ResultSet rs) throws SQLException {
        int expenseId = rs.getInt("expense_id");
        String category = rs.getString("category");
        BigDecimal amount = rs.getBigDecimal("amount");
        Date date = rs.getDate("date");
        int userId = rs.getInt("user_id");

        return new Expense(expenseId, date, amount, category, userId);
    }
}
