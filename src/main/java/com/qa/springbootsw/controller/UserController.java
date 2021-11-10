package com.qa.springbootsw.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springbootsw.domain.User;
import com.qa.springbootsw.service.UserService;

//200 - OK, 201 - Created, 202 - Accepted, 204 - No Content
//400 - Bad Request, 404 - Not Found, 500 - Internal Server Error

@RestController
@RequestMapping("/user") // http://localhost:9000/user/...
public class UserController {

	private UserService service;
	
	// Constructor Injection
	public UserController(UserService service) {
		this.service = service;
	}

	// Create
	@PostMapping("/create")
	public ResponseEntity<User> create(@RequestBody User user) {
		return new ResponseEntity<User>(this.service.create(user), HttpStatus.CREATED);
	}
	
	// Read
	@GetMapping("/getAll")
	public ResponseEntity<List<User>> getAll() {
		return new ResponseEntity<List<User>>(this.service.getAll(), HttpStatus.OK);
	}
	
	// Read by ID
	@GetMapping("/getById/{id}")
	public ResponseEntity<User> getOne(@PathVariable Long id) {
		return new ResponseEntity<User>(this.service.getById(id), HttpStatus.OK);
	}
	
	// Update
	@PutMapping("/update/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
		return new ResponseEntity<User>(this.service.update(id, user), HttpStatus.ACCEPTED);
	}
	
	// Delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<User> delete(@PathVariable Long id) {
		return this.service.delete(id) ? new ResponseEntity<User>(HttpStatus.NO_CONTENT) 
				: new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
