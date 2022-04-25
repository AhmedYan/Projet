package com.clinique.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.clinique.model.Doctor;
import com.clinique.model.Patient;
import com.clinique.service.doctorserviceimpl;
import com.clinique.service.patientservice;
import com.clinique.service.patientserviceimpl;
@Controller
public class PatientController {
	@Autowired
	private patientserviceimpl patientservice;

	
	@GetMapping("/showPatientsList") 
	public String showPatientsList(Model model) {
 
		model.addAttribute("listPatients", patientservice.getAllpatients());
		return "index";
	}



	@GetMapping("/showNewPatientForm")
	public String showNewPatientForm(Model model) {
		// create model attribute to bind form data
		Patient patient = new Patient();
		model.addAttribute("Patient", patient);
		return "new_patients";
	}
	
	@PostMapping("/savePatient")
	public String savePatient(@ModelAttribute("Patient") Patient patient) {
		// save  to database
		patientservice.savePatient(patient);
		return "redirect:/showPatientsList";
	}
	
	@GetMapping("/showFormForUpdateP/{id}")
	public String showFormForUpdateP(@PathVariable ( value = "id") long id, Model model) {
		
		// get  from the service
		Patient patient = patientservice.getPatientById(id);
		
		model.addAttribute("Patient", patient);
		return "update_patients";
	}
	
	@GetMapping("/deletePatient/{id}")
	public String deletePatient(@PathVariable (value = "id") long id) {
		
		// call delete  method 
		this.patientservice.deletePatientById(id);
		return "redirect:/showPatientsList";
	}
	
}
