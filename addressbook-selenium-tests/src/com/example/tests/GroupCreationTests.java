package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
  
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
	openMainPage();
    goToGroupsPage();
    initGroupCreation();
    GroupData group = new GroupData();
    group.name = "group1";
    group.header = "header1";
    group.footer = "footer1";
	fillInGroupForm(group);
    submitGroupCreation();
    returnToGroupsPage();
  }

  @Test
  public void testEmptyGroupCreation() throws Exception {
	openMainPage();
    goToGroupsPage();
    initGroupCreation();
    fillInGroupForm(new GroupData("", "", ""));
    submitGroupCreation();
    returnToGroupsPage();
  }
}
