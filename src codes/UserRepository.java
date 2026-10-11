package com.mcnz.jdbc.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * This class for get the data of the user from database using jar files with MSSQL
 * @author abdallah kareem
 * @version 1.0
 */

public class UserRepository {
    public User getUserFromDatabase(String username, String password) {
        String sql = "SELECT * FROM Users WHERE username = ? AND password = ?";

        try (Connection con = SqlServerConnection.getConnection()) {
            if (con == null) {
                System.err.println("Failed to connect to the database. Connection is null.");
                return null;
            }

            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setString(1, username);
                pstmt.setString(2, password);

                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    int userId = rs.getInt("userId");
                    String email = rs.getString("email");
                    return new User(userId, email, username, password);
                }
            }
        } catch (Exception e) {
            System.err.println("Database error occurred while logging in:");
            e.printStackTrace();
        }
        return null;
    }
}
