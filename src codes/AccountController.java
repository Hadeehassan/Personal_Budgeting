package com.mcnz.jdbc.sqlserver;

/**
 * Verify the OTP and valid the email and name and pass
 * @author abdallah kareem
 * @version 1.0
 */

public class AccountController {

	/**
	 * Validate somethings of the data
	 * @param email
	 * @param username
	 * @param password
	 * @return boolean
	 */
    public boolean validateCredentials(String email, String username, String password) {
        return email.contains("@") && username.length() >= 3 && password.length() >= 6;
    }
    public String sendOTP(String phone) {
        return "123456";  
    }

    public boolean verifyOTP(String inputOTP, String actualOTP) {
        return inputOTP.equals(actualOTP);
    }

    public User registerUser(String email, String username, String password) {
        return new User(email, username, password);
    }
}
