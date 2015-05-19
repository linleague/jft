package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactCreationTests extends TestBase {
  
	@Test(dataProvider = "randomValidContactGenerator")
	public void testContactCreationWithValidData(ContactData contact) throws Exception {
	     //get old contacts list
		SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    //actions
	    app.getContactHelper().createContact(contact);
		
		//get new contacts list
	    SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
	    
		//compare lists
	    assertThat(newList, equalTo(oldList.withAdded(contact)));

	}
	
}

