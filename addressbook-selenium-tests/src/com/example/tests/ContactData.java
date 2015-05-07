package com.example.tests;


public class ContactData implements Comparable<ContactData>{
	public String firstName;
	public String lastName;
	public String address;
	public String homePhone;
	public String mobilePhone;
	public String workPhone;
	public String email;
	public String email2;
	public String bDay;
	public String[] bDayArray;
	public String bMonth;
	public String[] bMonthArray = {
			"-", "January", "February", "March", "April", "May", "June",
			"July", "August", "September", "October", "November", "December"
	};
	public String bYear;
	public String groupName;
	public String address2;
	public String homePhone2;

	public ContactData() {
		bDayArray = new String[32];
		bDayArray[0]="-";
		for (int i=1;i<=31;i++) {
			bDayArray[i]=Integer.toString(i);
		}
		
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
	
	
}