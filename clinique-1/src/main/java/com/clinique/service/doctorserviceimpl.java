package com.clinique.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinique.model.Doctor;
import com.clinique.repositroy.DoctorRepository;
@Service
public  class doctorserviceimpl implements doctrorservice {

	@Autowired
	private DoctorRepository doctorRepository;
	@Override
	public List<Doctor> getAlldoctors() {
		return doctorRepository.findAll();

	}

	@Override
	public Doctor getDoctorById(long id) {
		Optional<Doctor> optional = doctorRepository.findById(id);
		Doctor doctor = null;
		if (optional.isPresent()) {
			doctor = optional.get();
		} else {
			throw new RuntimeException(" Doctor not found for id :: " + id);
		}
		return doctor;
	}

	@Override
	public void deleteDoctorById(long id) {
		this.doctorRepository.deleteById(id);
	}
     @Override
	public void saveDoctor(Doctor doctor) {
	this.doctorRepository.save(doctor);
	}





}
