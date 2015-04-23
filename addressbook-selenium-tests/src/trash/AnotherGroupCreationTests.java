package trash;

import org.testng.annotations.Test;

import com.example.tests.GroupData;
import com.example.tests.TestBase;

public class AnotherGroupCreationTests extends TestBase {

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
