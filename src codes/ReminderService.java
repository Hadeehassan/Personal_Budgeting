package com.mcnz.jdbc.sqlserver;

import java.util.Date;

/**
 * To check the validation of the remainders
 * @author Hady Hassan
 * @version 1.0
 */

public class ReminderService {
	/**
	 * 
	 * @param title
	 * @param reminderDate
	 * @return bool
	 */
    public boolean validateReminder(String title, Date reminderDate) {
        if (title == null || title.isEmpty()||title.length()<3||title.length()>50) {
            System.out.println("Reminder title Invalid.");
            return false;
        }

        if (reminderDate == null) {
            System.out.println("Reminder date cannot be null.");
            return false;
        }


        Date currentDate = new Date();
        if (reminderDate.before(currentDate)) {
            System.out.println("Reminder date must be in the future.");
            return false;
        }

        return true;
    }


}
