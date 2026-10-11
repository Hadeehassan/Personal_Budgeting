package com.mcnz.jdbc.sqlserver;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class IncomeMapper {
    public static Income map(ResultSet rs) throws SQLException {
        return new Income(
                rs.getInt("income_id"),
                rs.getDate("date"),
                rs.getBigDecimal("amount"),
                rs.getString("source"),
                rs.getInt("user_id")
        );
    }
}

