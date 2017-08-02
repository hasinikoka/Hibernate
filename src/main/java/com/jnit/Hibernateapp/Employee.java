package com.jnit.Hibernateapp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.Version;



import com.jnit.Hibernateapp.Task;




@Entity

public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long employeeId;
	

	private String fName;
	private String lName;
	
	private LocalDateTime createdDateTime;

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public LocalDateTime getUpdatedDateTime() {
		return updatedDateTime;
	}

	public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}

	public List<Task> getCourses() {
		return tasks;
	}

	public void setCourses(List<Task> courses) {
		this.tasks = courses;
	}
	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	@Version
	private LocalDateTime updatedDateTime;

	@ManyToMany(fetch = FetchType.LAZY,cascade =
        {
                CascadeType.DETACH,
                CascadeType.MERGE,
                CascadeType.REFRESH,
                CascadeType.PERSIST
        }, targetEntity=Task.class)
	@JoinTable(name = "Employee_Task", joinColumns = {
			@JoinColumn(name = "employeeId", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "taskId", nullable = false) 
	})	
	private List<Task> tasks = new ArrayList<>();
	
	public Employee(){
		super();
	}
	
	public Employee(String fname, String lName){
		
		this.fName=fname;
		this.lName=lName;
		this.createdDateTime = LocalDateTime.now();
		this.updatedDateTime = LocalDateTime.now();
		
	}

}
