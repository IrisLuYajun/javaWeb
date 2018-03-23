package com.lyj.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;


import com.lyj.dao.UserDao;
import com.lyj.model.User;

public class UserDaoImpl implements UserDao{
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	/*
	 * 验证：DAO中根据用户名和密码查询用户
	 */
	@Override
	public User findByNameAndPassword(User user) {
		System.out.println("Dao中的findByNameAndPassword执行了....");
		String hql = "from User where username = ? and password = ?";
		org.hibernate.Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, user.getUsername());
		query.setParameter(1, user.getPassword());
		List<User> list = query.list();
		//sessionFactory.close();
		if(list.size() > 0) {
			return list.get(0);
		} else{
			return null;
		}
	}

}
