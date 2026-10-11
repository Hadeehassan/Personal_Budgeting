package com.mcnz.jdbc.sqlserver;

public class signUpService {
    private AccountController accountController = new AccountController();
    private final SignUpUserRepository signUpUserRepository = new SignUpUserRepository();

    public boolean validate(String email, String username, String password){
        return accountController.validateCredentials(email,username,password);
    }
    public String sendOTP(String email) {
        return accountController.sendOTP(email);
    }
    public boolean verifyOTP(String inputOtp, String realOtp) {
        return accountController.verifyOTP(inputOtp, realOtp);
    }
    public User registerUser(String email, String username, String password) {
        User user = accountController.registerUser(email, username, password);
        signUpUserRepository.save(user);
        UserContext.getInstance().setCurrentUser(user);
        return user;
    }

}
