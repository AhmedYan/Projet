package com.clinique.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.clinique.model.Doctor;
import com.clinique.service.doctorserviceimpl;
import com.clinique.service.patientserviceimpl;

@Controller
public class DoctorController {
	@Autowired
	private doctorserviceimpl Doctorservice;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		
		return "Dash";
	}
	@GetMapping("/showDoctorsList") 
	public String showDoctorsList(Model model) {
 
		model.addAttribute("listDoctors", Doctorservice.getAlldoctors());
		return "NewFile";
	}
	
	@GetMapping("/showNewDoctorForm")
	public String showNewDoctorForm(Model model) {
		// create model attribute to bind form data
		Doctor doctor = new Doctor();
		model.addAttribute("Doctor", doctor);
		return "new_doctors";
	}
	
	@PostMapping("/saveDoctor")
	public String saveDoctor(@ModelAttribute("Doctor") Doctor doctor) {
		Doctorservice.saveDoctor(doctor);
		return "redirect:/showDoctorsList";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		
		Doctor doctor = Doctorservice.getDoctorById(id);
		
		model.addAttribute("Doctor", doctor);
		return "update_doctors";
	}
	
	@GetMapping("/deleteDoctor/{id}")
	public String deleteDoctor(@PathVariable (value = "id") long id) {
		
		this.Doctorservice.deleteDoctorById(id);
		return "redirect:/showDoctorsList";
	}
	
	


		


}
