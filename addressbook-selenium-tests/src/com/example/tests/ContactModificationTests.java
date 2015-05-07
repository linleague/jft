package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

	@Test(dataProvider = "randomValidModifyContactGenerator")
	public void modifySomeContact(ContactData contact){
		app.getNavigationHelper().openMainPage();
		
		//get old contacts list
	    List<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    //actions
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    if (index == 0){
	    	index++;
	    }
	    
		app.getContactHelper().initContactEdit(index);
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
	    ContactData selectAll = oldList.get(oldList.size()-1);
	    oldList.remove(selectAll);
	    oldList.remove(index-1);
	    oldList.add(contact);
	    Collections.sort(oldList);
	    oldList.add(selectAll);
	    assertEquals(oldList, newList);
	}
}
