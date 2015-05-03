package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBase {

	@Test
	public void deleteSomeGroup(){
	app.getNavigationHelper().openMainPage();
	app.getNavigationHelper().goToGroupsPage();
	
	//save old group list
    List<GroupData> oldList = app.getGroupHelper().getGroups();
    
    //actions
	app.getGroupHelper().deleteGroup(0);
	app.getGroupHelper().returnToGroupsPage();
	
	//save new group list
    List<GroupData> newList = app.getGroupHelper().getGroups();
    
    //compare lists
    oldList.remove(0);
    Collections.sort(oldList);
    assertEquals(oldList, newList);
	}
}
