package com.example.tests;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {

	protected static ApplicationManager app;
	

	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager();

	  }

	@AfterTest
	public void tearDown() throws Exception {
	    app.stop();

	  }

	public String returnRandomString(){
		Random rnd = new Random();
		if (rnd.nextInt(4) == 0){
			return "";
		}
		else {
			return "test" + rnd.nextInt(100);
		}
		
	}
	
	public String randomYear(){
		Random rand = new Random();
		String randomYear = String.valueOf(rand.nextInt(9999));
		if (rand.nextInt(4) == 0){
			return "";
		}
		else {
			return randomYear;
		}
	}
	
	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator(){
		List<Object[]> list = new ArrayList<Object[]>();
		
		for (int i = 0; i < 5; i++){
			GroupData group = new GroupData();
			group.name = returnRandomString();
		    group.header = returnRandomString();
		    group.footer = returnRandomString();
		    list.add(new Object[]{group});
		}
		return list.iterator();
		
	}
	
	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator(){
		List<Object[]> list = new ArrayList<Object[]>();
		
		for (int i = 0; i < 5; i++){
			ContactData contact = new ContactData();
			Random rand = new Random();
		    int randomDay = rand.nextInt(contact.bDayArray.length);
		    int randomMonth = rand.nextInt(contact.bMonthArray.length);
		    contact.firstName = returnRandomString();
			contact.lastName = returnRandomString();
			contact.address = returnRandomString();
			contact.homePhone = returnRandomString();
			contact.workPhone = returnRandomString();
			contact.mobilePhone = returnRandomString();
			contact.email = returnRandomString();
			contact.email2 = returnRandomString();
			contact.bDay = contact.bDayArray[randomDay];
			contact.bMonth = contact.bMonthArray[randomMonth];
			contact.bYear = randomYear();
			//contact.groupName = "group1";
			contact.address2 = returnRandomString();
			contact.homePhone2 = returnRandomString();
		    list.add(new Object[]{contact});
		}
		return list.iterator();
		
	}
	
	@DataProvider
	public Iterator<Object[]> randomValidModifyContactGenerator(){
		List<Object[]> list = new ArrayList<Object[]>();
		
		for (int i = 0; i < 5; i++){
			ContactData contact = new ContactData();
			Random rand = new Random();
		    int randomDay = rand.nextInt(contact.bDayArray.length);
		    int randomMonth = rand.nextInt(contact.bMonthArray.length);
			
			Field stringFieldsArray[] = contact.getClass().getDeclaredFields();
			int randomField = rand.nextInt(stringFieldsArray.length);
			Field c = stringFieldsArray[randomField];
			
			try {
				String fieldName = c.getName();
				switch (fieldName){
				default: c.set(contact, returnRandomString());
					break;
				case "bDay":
					contact.bDay = contact.bDayArray[randomDay];
					break;
				case "bMonth":
					contact.bMonth = contact.bMonthArray[randomMonth];
					break;
				case "bYear":
					contact.bYear = randomYear();
					break;
				case "groupName":
					contact.groupName = "";
					break;
				}
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			list.add(new Object[]{contact});
		}
		return list.iterator();
		
	}
}
