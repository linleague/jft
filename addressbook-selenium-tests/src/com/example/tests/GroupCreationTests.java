package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupCreationTests extends TestBase {
  

	
  @Test(dataProvider = "randomValidGroupGenerator")
  public void testGroupCreationWithValidData(GroupData group) throws Exception {
    //save old group list
    SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
    
    //actions
    app.getGroupHelper().createGroup(group);
  
    //save new group list
    SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
    
    //compare lists
    assertThat(newList, equalTo(oldList.withAdded(group)));
  
  }

}
