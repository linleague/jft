package com.example.tests;



public class ContactData implements Comparable<ContactData>{
	private String firstName;
	private String lastName;
	private String address;
	private String homePhone;
	private String mobilePhone;
	private String workPhone;
	private String email;
	private String email2;
	private String bDay;
	private String bMonth;
	private String bYear;
	private String groupName;
	private String address2;
	private String homePhone2;

	public ContactData() {
	}
	
	public ContactData(String firstName, String lastName, String address,
			String homePhone, String mobilePhone, String workPhone,
			String email, String email2, String bDay, String bMonth,
			String bYear, String groupName, String address2, String homePhone2) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.homePhone = homePhone;
		this.mobilePhone = mobilePhone;
		this.workPhone = workPhone;
		this.bDay = bDay;
		this.email = email;
		this.email2 = email2;
		this.bMonth = bMonth;
		this.bYear = bYear;
		this.groupName = groupName;
		this.address2 = address2;
		this.homePhone2 = homePhone2;
	}

	@Override
	public String toString() {
		return "ContactData [lastName=" + lastName + ", firstName=" + firstName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		/*result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());*/
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public int compareTo(ContactData other) {
		int o = this.lastName.toLowerCase().compareTo(other.lastName.toLowerCase());
		if (o == 0){
			o = this.firstName.toLowerCase().compareTo(other.firstName.toLowerCase());
		}
		return o;
	}

	public ContactData withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public ContactData withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public ContactData withAddress(String address) {
		this.address = address;
		return this;
	}

	public ContactData withHomePhone(String homePhone) {
		this.homePhone = homePhone;
		return this;
	}

	public ContactData withWorkPhone(String workPhone) {
		this.workPhone = workPhone;
		return this;
	}

	public ContactData withMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
		return this;
	}

	public ContactData withEmail(String email) {
		this.email = email;
		return this;
	}

	public ContactData withEmail2(String email2) {
		this.email2 = email2;
		return this;
	}

	public ContactData withAddress2(String address2) {
		this.address2 = address2;
		return this;
	}

	public ContactData withHomePhone2(String homePhone2) {
		this.homePhone2 = homePhone2;
		return this;
	}

	public ContactData withBDay(String bDay) {
	    this.bDay = bDay;
		return this;
	}
	
	public ContactData withBMonth(String bMonth) {
	    this.bMonth = bMonth;
		return this;
	}
	
	public ContactData withBYear(String bYear) {
		this.bYear = bYear;
		return this;
	}

	public ContactData withGroup(String groupName) {
	    this.groupName = groupName;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public String getWorkPhone() {
		return workPhone;
	}

	public String getEmail() {
		return email;
	}

	public String getEmail2() {
		return email2;
	}

	public String getbDay() {
		return bDay;
	}

	public String getbMonth() {
		return bMonth;
	}

	public String getbYear() {
		return bYear;
	}

	public String getGroupName() {
		return groupName;
	}

	public String getAddress2() {
		return address2;
	}

	public String getHomePhone2() {
		return homePhone2;
	}

	
}