package com.qa.springbootsw.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate date;
	
	@DateTimeFormat(pattern = "hh:mm")
	private LocalTime time;
	
	@ManyToOne
	private User user;

	public Appointment() {}
	
	public Appointment(LocalDate date, LocalTime time) {
		this.date = date;
		this.time = time;
	}
	
	public Appointment(Long id, LocalDate date, LocalTime time) {
		this.id = id;
		this.date = date;
		this.time = time;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, id, time, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Appointment other = (Appointment) obj;
		return Objects.equals(date, other.date) && Objects.equals(id, other.id) && Objects.equals(time, other.time)
				&& Objects.equals(user, other.user);
	}
}
