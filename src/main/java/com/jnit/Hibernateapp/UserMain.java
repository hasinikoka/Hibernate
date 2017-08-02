package com.jnit.Hibernateapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.Hibernate.util.HibernateUtil;


public class UserMain {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		Transaction tran = s.beginTransaction();
		//User user = new User();
		//user.setUserName("@gmail.com");
		//s.save(user);
		//tran.commit();
		//User user = s.load(User.class, 1L);
		User user = s.get(User.class, 1L);
		System.out.println(user.getUserName());
		user.setUserName("hk@gmail.com");
		s.update(user);
		tran.commit();
		s.close();
		sf.close();

	}

}
