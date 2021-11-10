package com.qa.springbootsw.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.springbootsw.domain.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

	@Query(value = "SELECT * FROM user WHERE username = ?1", nativeQuery = true)
	Optional<User> findByUsername(String username);
	
}
