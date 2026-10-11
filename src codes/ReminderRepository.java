package com.mcnz.jdbc.sqlserver;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class for save and get remainders from database
 * @author Hady Hassan
 * @version 1.0
 */

public class ReminderRepository {
	/**
	 * Save Remainders Method
	 * @param userId
	 * @param title
	 * @param reminderDate
	 * @return
	 * @throws SQLException
	 */
	
    public void saveReminder(int userId, String title, Date reminderDate) {
        String sql = "INSERT INTO Reminders (user_id, title, reminder_date) VALUES (?, ?, ?)";
        try (Connection con = SqlServerConnection.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            pstmt.setString(2, title);
            pstmt.setTimestamp(3, new Timestamp(reminderDate.getTime()));
            int result = pstmt.executeUpdate();
            if (result == 0) {
                throw new SQLException("Failed to save reminder, no rows affected.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error saving reminder", e);
        }
    }
    
    
    /**
     * get all remainders
     * @param userId
     * @return
     * @throws SQLException
     */
    public List<Reminder> getReminders(int userId){
        List<Reminder>reminders=new ArrayList<>();
        String sql ="select * from Reminders where user_id = ? ";
        try (Connection con = SqlServerConnection.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setInt(1,userId);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                int reminderId = rs.getInt("reminder_id");
                String title = rs.getString("title");
                Date reminderDate = rs.getTimestamp("reminder_date");
                Date createdAt = rs.getTimestamp("created_at");
                boolean notified = rs.getBoolean("notified");
                reminders.add(new Reminder(createdAt,notified,reminderDate,reminderId,title,userId));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException("Error retrieving reminders", e);
        }
        return reminders ;
    }
}
