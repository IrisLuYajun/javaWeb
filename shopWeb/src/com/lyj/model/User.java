package com.lyj.model;

import java.util.HashSet;
import java.util.Set;
/*
 *用户的实体类
 */
public class User {
	private boolean isbuyer; //是否是买家
	private String username;
	private String password;
	private int uid;//id号
	//private Set<Product> products = new HashSet<Product>();//已购买/售出的商品
	
	
	public boolean getIsbuyer() {
		return isbuyer;
	}
	public void setIsbuyer(boolean isbuyer) {
		this.isbuyer = isbuyer;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	/*public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}*/
	
}
