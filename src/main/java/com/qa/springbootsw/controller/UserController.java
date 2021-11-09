package com.qa.springbootsw.controller;

import java.util.ArrayList;
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
		
		// Return Response Entity containing the user and the correct response entity
		return new ResponseEntity<User>(this.service.create(user), HttpStatus.CREATED);

//		We also have the option to add some conditional logic and return either a positive or negative status code
		
//		if (this.users.add(user)) {
//			return new ResponseEntity<User>(this.users.get(this.users.size() - 1), HttpStatus.CREATED);
//		} else {
//			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
// 		}
		
// 		The conditional above can be written using a 'ternary if' like so:		
		
//		return this.users.add(user) ? new ResponseEntity<User>(this.users.get(this.users.size() - 1), HttpStatus.CREATED)
//				: new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// Read
	@GetMapping("/getAll")
	public ResponseEntity<List<User>> getAll() {
		// return a Response Entity containing the whole list
		return new ResponseEntity<List<User>>(this.service.getAll(), HttpStatus.OK);
	}
	
	// Read by ID
	@GetMapping("/getOne/{id}")
	public ResponseEntity<User> getOne(@PathVariable int id) {
		return new ResponseEntity<User>(this.service.getOne(id), HttpStatus.OK);
	}
	
	// Update
	@PutMapping("/update/{id}")
	public ResponseEntity<User> update(@PathVariable int id, @RequestBody User user) {
		return new ResponseEntity<User>(this.service.update(id, user), HttpStatus.ACCEPTED);
	}
	
	// Delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<User> delete(@PathVariable int id) {
		return new ResponseEntity<User>(this.service.delete(id), HttpStatus.NO_CONTENT);
	}
}
