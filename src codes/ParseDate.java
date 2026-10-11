package com.mcnz.jdbc.sqlserver;

import java.sql.SQLException;

public class ParseDate {
    public static java.sql.Date parseDate(String dateStr) throws SQLException {
        try {
            return java.sql.Date.valueOf(dateStr);
        } catch (IllegalArgumentException e) {
            throw new SQLException("Invalid date format. Expected format is yyyy-MM-dd.");
        }
    }
}
