package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBase {

	@Test
	public void deleteSomeGroup(){
	//save old group list
    List<GroupData> oldList = app.getGroupHelper().getGroups();
    
    Random rnd = new Random();
    int index = rnd.nextInt(oldList.size()-1);
    
    //actions
	app.getGroupHelper().deleteGroup(index);
	
	//save new group list
    List<GroupData> newList = app.getGroupHelper().getGroups();
    
    //compare lists
    oldList.remove(index);
    Collections.sort(oldList);
    assertEquals(oldList, newList);
	}
}
