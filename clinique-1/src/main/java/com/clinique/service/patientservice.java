package com.clinique.service;

import java.util.List;

import com.clinique.model.Patient;

public interface patientservice {
	 List<Patient> getAllpatients() ;

	public  void savePatient(Patient patient) ;
	Patient getPatientById(long id);
	void deletePatientById(long id);
}
