package com.library.management.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "first_name")
	@NotEmpty
	@NotNull
	private String firstName;
	@Column(name = "last_name")
	@NotEmpty
	@NotNull
	private String lastName;
	
	@Column(name = "gender")
	@NotEmpty
	@NotNull
	private String gender;
	
	@Column(name = "date_of_birth")
	private Date dateOfBirth;
	
	@Column(name = "joining_date")
	private Date joiningDate;
	
	@Column(name = "contact_no")
	private String contactNo;
	
	@Column (name = "email")
	private String email;
	
	
	
	public Member() {
		
	}



	public Member(Long id, @NotEmpty @NotNull String firstName, @NotEmpty @NotNull String lastName,
			@NotEmpty @NotNull String gender, Date dateOfBirth, Date joiningDate, String contactNo, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.joiningDate = joiningDate;
		this.contactNo = contactNo;
		this.email = email;
	}



	public Long getId() {
		return id;
	}



	public String getFirstName() {
		return firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public String getGender() {
		return gender;
	}



	public Date getDateOfBirth() {
		return dateOfBirth;
	}



	public Date getJoiningDate() {
		return joiningDate;
	}



	public String getContactNo() {
		return contactNo;
	}



	public String getEmail() {
		return email;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}



	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}



	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}



	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}













