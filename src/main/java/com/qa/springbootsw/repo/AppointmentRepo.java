package com.qa.springbootsw.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.qa.springbootsw.domain.Appointment;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long>{

}
