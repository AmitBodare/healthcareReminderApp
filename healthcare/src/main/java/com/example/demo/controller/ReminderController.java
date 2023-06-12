package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Reminder;
import com.example.demo.service.ReminderService;

@Component
@RestController
public class ReminderController {
	
	@Autowired
	 private ReminderService reminderService;

	    
	    @Scheduled(fixedRate = 3000)
	    public void sendReminders() {
	        List<Reminder> reminders = reminderService.getPendingReminders();
	        LocalDateTime currentTime = LocalDateTime.now();

	        for (Reminder reminder : reminders) {
	            if (currentTime.isAfter(reminder.getTime())) {
	                reminderService.sendNotification(reminder);
	                reminder.setNotified(true);
	                reminderService.updateReminder(reminder);
	            }
	        }
	    }

}
