package com.Hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.Hibernate.util.HibernateUtil;
import com.jnit.Hibernateapp.Address;
import com.jnit.Hibernateapp.Customer;


public class CustomerMain {
	
	public static void getCustomer()
	{
		SessionFactory sf =HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		Customer c = (Customer) s.get(Customer.class, 9);
		System.out.println(c);
		s.close();
		sf.close();
	}
	
	public static void insertCustomer()
	{
		SessionFactory sf =HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		Customer c =new Customer();
		c.setName("likitha");
		Transaction t = s.beginTransaction();
		s.save(c);
		t.commit();
		s.close();
		sf.close();
	}
	
	public static void insertCustomerAddress(){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		Customer c = new Customer();
		c.setName("John");
		Address address = new Address();
		address.setStreet("View");
		address.setCity("Lew");
		address.setState("TX");
		address.setZipCode("1234");
		c.setAddress(address);
		address.setCustomer(c);
		Transaction t = s.beginTransaction();
		s.save(c);
		t.commit();
		s.close();
		sf.close();
	}
	
	public static void updateCustomer()
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		Customer c =(Customer) s.load(Customer.class, 9);
		Transaction t = s.beginTransaction();
		c.setName("Hasini");
		s.update(c);
		t.commit();
		s.close();
		sf.close();
	}

	public static void main(String[] args) {
		
		insertCustomer();
		//updateCustomer();
		//getCustomer();
		//insertCustomerAddress();
		
	}
}

