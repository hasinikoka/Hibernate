package com.Hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.Hibernate.util.HibernateUtil;
import com.jnit.Hibernateapp.Order;
import com.jnit.Hibernateapp.User;

public class UserMain {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		User u = new User();
		u.setUserName("kavya");

		Order o1 = new Order();
		o1.setItem("headset");
		o1.setUser(u);

		Order o2 = new Order();
		o2.setItem("desktop");
		o2.setUser(u);

		List<Order> orders = new ArrayList<Order>();
		orders.add(o1);
		orders.add(o2);
		u.setOrdersPlaced(orders);
		Transaction t = s.beginTransaction();
		s.save(u);
		t.commit();
		s.close();
		sf.close();

	}

}
