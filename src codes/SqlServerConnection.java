package com.mcnz.jdbc.sqlserver;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * The class for the connection of the database with MSSQL
 * @author abdallah kareem
 * @version 1.0
 */

public class SqlServerConnection {

    static final String JDBC_URL = "jdbc:sqlserver://localhost:1433;databaseName=Personal Budgeting";
    static final String USERNAME = "project";
    static final String PASSWORD = "01234";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(JDBC_URL,USERNAME,PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
