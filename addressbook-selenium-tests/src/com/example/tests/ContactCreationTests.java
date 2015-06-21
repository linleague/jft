package com.example.tests;

import static com.example.tests.ContactDataGenerator.loadContactsFromCsvFile;
import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactCreationTests extends TestBase {
 
	@DataProvider
	public Iterator<Object[]> contactsFromFile() throws IOException{
		return wrapContactsForDataProvider(loadContactsFromXmlFile(new File("contacts.xml"))).iterator();
	}
	
	@Test(dataProvider = "contactsFromFile")
	public void testContactCreationWithValidData(ContactData contact) throws Exception {
	     //get old contacts list
		SortedListOf<ContactData> oldList = (SortedListOf<ContactData>) app.getHibernateHelper().listContacts();
	    
	    //actions
	    app.getContactHelper().createContact(contact);
		
		//get new contacts list
	    SortedListOf<ContactData> newList = (SortedListOf<ContactData>) app.getHibernateHelper().listContacts();
	    
		//compare lists
	    assertThat(newList, equalTo(oldList.withAdded(contact)));

	}
	
}

