package com.mcnz.jdbc.sqlserver;

/**
 * Class for logIn if user have an account in the system
 * @author abdallah kareem
 * @version 1.0
 */
public class LogIn {
    private final CredentialValidator validator;
    private final UserRepository userRepository;
    private final SessionManager sessionManager;
    
    public LogIn(CredentialValidator validator, UserRepository userRepository, SessionManager sessionManager) {
        this.validator = validator;
        this.userRepository = userRepository;
        this.sessionManager = sessionManager;
    }
    
    /**
     * 
     * @param username
     * @param password
     * @return boolean
     */
    public boolean signIn(String username, String password) {

        if (!validator.validate(username, password)) {
            System.out.println(" Invalid username or password format.");
            return false;
        }
        User user = userRepository.getUserFromDatabase(username, password);
        if (user != null) {
            sessionManager.setCurrentUser(user);
            System.out.println(" Login successful.");
            return true;
        } else {
            System.out.println("Username or password is incorrect.");
            return false;
        }
    }
}
