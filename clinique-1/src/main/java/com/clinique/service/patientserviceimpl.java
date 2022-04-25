package com.clinique.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.clinique.model.Patient;
import com.clinique.repositroy.PatientRepository;
@Service
public class patientserviceimpl implements patientservice {
	
	
	
	@Autowired
	private PatientRepository patientRepository;
@Override
	public List<Patient> getAllpatients() {
		return patientRepository.findAll();

	}

	@Override
	public Patient getPatientById(long id) {
		Optional<Patient> optional = patientRepository.findById(id);
		Patient patient = null;
		if (optional.isPresent()) {
			patient = optional.get();
		} else {
			throw new RuntimeException(" Patient not found for id :: " + id);
		}
		return patient;
	}

	@Override
	public void deletePatientById(long id) {
		this.patientRepository.deleteById(id);
	}
	@Override
	public void savePatient(Patient patient) {
	this.patientRepository.save(patient);
	}




}
