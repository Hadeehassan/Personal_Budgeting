package com.mcnz.jdbc.sqlserver;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExpenseRepository {
    public void saveExpense(int userId, String category, String date, BigDecimal amount) {
        String sql = "INSERT INTO Expenses(user_id, category, amount, date) VALUES (?, ?, ?, ?)";

        try (Connection con = SqlServerConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, userId);
            pstmt.setString(2, category);
            pstmt.setBigDecimal(3, amount);
            pstmt.setDate(4, ParseDate.parseDate(date));

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Failed to save expense, no rows affected.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error saving expense", e);
        }
    }
    public List<Expense> getExpenses(int userId) {
        List<Expense> expenses = new ArrayList<>();
        String sql = "SELECT * FROM Expenses WHERE user_id = ?";

        try (Connection con = SqlServerConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                expenses.add(ExpenseMapper.map(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error retrieving expenses", e);
        }

        return expenses;
    }



}
