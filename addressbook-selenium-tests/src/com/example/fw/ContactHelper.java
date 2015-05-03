package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void initNewContactCreation() {
		// init contact creation
	    click(By.linkText("add new"));
	}

	public void fillInContactForm(ContactData contact) {
		// submit contact info
	    type(By.name("firstname"), contact.firstName);
	    type(By.name("lastname"), contact.lastName);
	    type(By.name("address"), contact.address);
	    type(By.name("home"), contact.homePhone);
	    type(By.name("mobile"), contact.mobilePhone);
	    type(By.name("work"), contact.workPhone);
	    type(By.name("email"), contact.email);
	    type(By.name("email2"), contact.email2);
	    selectByText(By.name("bday"), contact.bDay);
	    selectByText(By.name("bmonth"), contact.bMonth);
	    type(By.name("byear"), contact.bYear);
	    //selectByText(By.name("new_group"), contact.groupName);
	    type(By.name("address2"), contact.address2);
	    type(By.name("phone2"), contact.homePhone2);
	}

	
	public void submitContactInfo() {
		// submit contact info
	    click(By.name("submit"));
	}

	public void initContactEdit(int index) {
		click(By.xpath("//table[@id='maintable']/tbody/tr[" + index + "]/td[7]"));
		
	}

	public void submitContactModification() {
		//By.name is retained specifically here to check test behavior
		//click(By.xpath("//input[@value='Update']"));
		click(By.name("update"));
		
	}

	public void deleteContact() {
		click(By.xpath("//input[@value='Delete']"));
	}

}