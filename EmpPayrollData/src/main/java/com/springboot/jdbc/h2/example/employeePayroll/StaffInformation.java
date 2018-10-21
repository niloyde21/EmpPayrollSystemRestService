package com.springboot.jdbc.h2.example.employeePayroll;

public class StaffInformation {
	private Integer id;
	private String first_name;
	private String surname;
	private String Dob;
	private String Email;
	private String Telephone;
	private String Address;
	private String Department;
	private String Image;
	private String Salary;
	private String Gender;
	private String Address2;
	private String Post_code;
	private String Designation;
	private String Status;
	private String job_title;
	private String Apartment;
	private String Date_hired;
	private String Division;
	
	public StaffInformation() {
		super();
	}
	
	public StaffInformation(Integer id, String first_name, String surname, String dob, String email, String telephone,
			String address, String department, String image, String salary, String gender, String address2,
			String post_code, String designation, String status, String job_title, String apartment, String date_hired,
			String division) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.surname = surname;
		Dob = dob;
		Email = email;
		Telephone = telephone;
		Address = address;
		Department = department;
		Image = image;
		Salary = salary;
		Gender = gender;
		Address2 = address2;
		Post_code = post_code;
		Designation = designation;
		Status = status;
		this.job_title = job_title;
		Apartment = apartment;
		Date_hired = date_hired;
		Division = division;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getDob() {
		return Dob;
	}
	public void setDob(String dob) {
		Dob = dob;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getTelephone() {
		return Telephone;
	}
	public void setTelephone(String telephone) {
		Telephone = telephone;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public String getSalary() {
		return Salary;
	}
	public void setSalary(String salary) {
		Salary = salary;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getAddress2() {
		return Address2;
	}
	public void setAddress2(String address2) {
		Address2 = address2;
	}
	public String getPost_code() {
		return Post_code;
	}
	public void setPost_code(String post_code) {
		Post_code = post_code;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getJob_title() {
		return job_title;
	}
	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}
	public String getApartment() {
		return Apartment;
	}
	public void setApartment(String apartment) {
		Apartment = apartment;
	}
	public String getDate_hired() {
		return Date_hired;
	}
	public void setDate_hired(String date_hired) {
		Date_hired = date_hired;
	}
	public String getDivision() {
		return Division;
	}
	public void setDivision(String division) {
		Division = division;
	}
	
	
	
}
