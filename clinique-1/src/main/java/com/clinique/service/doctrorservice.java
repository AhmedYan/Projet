package com.clinique.service;

import java.util.List;


import com.clinique.model.Doctor;

public interface doctrorservice {
	List<Doctor> getAlldoctors();
	void saveDoctor(Doctor doctor);
	Doctor getDoctorById(long id);
	void deleteDoctorById(long id);

	

}
