package com.mcnz.jdbc.sqlserver;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BudgetRepository {

    public List<Budget> getBudgets(int userId){
        List<Budget>budgets=new ArrayList<>();

        String sql = " select * from Budgets where  user_id = ?";
        try(Connection con=SqlServerConnection.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1,userId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                int budgetId = rs.getInt("budget_id");
                String category = rs.getString("category");
                BigDecimal amount = rs.getBigDecimal("amount");
                Timestamp createdAt = rs.getTimestamp("created_at");

                budgets.add(new Budget(budgetId, userId, category, amount, createdAt));
            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return budgets;
    }
    public void saveBudget(int userID, String category, BigDecimal amount) {
        String sql = "INSERT INTO Budgets (user_id, category, amount) VALUES (?, ?, ?)";

        try (Connection con = SqlServerConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, userID);
            pstmt.setString(2, category);
            pstmt.setBigDecimal(3, amount);

            int run = pstmt.executeUpdate();
            if (run == 0) {
                throw new SQLException("Failed to save Budget ;)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error saving Budget", e);
        }
    }
}
