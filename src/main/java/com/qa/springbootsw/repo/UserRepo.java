package com.qa.springbootsw.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.springbootsw.domain.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

}
