package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

	@Test(dataProvider = "randomValidModifyContactGenerator")
	public void modifySomeContact(ContactData contact){
		//get old contacts list
	    List<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    //actions
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    if (index == 0){
	    	index++;
	    }
	    
	    app.getContactHelper().modifyContact(index, contact);

		
		//get new contacts list
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    //procedure to create valid contact for list comparison
	    if (contact.getLastName() == null){
	    	String ln = oldList.get(index-1).getLastName();
	    	contact = contact.withLastName(ln);
	    }
	    if (contact.getFirstName() == null){
	    	String fn = oldList.get(index-1).getFirstName();
    		contact = contact.withFirstName(fn);
    	}
	    
		//compare lists
	    oldList.remove(index-1);
	    oldList.add(contact);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(oldList, newList);
	}
}
