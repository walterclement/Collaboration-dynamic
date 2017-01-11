package com.blogback.services;

import java.util.List;

import com.blogback.model.User;

public interface UserService {
	List<User> getAllUsers();
	User registerUser(User user);

}
