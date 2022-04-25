package com.clinique.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Patients")
public class Patient {
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="First_Name")
	private String FirstName;
	
    @Column(name="Last_Name")
	private String LastName;
    
    @Column(name="email")
	private String Email;
    

    @Column(name="Tel")
	private Long Tel;
    
    @Column(name="Sexe")
    private String Sexe;
    
    @Column(name="Date_naissance")
    private Date dnaissance;
    

    
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER/* fetch =
    		FetchType.LAZY*/)
    private Doctor doctor;
    
    

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
		Email = email;
	}
	public Long getTel() {
		return Tel;
	}
	public void setTel(Long tel) {
		Tel = tel;
	}
	public String getSexe() {
		return Sexe;
	}
	public void setSexe(String sexe) {
		Sexe = sexe;
	}
	public Date getDnaissance() {
		return dnaissance;
	}
	public void setDnaissance(Date dnaissance) {
		this.dnaissance = dnaissance;
	}

	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}



}
