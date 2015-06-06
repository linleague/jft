package com.example.fw;

public class Contact {

	public String firstName;
	public String lastName;

	public Contact setFirstName(String fname) {
		this.firstName = fname;
		return this;
	}

	public Contact setLastName(String lname) {
		this.lastName = lname;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

}
