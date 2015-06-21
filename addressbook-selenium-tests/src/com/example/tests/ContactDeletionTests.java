package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactDeletionTests extends TestBase {
	
	@Test
	public void deleteSomeContact(){
		//get old contacts list
		SortedListOf<ContactData> oldList = (SortedListOf<ContactData>) app.getHibernateHelper().listContacts();
	    
	    //actions
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    if (index == 0){
	    	index++;
	    }
	    
		app.getContactHelper().deleteContact(index);
		
		//get new contacts list
		SortedListOf<ContactData> newList = (SortedListOf<ContactData>) app.getHibernateHelper().listContacts();
	    
		//compare lists
		assertThat(newList, equalTo(oldList.without(index-1)));
	}

}
