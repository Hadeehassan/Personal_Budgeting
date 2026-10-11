package com.mcnz.jdbc.sqlserver;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;

public class ReminderUI {
    ReminderRepository reminderRepository = new ReminderRepository();
    public void showReminderInput() {
        Scanner scanner = new Scanner(System.in);
        ReminderService R_service = new ReminderService();
        User currentUser = UserContext.getInstance().getCurrentUser();

        if (currentUser == null) {
            System.out.println("No user is currently logged in.");
            return;
        }

        System.out.print("Enter reminder title (e.g., Electricity Bill): ");
        String title = scanner.nextLine();

        System.out.print("Enter reminder date (yyyy-MM-dd): ");
        String dateStr = scanner.nextLine();

        System.out.print("Enter reminder time (HH:mm:ss): ");
        String timeStr = scanner.nextLine();
        String combinedDateTime = dateStr + " " + timeStr;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sdf.setTimeZone(TimeZone.getTimeZone("GMT+02:00"));
            Date reminderDate = sdf.parse(combinedDateTime);
            System.out.println("Time is: " + reminderDate);

            if (R_service.validateReminder(title, reminderDate)) {

                reminderRepository.saveReminder(currentUser.getId(), title, reminderDate);

                Reminder reminder = new Reminder(currentUser.getId(), title, reminderDate);
                ReminderNotification reminderNotification = new ReminderNotification();
                reminderNotification.sendNotification(reminder);

                System.out.println("Reminder saved successfully!");
            } else {
                System.out.println("Invalid reminder data.");
            }
        } catch (Exception e) {
            System.out.println("Error: Invalid date format. Please enter the date in the format yyyy-MM-dd and time in HH:mm:ss.");
        }
    }
    public void showReminders(){
        User currentUser = UserContext.getInstance().getCurrentUser();
        if (currentUser == null) {
            System.out.println("No user is currently logged in.");
            return;
        }
        System.out.println("Your Reminders:");
        reminderRepository.getReminders(currentUser.getId()).forEach(reminder -> {
            System.out.println("Title: " + reminder.getTitle());
            //System.out.println("Reminder_id: " + reminder.getReminderId());
            System.out.println("Reminder Date: " + reminder.getReminderDate());
            System.out.println("Created At: " + reminder.getCreatedAt());
            System.out.println("Notified: " + (reminder.isNotified() ? "Yes" : "No"));
            System.out.println("----------------------------");
        });
    }
}
