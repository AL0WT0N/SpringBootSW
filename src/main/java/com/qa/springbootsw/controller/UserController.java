package com.qa.springbootsw.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springbootsw.domain.User;

@RestController
@RequestMapping("/user") // http://localhost:9000/user/...
public class UserController {

	// Temporary storage, until we implement a real database
	private List<User> users = new ArrayList<>();
	
	@GetMapping("/hello") // http://localhost:9000/user/hello
	public String helloWorld() {
		return "Hello, World";
	}
	
	// Create
	@PostMapping("/create")
	public User create(@RequestBody User user) {
		this.users.add(user);
		// Return last added User from list
		return this.users.get(this.users.size() - 1);
	}
	
	// Read
	@GetMapping("getAll")
	public List<User> getAll() {
		// return the whole list
		return this.users;
	}
	
	// Read by ID
	@GetMapping("/getOne/{id}")
	public User getOne(@PathVariable int id) {
		// Don't forget - ID is index, because we're using an array, not a database
		return this.users.get(id);
	}
	
	// Update
	@PutMapping("/update/{id}")
	public User update(@PathVariable int id, @RequestBody User user) {
		// Remove original user
		this.users.remove(id);
		// Add updated user
		this.users.add(id, user);
		// Return the updated user
		return this.users.get(id);
	}
	
	// Delete
	//@DeleteMapping
}
