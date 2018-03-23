package com.lyj.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.lyj.dao.ProductDao;
import com.lyj.dao.UserDao;
import com.lyj.model.Product;
import com.lyj.service.ProductService;

public class ProductServiceImpl implements ProductService{
	private ProductDao productDao;
	public ProductDao getProductDao() {
		return productDao;
	}
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	@Override
	public List<Product> findAll() {
		System.out.println("ProductService的findByPage()方法执行了....");
		List<Product> list = productDao.findAll();
		return list;
	}
	@Override
	public Product show(int pid) {
		System.out.println("ProductService的show()方法执行了。。。");
		Product product = productDao.show(pid);
		return product;
	}
	@Transactional
	public List<Product> findUnsoldForBuyer() {
		// TODO Auto-generated method stub
		List<Product> list = productDao.findUnsoldForBuyer();
		return list;
	}
	@Override
	public List<Product> account() {
		System.out.println("ProductService的account()方法执行了。。。");
		List<Product> list = productDao.account();
		return list;
	}
	@Override
	public void buy(int pid) {
		productDao.buy(pid);
		
	}
	@Override
	public Product findById(int pid) {
		Product product = productDao.findById(pid);
		return null;
	}
	@Override
	public void update(Product product) {
		productDao.update(product);
		
	}
	@Override
	public int add(Product product) {
		System.out.println("add==service执行了");
		int pid = productDao.add(product);
		return pid;
	}

	@Override
	public void delete(int pid) {
		// TODO Auto-generated method stub
		productDao.delete(pid);
	}
	@Override
	public void putCart(int pid) {
		// TODO Auto-generated method stub
		productDao.putCart(pid);
	}
	@Override
	public List<Product> findCart() {
		// TODO Auto-generated method stub
		List<Product> list = productDao.findCart();
		return list;
	}
	@Override
	public void buyCart(List<Product> list) {
		// TODO Auto-generated method stub
		productDao.buyCart(list);
	}
	

	
}
