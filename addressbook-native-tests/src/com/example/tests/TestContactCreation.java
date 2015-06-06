package com.example.tests;

import org.testng.annotations.*;

import com.example.fw.Contact;

public class TestContactCreation extends TestBase {

	@Test
	public void createContactWithValidData() {
		Contact contact = new Contact().setFirstName("Jane").setLastName("Doe");
		app.getContactHelper().createContact(contact);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
