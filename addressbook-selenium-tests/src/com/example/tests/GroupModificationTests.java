package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {
	
	@Test
	public void modifySomeGroup(){
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().goToGroupsPage();
		
		//save old group list
	    List<GroupData> oldList = app.getGroupHelper().getGroups();
	    
	    //actions
		app.getGroupHelper().initGroupModification(0);
		GroupData group = new GroupData();
		group.name = "new name";
		app.getGroupHelper().fillInGroupForm(group);
		app.getGroupHelper().submitGroupModification();
		app.getGroupHelper().returnToGroupsPage();
		
		//save new group list
	    List<GroupData> newList = app.getGroupHelper().getGroups();
		
	    //compare lists
	    oldList.remove(0);
	    oldList.add(group);
	    Collections.sort(oldList);
	    assertEquals(oldList, newList);
	}

}
