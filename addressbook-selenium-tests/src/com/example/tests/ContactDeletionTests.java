package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {
	
	@Test
	public void deleteSomeContact(){
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
		app.getContactHelper().deleteContact();
		app.getNavigationHelper().returnToMainPage();
		
		//get new contacts list
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
		//compare lists
	    ContactData selectAll = oldList.get(oldList.size()-1);
	    oldList.remove(selectAll);
	    oldList.remove(index-1);
	    Collections.sort(oldList);
	    oldList.add(selectAll);
	    assertEquals(oldList, newList);
	}

}
