package com.lyj.model;

import java.util.HashSet;
import java.util.Set;
/*
 *�û���ʵ����
 */
public class User {
	private boolean isbuyer; //�Ƿ������
	private String username;
	private String password;
	private int uid;//id��
	//private Set<Product> products = new HashSet<Product>();//�ѹ���/�۳�����Ʒ
	
	
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
