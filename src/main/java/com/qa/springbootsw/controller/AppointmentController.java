package com.qa.springbootsw.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springbootsw.domain.Appointment;
import com.qa.springbootsw.dto.AppointmentWithUsernameDTO;
import com.qa.springbootsw.service.AppointmentService;

@RestController
@RequestMapping("/appointments") // http://localhost:9000/appointments/...
public class AppointmentController {

	private AppointmentService service;
	
	public AppointmentController(AppointmentService service) {
		this.service = service;
	}

	// Create
	@PostMapping("/create")
	public ResponseEntity<Appointment> create(@RequestBody Appointment Appointment) {
		return new ResponseEntity<Appointment>(this.service.create(Appointment), HttpStatus.CREATED);
	}
	
	// Read
	@GetMapping("/getAll")
	public ResponseEntity<List<AppointmentWithUsernameDTO>> getAll() {
		return new ResponseEntity<List<AppointmentWithUsernameDTO>>(this.service.getAll(), HttpStatus.OK);
	}
	
	// Read by ID
	@GetMapping("/getById/{id}")
	public ResponseEntity<AppointmentWithUsernameDTO> getOne(@PathVariable Long id) {
		return new ResponseEntity<AppointmentWithUsernameDTO>(this.service.getById(id), HttpStatus.OK);
	}

	// Update
	@PutMapping("/update/{id}")
	public ResponseEntity<Appointment> update(@PathVariable Long id, @RequestBody Appointment Appointment) {
		return new ResponseEntity<Appointment>(this.service.update(id, Appointment), HttpStatus.ACCEPTED);
	}
	
	// Delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Appointment> delete(@PathVariable Long id) {
		return this.service.delete(id) ? new ResponseEntity<Appointment>(HttpStatus.NO_CONTENT) 
				: new ResponseEntity<Appointment>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
