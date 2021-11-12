package com.qa.springbootsw.service;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import com.qa.springbootsw.AppointmentWithUsernameDTO;
import com.qa.springbootsw.domain.Appointment;
import com.qa.springbootsw.repo.AppointmentRepo;

@Service
public class AppointmentService {
	
	private AppointmentRepo repo;

	public AppointmentService(AppointmentRepo repo) {
		this.repo = repo;
	}
	
	private AppointmentWithUsernameDTO mapToDTO(Appointment appointment) {
		AppointmentWithUsernameDTO dto = new AppointmentWithUsernameDTO();
		
		dto.setId(appointment.getId());
		dto.setDate(appointment.getDate());
		dto.setTime(appointment.getTime());
		dto.setUsername(appointment.getUser().getUsername());
		
		return dto;	
	}

	public Appointment create(Appointment appointment) {
		return this.repo.saveAndFlush(appointment);
	}
	
	// Read All
	public List<AppointmentWithUsernameDTO> getAll() {
		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	// Read by Id
	public AppointmentWithUsernameDTO getById(Long id) {
		Appointment found = this.repo.findById(id).orElseThrow(EntityNotFoundException::new);
		return mapToDTO(found);
	}
	
	// Update
    public Appointment update(Long id, Appointment appointment) {
    	Appointment existing = this.repo.findById(id).get();
    	existing.setDate(appointment.getDate());
    	existing.setTime(appointment.getTime());
    	return this.repo.saveAndFlush(existing);
    }
	
	public Boolean delete(Long id ) {
		this.repo.deleteById(id);
        return !this.repo.existsById(id);
	}
}
