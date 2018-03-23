package com.lyj.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.lyj.dao.UserDao;
import com.lyj.model.User;
import com.lyj.service.UserService;


public class UserServiceImpl implements UserService{

	private UserDao userDao;
	
		public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}



	/*
	 * ҵ���ĵ�¼����
	 */
	@Transactional
	public User login(User user) {
		System.out.println("Service�е�loginִ����....");
		User exitsEmployee = userDao.findByNameAndPassword(user);
		return exitsEmployee;
	}
}
