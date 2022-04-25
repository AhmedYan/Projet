package com.clinique.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Doctors")
public class Doctor {
@javax.persistence.Id
@GeneratedValue( strategy=GenerationType.IDENTITY)
	private Long Id;
@Column(name="First_Name")
	private String FirstName;
@Column(name="Last_Name")

	private String LastName;
@Column(name="email")

	private String Email;
@Column(name="Tel")

	private Long Tel;
@Column(name="Specialties")
private String Specialité;




@OneToMany( cascade =CascadeType.ALL, mappedBy = "doctor")
private Set<Patient> patient;

public Long getId() {
	return Id;
}
public void setId(Long id) {
	Id = id;
}
public String getFirstName() {
	return FirstName;
}
public void setFirstName(String firstName) {
	FirstName = firstName;
}
public String getLastName() {
	return LastName;
}
public void setLastName(String lastName) {
	LastName = lastName;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	this.Email = email;
}
public Long getTel() {
	return Tel;
}
public void setTel(Long tel) {
	Tel = tel;
}
public String getSpecialité() {
	return Specialité;
}
public void setSpecialité(String specialité) {
	Specialité = specialité;
}



}
