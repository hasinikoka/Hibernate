package com.jnit.Hibernateapp;

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

import com.jnit.Hibernateapp.Employee;

@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long taskId;
	private String name;
	private String description;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade =
        { CascadeType.DETACH,
                CascadeType.MERGE,
                CascadeType.REFRESH,
                CascadeType.PERSIST
        },targetEntity=Employee.class)
	@JoinTable(name = "Employee_Task", joinColumns = {
			@JoinColumn(name = "taskId", nullable = false) }, inverseJoinColumns = {
			@JoinColumn(name = "employeeId", nullable = false) })
	private List<Employee> employees = new ArrayList<>();
	

	private LocalDateTime createdDateTime;

	@Version
	private LocalDateTime updatedDateTime;
	
	public Task( String name,String description){
		super();
		this.name=name;
		this.description=description;
		this.createdDateTime = LocalDateTime.now();
		this.updatedDateTime = LocalDateTime.now();
		
	}
	
	public Task(){
		super();
	}

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Employee> getStudents() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
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

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", name=" + name + ", description=" + description + ", createdDateTime="
				+ createdDateTime + ", updatedDateTime=" + updatedDateTime + "]";
	}

}
