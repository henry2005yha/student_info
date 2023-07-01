package com.student.bean;

public class Student_detail {
	private int id;
	private String year;
	private int mark1;
	private int mark2;
	private int mark3;
	private String remark;
	private int student_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public int getMark1() {
		return mark1;
	}
	public void setMark1(int mark1) {
		this.mark1 = mark1;
	}
	public int getMark2() {
		return mark2;
	}
	public void setMark2(int mark2) {
		this.mark2 = mark2;
	}
	public int getMark3() {
		return mark3;
	}
	public void setMark3(int mark3) {
		this.mark3 = mark3;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public Student_detail(int id, String year, int mark1, int mark2, int mark3, String remark, int student_id) {
		super();
		this.id = id;
		this.year = year;
		this.mark1 = mark1;
		this.mark2 = mark2;
		this.mark3 = mark3;
		this.remark = remark;
		this.student_id = student_id;
	}
	public Student_detail(int id) {
		super();
		this.id = id;
	}
	
}
