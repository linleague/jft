package com.example.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class ContactCreationTests extends TestBase {
  
	@Test(dataProvider = "randomValidContactGenerator")
	public void testContactCreationWithValidData(ContactData contact) throws Exception {
	    app.getNavigationHelper().openMainPage();	  
	    
	    //get old contacts list
	    List<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    //actions
		app.getContactHelper().initNewContactCreation();
		app.getContactHelper().fillInContactForm(contact);
		app.getContactHelper().submitContactInfo();
		app.getNavigationHelper().returnToMainPage();
		
		//get new contacts list
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
		//compare lists
	    ContactData selectAll = oldList.get(oldList.size()-1);
	    oldList.remove(selectAll);
	    oldList.add(contact);
	    Collections.sort(oldList);
	    oldList.add(selectAll);
	    assertEquals(oldList, newList);
	}
	
}

