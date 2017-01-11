package com.blogback.dao;

import java.util.List;

import com.blogback.model.User;

public interface UserDao {
	User authenticate(User user);
	void updateUser(User user);
	List<User> getAllUsers();
	User registerUser(User user);
}
