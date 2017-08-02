package com.jnit.Hibernateapp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	private String userName;
	@OneToMany(mappedBy = "user", cascade= CascadeType.ALL)
	@OrderColumn
	private List<Order> ordersPlaced = new ArrayList<Order>();


	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Order> getOrdersPlaced() {
		return ordersPlaced;
	}

	public void setOrdersPlaced(List<Order> ordersPlaced) {
		this.ordersPlaced = ordersPlaced;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", ordersPlaced=" + ordersPlaced + "]";
	}

}
