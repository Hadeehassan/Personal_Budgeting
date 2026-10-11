package com.mcnz.jdbc.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignUpUserRepository {
    public void save(User user) {
        String sql = "INSERT INTO Users (username, email, password) VALUES (?, ?, ?)";

        try (Connection con = SqlServerConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected == 0) {
                System.out.println(" No rows affected. User not saved.");
            }

        } catch (SQLException e) {
            System.out.println(" Database error: " + e.getMessage());
        }
    }

}
