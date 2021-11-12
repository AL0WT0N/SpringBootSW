package com.qa.springbootsw.domain;

import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	// Creates a column called "first_name"
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	// Creates a column called "last_name"
	@Column(nullable = false)
	private String lastName;
	
	// Creates column called "username"
	@Column(nullable = false)
	private String username;

	@JsonIgnore
	@OneToMany(mappedBy="user")
	private List<Appointment> appointments;
	
	// default constructor
	public User() {}
	
	public User(String firstName, String lastName, String username) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
	}
	
	// For testing
	public User(long id, String firstName, String lastName, String username) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	@Override
	public int hashCode() {
		return Objects.hash(appointments, firstName, id, lastName, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(appointments, other.appointments) && Objects.equals(firstName, other.firstName)
				&& id == other.id && Objects.equals(lastName, other.lastName)
				&& Objects.equals(username, other.username);
	}
}