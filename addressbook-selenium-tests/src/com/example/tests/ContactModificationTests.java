package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

	@Test
	public void modifySomeContact(){
		app.getNavigationHelper().openMainPage();
		
		//get old contacts list
	    List<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    //actions
	    int index = 3;
		app.getContactHelper().initContactEdit(index);
		ContactData contact = new ContactData();
		contact.address="Los Angeles";
		app.getContactHelper().fillInContactForm(contact);
		app.getContactHelper().submitContactModification();
		app.getNavigationHelper().returnToMainPage();
		
		//get new contacts list
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    //procedure to create valid contact for list comparison
	    if (contact.lastName == null){
	    	contact.lastName = oldList.get(index-1).lastName;
	    }
	    if (contact.firstName == null){
    		contact.firstName = oldList.get(index-1).firstName;
    	}
	    
		//compare lists
	    oldList.remove(index-1);
	    oldList.add(contact);
	    Collections.sort(oldList);
	    assertEquals(oldList, newList);
	}
}
