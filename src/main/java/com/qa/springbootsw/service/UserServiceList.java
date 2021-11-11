package com.qa.springbootsw.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.springbootsw.domain.User;

@Service
public class UserServiceList implements UserService {

	private List<User> users = new ArrayList<>();

	// Create
	@Override
	public User create(User user) {
		this.users.add(user);
		return this.users.get(this.users.size() - 1);
	}

	// Read All
	@Override
	public List<User> getAll() {
		return null;
	}

	// Read By Id
	@Override
	public User getById(Long id) {
		return null;
	}

	// Custom Query - Find by username
	@Override
	public User getByUsername(String username) {
		return null;
	}

	// Update
	@Override
	public User update(Long id, User user) {
		return null;
	}

	@Override
	public boolean delete(Long id) {
		return false;
	}
}
