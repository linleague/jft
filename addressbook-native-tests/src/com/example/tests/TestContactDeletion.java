package com.example.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestContactDeletion extends TestBase {

	@Test
	public void removeFirstContact() {
		app.getContactHelper().removeContact();
		Assert.assertTrue(app.getContactHelper().cannotEditContact());
	}
}
