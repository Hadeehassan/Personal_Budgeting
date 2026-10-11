package com.mcnz.jdbc.sqlserver;

public class SessionManager {
    public void setCurrentUser(User user) {
        UserContext.getInstance().setCurrentUser(user);
    }

    public User getCurrentUser() {
        return UserContext.getInstance().getCurrentUser();
    }
}
