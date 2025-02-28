package com.companionly.prototype.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ReminderService {
	
	  @Scheduled(cron = "0 0 23 * * ?")  // Runs at 8 PM every day
	    public void sendReminder() {
	        // Logic to send reminders (email, notification, etc.)
	        System.out.println("Reminder: Don't forget to log your mood!");
	    }

}
