package com.example.tests;

import static com.example.tests.GroupDataGenerator.loadGroupsFromCsvFile;
import static com.example.tests.GroupDataGenerator.loadGroupsFromXmlFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupCreationTests extends TestBase {
  
	@DataProvider
	public Iterator<Object[]> groupsFromFile() throws IOException {
		return wrapGroupsForDataProvider(loadGroupsFromXmlFile(new File("groups.xml"))).iterator();
	}

	@Test(dataProvider = "groupsFromFile")
	public void testGroupCreationWithValidData(GroupData group) throws Exception {
    //save old group list
    SortedListOf<GroupData> oldList = app.getModel().getGroups();
    
    //actions
    app.getGroupHelper().createGroup(group);
  
    //save new group list
    SortedListOf<GroupData> newList = app.getModel().getGroups();
    
    //compare lists
    assertThat(newList, equalTo(oldList.withAdded(group)));
  
    if (wantToCheck()) {
    	if ("yes".equals(app.getProperty("check.db"))){
       	 assertThat(app.getModel().getGroups(), equalTo(app.getHibernateHelper().listGroups()));
       	}
       if ("yes".equals(app.getProperty("check.ui"))){
       	assertThat(app.getModel().getGroups(), equalTo(app.getGroupHelper().getUiGroups()));
       }
    }
}
}
