package com.lyj.dao;

import com.lyj.model.User;

public interface UserDao {
	User findByNameAndPassword(User user);
}
