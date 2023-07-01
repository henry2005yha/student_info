package com.student.bean;

public class Student {
	private int student_id;
	private String name;
	private String nrc;
	private String dob;
	private String phone;
	private String gender;
	private String nationality;
	private String address;
	private int num_ref;
	
	public int getNum_ref() {
		return num_ref;
	}
	public void setNum_ref(int num_ref) {
		this.num_ref = num_ref;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNrc() {
		return nrc;
	}
	public void setNrc(String nrc) {
		this.nrc = nrc;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Student(int student_id, String name, String nrc, String dob, String phone, String gender, String nationality,
			String address) {
		super();
		this.student_id = student_id;
		this.name = name;
		this.nrc = nrc;
		this.dob = dob;
		this.phone = phone;
		this.gender = gender;
		this.nationality = nationality;
		this.address = address;
	}
	public Student(int student_id, String name, String nrc, String dob, String phone, String gender, String nationality,
			String address, int num_ref) {
		super();
		this.student_id = student_id;
		this.name = name;
		this.nrc = nrc;
		this.dob = dob;
		this.phone = phone;
		this.gender = gender;
		this.nationality = nationality;
		this.address = address;
		this.num_ref = num_ref;
	}

	
}
