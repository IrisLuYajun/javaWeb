package com.lyj.model;
import java.sql.Date;
import java.sql.Timestamp;

/*
 *商品的实体类
 */
public class Product {
	private int pid;
	private String title;
	private String info;
	private double price;
	private String detail;
	private String imgUrl;//图片
	private boolean sold;//是否售出
	private Timestamp time;//售出时间
	private boolean cart;//是否在购物车
	public boolean getCart() {
		return cart;
	}
	public void setCart(boolean cart) {
		this.cart = cart;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public boolean getSold() {
		return sold;
	}
	public void setSold(boolean sold) {
		this.sold = sold;
	}

	
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
		
	
}
