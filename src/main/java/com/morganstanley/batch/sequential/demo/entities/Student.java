package com.morganstanley.batch.sequential.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table
@XmlRootElement(name = "student")
@XmlAccessorOrder(XmlAccessOrder.UNDEFINED)
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlElement(name = "id")
	private Long id;
	@XmlElement(name = "first-name")
	@Column(name = "first_name")
	private String firstName;
	@XmlElement(name = "last-name")
	@Column(name = "last_name")
	private String lastName;
	@XmlElement(name = "roll-no")
	@Column(name = "roll_no")
	private String rollNo;
	@XmlElement(name = "department")
	private String department;
	@XmlElement(name = "academic-year")
	@Column(name = "academic_year")
	private Integer academicYear;
	@XmlElement(name = "subjects")
	private String subjects;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Integer getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(Integer academicYear) {
		this.academicYear = academicYear;
	}

	public String getSubjects() {
		return subjects;
	}

	public void setSubjects(String subjects) {
		this.subjects = subjects;
	}

	public Student(String firstName, String lastName, String rollNo, String department, Integer academicYear,
			String subjects) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.rollNo = rollNo;
		this.department = department;
		this.academicYear = academicYear;
		this.subjects = subjects;
	}

	public Student() {

	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", rollNo=" + rollNo
				+ ", department=" + department + ", academicYear=" + academicYear + ", subjects=" + subjects + "]";
	}

}
