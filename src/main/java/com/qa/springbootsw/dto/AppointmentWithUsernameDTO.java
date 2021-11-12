package com.qa.springbootsw.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

public class AppointmentWithUsernameDTO {

	private Long id;
	private LocalDate date;
	@DateTimeFormat(pattern = "hh:mm")
	private LocalTime time;
	private String username;
	
	public AppointmentWithUsernameDTO(Long id, LocalDate date, LocalTime time, String username) {
		this.id = id;
		this.date = date;
		this.time = time;
		this.username = username;
	}
	
	public AppointmentWithUsernameDTO() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public LocalTime getTime() {
		return time;
	}
	
	public void setTime(LocalTime time) {
		this.time = time;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
}
