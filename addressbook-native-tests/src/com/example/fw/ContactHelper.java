package com.example.fw;


public class ContactHelper extends HelpersBase {

	public ContactHelper(ApplicationManager applicationManager) {
		super(applicationManager);
	}

	public void createContact(Contact contact) {
		initContactCreation();
		fillContactForm(contact);
		confirmContactCreation();
	}



	private void initContactCreation() {
		manager.getAutoItHelper()
			.winWaitAndActivate("AddressBook Portable", "", 5000)
			.click("Add").winWaitAndActivate("Add Contact", "", 5000);
	}

	private void fillContactForm(Contact contact) {
		manager.getAutoItHelper()
			.send("TDBEdit12", contact.firstName)
			.send("TDBEdit11", contact.lastName);
	}
	
	private void confirmContactCreation() {
		manager.getAutoItHelper()
			.click("Save")
			.winWaitAndActivate("AddressBook Portable", "", 5000);
	}

	public Contact getFirstContact() {
		editContact();
		Contact contact = new Contact()
			.setFirstName(manager.getAutoItHelper().getText("TDBEdit12"))
			.setLastName(manager.getAutoItHelper().getText("TDBEdit11"));
		manager.getAutoItHelper().click("Cancel")
		.winWaitAndActivate("AddressBook Portable", "", 5000);
		return contact;
		
	}

	public void editContact() {
		if (!cannotEditContact()) {
			manager.getAutoItHelper().winWaitAndActivate("Update Contact", "", 5000);
		}
		 new Error ("No contact to edit");
	}

	public void removeContact() {
		manager.getAutoItHelper()
			.winWaitAndActivate("AddressBook Portable", "", 5000)
			.click("TListView1")
			.send("{DOWN}{SPACE}")
   			.click("Delete")
			.winWaitAndActivate("Confirm", "", 5000)
			.click("&Yes")
			.winWaitAndActivate("AddressBook Portable", "", 5000);
	}

	public boolean cannotEditContact() {
		manager.getAutoItHelper()
		.winWaitAndActivate("AddressBook Portable", "", 5000)
		.click("TListView1")
		.send("{DOWN}{SPACE}")
 		.click("Edit");
		return manager.getAutoItHelper().winExist("Information");
		
	}
}
