package com.example.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reminder")
public class Reminder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

    private LocalDateTime time;
    private String activity;
    private boolean notified;
    
    
	public Reminder() {
		super();
	}


	public Reminder(LocalDateTime time, String activity) {
		super();
		this.time = time;
		this.activity = activity;
		this.notified=false;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public LocalDateTime getTime() {
		return time;
	}


	public void setTime(LocalDateTime time) {
		this.time = time;
	}


	public String getActivity() {
		return activity;
	}


	public void setActivity(String activity) {
		this.activity = activity;
	}


	public boolean isNotified() {
		return notified;
	}


	public void setNotified(boolean notified) {
		this.notified = notified;
	}
	
	
    
	
    

}
