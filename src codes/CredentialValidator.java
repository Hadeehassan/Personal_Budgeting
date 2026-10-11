package com.mcnz.jdbc.sqlserver;

public class CredentialValidator {
    public boolean validate(String username, String password) {
        return username != null && !username.trim().isEmpty()
                && password != null && password.length() >= 6;
    }
}
