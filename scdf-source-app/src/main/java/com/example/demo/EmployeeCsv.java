package com.example.demo;

public class EmployeeCsv extends Employee {

	private String status;
	

	public EmployeeCsv() {
		super();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "EmployeeCsv [status=" + status + ", getFirstName()=" + getFirstName() + ", getLastName()="
				+ getLastName() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + "]";
	}

}