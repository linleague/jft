package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
  
	@Test(dataProvider = "randomValidContactGenerator")
	public void testContactCreationWithValidData(ContactData contact) throws Exception {
	     //get old contacts list
	    List<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    //actions
	    app.getContactHelper().createContact(contact);
		
		//get new contacts list
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
		//compare lists
	    oldList.add(contact);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(oldList, newList);
	}
	
}

