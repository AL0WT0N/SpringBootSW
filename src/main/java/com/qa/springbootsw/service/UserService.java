package com.qa.springbootsw.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.qa.springbootsw.domain.User;
import com.qa.springbootsw.exceptions.UserNotFoundException;
import com.qa.springbootsw.repo.UserRepo;

@Service
public class UserService {

	private UserRepo repo;
	
	public UserService(UserRepo repo) {
		this.repo = repo;
	}
	
	// Create
	public User create(User user) {
		return this.repo.saveAndFlush(user);
	}
	
	// Read All
	public List<User> getAll() {
		return this.repo.findAll();
	}
	
	// Read By Id
	public User getById(Long id) {
		return this.repo.findById(id).orElseThrow(UserNotFoundException::new);
	}
	
	// Custom Query - Find by username
	public User getByUsername(String username) {
		return this.repo.findByUsername(username).get();
	}
	
	// Update
    public User update(Long id, User user) {
    	User existing = this.repo.findById(id).get();
    	existing.setFirstName(user.getFirstName());
    	existing.setLastName(user.getLastName());
    	existing.setUsername(user.getUsername());
    	return this.repo.saveAndFlush(existing);
    }

    public boolean delete(Long id) {
        this.repo.deleteById(id);
        return !this.repo.existsById(id);
    }
}
