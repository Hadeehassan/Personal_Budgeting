package com.mcnz.jdbc.sqlserver;
import java.math.BigDecimal;

public class ExpenseService {
    public boolean validateExpense(BigDecimal amount) {
        return amount != null && amount.compareTo(BigDecimal.ZERO) > 0;
    }
}
