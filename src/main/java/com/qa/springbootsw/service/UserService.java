package com.qa.springbootsw.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.springbootsw.domain.User;

@Service
public class UserService {

	// Temporary storage, until we implement a real database
	private List<User> users = new ArrayList<>();
	
	// Create
	public User create(User user) {
		this.users.add(user);
		return this.users.get(this.users.size() - 1);
	}
	
	// Read All
	public List<User> getAll() {
		// Return the whole list
		return this.users;
	}
	
	// Read One
	public User getOne(int id) {
		return this.users.get(id);
	}
	
	// Update
    public User update(int id, User user) {
    	// Remove original user
		this.users.remove(id);
		// Add updated user
		this.users.add(id, user);
		// Return the updated user
		return this.users.get(id);
    }

    public User delete(int id) {
        // Remove User and return it
        return this.users.remove(id);
    }
}
