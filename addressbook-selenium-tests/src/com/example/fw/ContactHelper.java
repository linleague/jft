package com.example.fw;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

public class ContactHelper extends HelperBase {
	
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	private SortedListOf<ContactData> cachedContacts;
	
	public SortedListOf<ContactData> getContacts() {
		if (cachedContacts == null){
			rebuildCache();
		}
		return cachedContacts;
		
	}
	
	private void rebuildCache() {

		manager.navigateTo().mainPage();
		cachedContacts = new SortedListOf<ContactData>();
		List<WebElement> rowLine = driver.findElements(By.xpath(".//table[@id='maintable']/tbody/tr/td[2] | .//table[@id='maintable']/tbody/tr/td[3]"));
		Iterator<WebElement> wei = rowLine.iterator();
		while (wei.hasNext()) {
			String lastName = wei.next().getText();
			String firstName = wei.next().getText();
			ContactData contact = new ContactData().withLastName(lastName).withFirstName(firstName);
			if (! contact.getLastName().equals("Select all")) {
			cachedContacts.add(contact);
			}
		}
	}

	public ContactHelper createContact(ContactData contact) {
		manager.navigateTo().mainPage();
		initNewContactCreation();
		fillInContactForm(contact, CREATION);
		submitContactInfo();
		returnToMainPage();
		rebuildCache();
		return this;
	}
	
	public ContactHelper modifyContact(int index, ContactData contact) {
		manager.navigateTo().mainPage();
		initContactEdit(index);
		fillInContactForm(contact, MODIFICATION);
		submitContactModification();
		returnToMainPage();
		rebuildCache();
		return this;
	}
	
	public ContactHelper deleteContact(int index) {
		initContactEdit(index);
		submitContactDeletion();
		returnToMainPage();
		rebuildCache();
		return this;
	}

	
//------------------------------------------------------------------------------------------------------	
	public ContactHelper initNewContactCreation() {
		// init contact creation
	    click(By.linkText("add new"));
	    return this;
	}

	public ContactHelper fillInContactForm(ContactData contact, boolean formType) {
		// submit contact info
	    type(By.name("firstname"), contact.getFirstName());
	    type(By.name("lastname"), contact.getLastName());
	    type(By.name("address"), contact.getAddress());
	    type(By.name("home"), contact.getHomePhone());
	    type(By.name("mobile"), contact.getMobilePhone());
	    type(By.name("work"), contact.getWorkPhone());
	    type(By.name("email"), contact.getEmail());
	    type(By.name("email2"), contact.getEmail2());
	    selectByText(By.name("bday"), contact.getbDay());
	    selectByText(By.name("bmonth"), contact.getbMonth());
	    type(By.name("byear"), contact.getbYear());
	    if (formType == CREATION){
	    	//selectByText(By.name("new_group"), contact.getGroupName);
	    } else {
	    	if (driver.findElements(By.name("new_group")).size() != 0){
	    		throw new Error("Group selector exists in contact modification form");
	    	}
	    }
	    
	    type(By.name("address2"), contact.getAddress2());
	    type(By.name("phone2"), contact.getHomePhone2());
	    return this;
	}

	
	public ContactHelper submitContactInfo() {
		// submit contact info
	    click(By.name("submit"));
	    cachedContacts = null;
	    return this;
	}

	public ContactHelper initContactEdit(int index) {
		click(By.xpath("//table[@id='maintable']/tbody/tr[" + (index+1) + "]/td[7]"));
		return this;
		
	}

	public ContactHelper submitContactModification() {
		//By.name is retained specifically here to check test behavior
		//click(By.xpath("//input[@value='Update']"));
		click(By.name("update"));
		cachedContacts = null;
		return this;
	}

	public ContactHelper returnToMainPage() {
		//return to main page
	    click(By.linkText("home"));
	    return this;
	}

	public ContactHelper submitContactDeletion() {
		click(By.xpath("//input[@value='Delete']"));
		cachedContacts = null;
		return this;
	}

}
