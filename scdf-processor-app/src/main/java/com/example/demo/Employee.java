package com.example.demo;

public class Employee {

	private String firstName;
	private String lastName;

	public Employee() {
	}

	public Employee(String p_firstName, String p_lastName) {
		firstName = p_firstName;
		lastName = p_lastName;
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

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}