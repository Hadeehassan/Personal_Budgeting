package com.mcnz.jdbc.sqlserver;
import java.util.Date;

public class Reminder {
    private int reminderId;
    private int userId;
    private String title;
    private Date reminderDate;
    private Date createdAt;
    private boolean notified;

    public Reminder(Date createdAt, boolean notified, Date reminderDate, int reminderId, String title, int userId) {
        this.createdAt = createdAt;
        this.notified = notified;
        this.reminderDate = reminderDate;
        this.reminderId = reminderId;
        this.title = title;
        this.userId = userId;
    }
    public Reminder(int userId, String title, Date reminderDate) {
        this.userId = userId;
        this.title = title;
        this.reminderDate = reminderDate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public boolean isNotified() {
        return notified;
    }

    public Date getReminderDate() {
        return reminderDate;
    }

    public int getReminderId() {
        return reminderId;
    }

    public String getTitle() {
        return title;
    }

    public int getUserId() {
        return userId;
    }
}

