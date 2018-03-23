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
	 * ��֤��DAO�и����û����������ѯ�û�
	 */
	@Override
	public User findByNameAndPassword(User user) {
		System.out.println("Dao�е�findByNameAndPasswordִ����....");
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
