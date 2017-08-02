package com.jnit.Hibernateapp;

import org.hibernate.Session;

import org.hibernate.SessionFactory;

import com.Hibernate.util.HibernateUtil;

public class EmployeeTaskMain {
	
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session =sf.openSession();
		session.beginTransaction();
		
		Employee employee = new Employee();
		employee.setfName("hasini");
		employee.setlName("koka");		
		
		
		Task task = new Task();
		task.setName("task 1");
		task.setDescription("Hibernate");
		
		Task task2 = new Task();
		task.setName("task 2");
		task2.setDescription("Spring");
		
		
		employee.getTasks().add(task);
		employee.getTasks().add(task2);
		
		session.save(employee);
		session.save(task);
		session.save(task2);
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
}
	
