package com.qa.springbootsw.service;

import java.util.List;

import com.qa.springbootsw.domain.User;

public interface UserService {

	// Create
	public User create(User user);

	// Read All
	public List<User> getAll();

	// Read By Id
	public User getById(Long id);

	// Custom Query - Find by username
	public User getByUsername(String username);

	// Update
	public User update(Long id, User user);

	public boolean delete(Long id);

}
