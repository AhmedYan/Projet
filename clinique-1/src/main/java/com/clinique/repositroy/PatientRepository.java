package com.clinique.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.clinique.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
