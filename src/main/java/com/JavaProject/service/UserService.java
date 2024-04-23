package com.JavaProject.service;

import com.JavaProject.entity.User;

public interface UserService {

	public User saveUser(User user);

	public void removeSessionMessage();

	User getUserByEmail(String email);

}
