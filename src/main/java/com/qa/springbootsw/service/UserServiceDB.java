package com.qa.springbootsw.service;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.qa.springbootsw.domain.User;
import com.qa.springbootsw.exceptions.UserNotFoundException;
import com.qa.springbootsw.repo.UserRepo;

@Primary
@Service
public class UserServiceDB implements UserService {

	private UserRepo repo;

	public UserServiceDB(UserRepo repo) {
		super();
		this.repo = repo;
	}

	// Create
	@Override
	public User create(User user) {
		return this.repo.saveAndFlush(user);
	}

	// Read All
	@Override
	public List<User> getAll() {
		return this.repo.findAll();
	}

	// Read By Id
	@Override
	public User getById(Long id) {
		return this.repo.findById(id).orElseThrow(UserNotFoundException::new);
	}

	// Custom Query - Find by username
	@Override
	public User getByUsername(String username) {
		return this.repo.findByUsername(username).get();
	}

	// Update
	@Override
	public User update(Long id, User user) {
		User existing = this.repo.findById(id).get();
		existing.setFirstName(user.getFirstName());
		existing.setLastName(user.getLastName());
		existing.setUsername(user.getUsername());
		return this.repo.saveAndFlush(existing);
	}

	@Override
	public boolean delete(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
}
