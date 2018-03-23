package com.lyj.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.lyj.dao.ProductDao;
import com.lyj.model.Product;

public class ProductDaoImpl implements ProductDao{
	
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public List<Product> findAll() {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "from Product";
		org.hibernate.Query query = session.createQuery(hql);
		List<Product> list = query.list();
		return list;
	}
	
	@Transactional
	public Product show(int pid) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "from Product where pid = ?";
		org.hibernate.Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, pid);
		List<Product> list = query.list();
		Product product = list.get(0);
		return product;
	}

	@Transactional
	public List<Product> findUnsoldForBuyer() {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "from Product where sold = ?";
		org.hibernate.Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, false);
		List<Product> list = query.list();
		return list;
	}

	@Transactional
	public List<Product> account() {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "from Product where sold = ?";
		org.hibernate.Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, true);
		List<Product> list = query.list();
		return list;
	}

	@Transactional
	public void buy(int pid) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "update Product p set p.sold = ?, p.time = ? where pid = ?";
		org.hibernate.Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, true);
		query.setParameter(1, new Timestamp(System.currentTimeMillis()));
		query.setParameter(2, pid);
		query.executeUpdate();
		
	}

	@Transactional
	public Product findById(int pid) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "from Product where pid = ?";
		org.hibernate.Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, pid);
		List<Product> list = query.list();
		Product product = list.get(0);
		return product;
	}

	@Transactional
	public void update(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.update(product);
	}

	@Transactional
	public int add(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.save(product);
		return product.getPid();
	}
	@Transactional
	public void delete(int pid) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Product product = (Product) session.get(Product.class, pid);
		session.delete(product);
	}

	@Transactional
	public void putCart(int pid) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Product product = (Product) session.get(Product.class, pid);
		String hql = "update Product p set p.cart = ? where pid = ?";
		org.hibernate.Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, true);
		query.setParameter(1, pid);
		query.executeUpdate();
	}

	@Transactional
	public List<Product> findCart() {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "from Product where cart = ?";
		org.hibernate.Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, true);
		List<Product> list = query.list();
		return list;
	}

	@Transactional
	public void buyCart(List<Product> list) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		int pid;
		String hql = "update Product p set p.sold = ? , p.cart= ? where pid = ?";
		org.hibernate.Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, true);
		query.setParameter(1, false);
		for(Product product:list){
			pid = product.getPid();
			query.setParameter(2, pid);
			query.executeUpdate();
		}
		
		
		
		
	}

	
	
	
	

	
}
