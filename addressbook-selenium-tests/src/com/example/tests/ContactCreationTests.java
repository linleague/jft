package com.example.tests;

import org.testng.annotations.Test;

import java.util.Random;

public class ContactCreationTests extends TestBase {
  
	@Test
	public void testNonEmptyContactCreation() throws Exception {
	    openMainPage();	  
		initNewContactCreation();
		ContactData contact = new ContactData();
	    Random rand = new Random();
	    int randomDay = rand.nextInt(contact.bDayArray.length);
	    int randomMonth = rand.nextInt(contact.bMonthArray.length);
		contact.firstName = "Jane";
		contact.lastName = "Doe";
		contact.address = "Santa Barbara";
		contact.homePhone = "555-23-67";
		contact.workPhone = "272-15-19";
		contact.mobilePhone = "270-45-78";
		contact.email = "jdoe@gmail.com";
		contact.email2 = "kitten1985@yahoo.com";
		contact.bDay = contact.bDayArray[randomDay];
		contact.bMonth = contact.bMonthArray[randomMonth];
		contact.bYear = "1981";
		contact.groupName = "group1";
		contact.address2 = "Santa Monica";
		contact.homePhone2 = "165-77-12";
		fillInContactForm(contact);
		submitContactInfo();
		returnToMainPage();
	}
	
	@Test
	public void testEmptyContactCreation() throws Exception {
		openMainPage();	  
		initNewContactCreation();
		//ContactData contact = new ContactData();
		//contact.bDay = "-";
		//contact.bMonth = "-";
		//fillInContactForm(contact);
		submitContactInfo();
		returnToMainPage();
	}
}

