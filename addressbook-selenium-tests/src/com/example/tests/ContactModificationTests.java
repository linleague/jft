package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

	@Test
	public void modifySomeContact(){
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactEdit(3);
		ContactData contact = new ContactData();
		contact.address="Los Angeles";
		app.getContactHelper().fillInContactForm(contact);
		app.getContactHelper().submitContactModification();
		app.getNavigationHelper().returnToMainPage();
	}
}
