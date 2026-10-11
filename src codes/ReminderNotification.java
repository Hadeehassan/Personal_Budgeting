package com.mcnz.jdbc.sqlserver;

import java.util.Timer;
import java.util.TimerTask;

/**
 * this class for send the notification to reminder the user about any important thing
 * @author Hady Hassan
 * @version 1.0
 */

public class ReminderNotification {
	
	/**
	 * Method that send notification
	 * @param reminder
	 * @return 
	 */
    public void sendNotification(Reminder reminder) {
        Timer timer = new Timer();
        long delay = reminder.getReminderDate().getTime() - System.currentTimeMillis();

        if (delay > 0) {
            timer.schedule(new TimerTask() {
                @Override
                public void run() {

                    System.out.println("Reminder: " + reminder.getTitle() + " is due now!");

                }
            }, delay);
        } else {
            System.out.println("Reminder time has already passed.");
        }
    }
}

