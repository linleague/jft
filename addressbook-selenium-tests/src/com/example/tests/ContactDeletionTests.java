package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {
	
	@Test
	public void deleteSomeContact(){
		//get old contacts list
	    List<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    //actions
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    if (index == 0){
	    	index++;
	    }
	    
		app.getContactHelper().deleteContact(index);
		
		//get new contacts list
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
		//compare lists
	    oldList.remove(index-1);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(oldList, newList);
	}

}
