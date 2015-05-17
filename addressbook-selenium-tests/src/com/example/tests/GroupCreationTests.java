package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
  

	
  @Test(dataProvider = "randomValidGroupGenerator")
  public void testGroupCreationWithValidData(GroupData group) throws Exception {
    //save old group list
    List<GroupData> oldList = app.getGroupHelper().getGroups();
    
    //actions
    app.getGroupHelper().createGroup(group);
  
    //save new group list
    List<GroupData> newList = app.getGroupHelper().getGroups();
    
    //compare lists
    oldList.add(group);
    Collections.sort(oldList);
    assertEquals(oldList, newList);
  
  }

}
