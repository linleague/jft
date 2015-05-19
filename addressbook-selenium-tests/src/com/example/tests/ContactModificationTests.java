package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactModificationTests extends TestBase {

	@Test(dataProvider = "randomValidModifyContactGenerator")
	public void modifySomeContact(ContactData contact){
		//get old contacts list
		SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    //actions
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    if (index == 0){
	    	index++;
	    }
	    
	    app.getContactHelper().modifyContact(index, contact);

		
		//get new contacts list
	    SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
	    
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
	    assertThat(newList, equalTo(oldList.without(index-1).withAdded(contact)));
	}
}
