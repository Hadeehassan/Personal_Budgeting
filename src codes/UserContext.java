package com.mcnz.jdbc.sqlserver;

/**
 * Singleton class for managing the authenticated user context.
 * Stores the current logged-in user and their authentication status.
 * 
 * This class ensures that the user's session information can be accessed globally
 * within the application during runtime.
 * 
 * @author abdallah kareem
 * @version 1.0
 */

public class UserContext {
    private static UserContext instance;
    private User currentUser;
    private boolean isAuthenticated;

    public UserContext() {}

    public static UserContext getInstance() {
        if (instance == null) {
            instance = new UserContext();
        }
        return instance;
    }

    public void setCurrentUser(User user) {
        this.currentUser = user;
        this.isAuthenticated = true;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public boolean isAuthenticated() {
        return isAuthenticated;
    }
}
