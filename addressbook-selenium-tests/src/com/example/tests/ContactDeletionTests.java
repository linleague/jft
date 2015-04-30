package com.example.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {
	
	@Test
	public void deleteSomeContact(){
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactEdit(3);
		app.getContactHelper().deleteContact();
		app.getNavigationHelper().returnToMainPage();
	}

}
