package com.JavaProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JavaProject.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	public User findByEmail(String emaill);

}
