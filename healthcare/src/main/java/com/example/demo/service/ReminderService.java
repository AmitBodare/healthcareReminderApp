package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Reminder;
import com.example.demo.repository.ReminderRepo;

@Service
public class ReminderService {
	
	@Autowired
	private  ReminderRepo reminderRepository;

    public List<Reminder> getPendingReminders() {
        return reminderRepository.findByNotifiedFalse();
    }

    public void sendNotification(Reminder reminder) {
        
        System.out.println("Sending notification for reminder: " + reminder.getActivity());
    }

    public void updateReminder(Reminder reminder) {
        reminderRepository.save(reminder);
    }

}
