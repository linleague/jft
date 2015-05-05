package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {
	
	@Test
	public void deleteSomeContact(){
		app.getNavigationHelper().openMainPage();
		
		//get old contacts list
	    List<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    //actions
	    int index = 1;
		app.getContactHelper().initContactEdit(index);
		app.getContactHelper().deleteContact();
		app.getNavigationHelper().returnToMainPage();
		
		//get new contacts list
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
		//compare lists
	    oldList.remove(index-1);
	    
	    Collections.sort(oldList);
	    assertEquals(oldList, newList);
	}

}
