package com.scaler.springdemo1.tasks;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Task {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer id;
    String name;
    boolean done;
    
    public Task() {
		// TODO Auto-generated constructor stub
	}
    
	public Task(String name, boolean done) {
		super();
		this.name = name;
		this.done = done;
	}
    
    
}