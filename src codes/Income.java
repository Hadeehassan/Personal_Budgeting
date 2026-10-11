package com.mcnz.jdbc.sqlserver;
import java.math.BigDecimal;
import java.util.Date;


public class Income {
    private int incomeId;
    private int userID;
    private  BigDecimal salary;
    private String sorce;
    private Date date;

    public Income(int incomeId,Date date, BigDecimal salary, String sorce, int userID) {
        this.incomeId=incomeId;
        this.date = date;
        this.salary = salary;
        this.sorce = sorce;
        this.userID = userID;
    }

    public int getIncomeId() {
        return incomeId;
    }
    public Date getDate() {
        return date;
    }
    public BigDecimal getSalary() {
        return salary;
    }
    public String getSource() {
        return sorce;
    }
    public int getUserID() {
        return userID;
    }
}

