package com.mcnz.jdbc.sqlserver;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class for save income and get from database with MSSQL
 * @author Hady Hassan 
 * @version 1.0 
 */
public class IncomeRepository {
	
	/**
	 * 
	 * @param userId
	 * @param source
	 * @param date
	 * @param amount
	 * @return
	 * @throws SQLException
	 */
    public void saveIncome(int userId, String source, String date, BigDecimal amount) {
        String sql = "INSERT INTO Income(user_id, source, amount, date) VALUES (?, ?, ?, ?)";

        try (Connection con = SqlServerConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, userId);
            pstmt.setString(2, source);
            pstmt.setBigDecimal(3, amount);
            pstmt.setDate(4, ParseDate.parseDate(date));

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Failed to save income, no rows affected.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error saving income", e);
        }
    }
    
    /**
     * 
     * @param userId
     * @return list of incomes
     * @throws SQLException
     */
    public List<Income> getIncomes(int userId) {
        List<Income> incomes = new ArrayList<>();
        String sql = "SELECT * FROM Income WHERE user_id = ?";

        try (Connection con = SqlServerConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                incomes.add(IncomeMapper.map(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error retrieving incomes", e);
        }

        return incomes;
    }

}
