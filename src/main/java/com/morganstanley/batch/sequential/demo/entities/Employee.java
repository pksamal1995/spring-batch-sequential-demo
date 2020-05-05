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
@XmlRootElement(name = "employee")
@XmlAccessorOrder(XmlAccessOrder.UNDEFINED)
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {

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
	@XmlElement(name = "age")
	private Integer age;
	@XmlElement(name = "department")
	private String department;
	@XmlElement(name = "ocupation")
	private String ocupation;
	@XmlElement(name = "salary")
	private Double salary;

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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getOcupation() {
		return ocupation;
	}

	public void setOcupation(String ocupation) {
		this.ocupation = ocupation;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Employee(String firstName, String lastName, Integer age, String department, String ocupation,
			Double salary) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.department = department;
		this.ocupation = ocupation;
		this.salary = salary;
	}

	public Employee() {

	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", department=" + department + ", ocupation=" + ocupation + ", salary=" + salary + "]";
	}

}
