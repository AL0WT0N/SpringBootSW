package com.qa.springbootsw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
	@Column(nullable = false, unique = true)
	private String username;

	public User(String firstName, String lastName, String username) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
	}
}
