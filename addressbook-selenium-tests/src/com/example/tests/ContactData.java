package com.example.tests;

public class ContactData {
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
}