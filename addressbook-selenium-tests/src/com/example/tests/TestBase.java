package com.example.tests;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

import static com.example.tests.GroupDataGenerator.generateRandomGroups;
import static com.example.tests.ContactDataGenerator.generateRandomContacts;


public class TestBase {

	protected static ApplicationManager app;
	private int checkCounter;
	private int checkFrequency;
	

	@BeforeTest
	public void setUp() throws Exception {
		String configFile = System.getProperty("configFile", "application.properties");
		Properties properties = new Properties();
		properties.load(new FileReader(new File(configFile)));
		app = new ApplicationManager(properties);
		checkCounter = 0;
		checkFrequency = Integer.parseInt(properties.getProperty("check.frequency", "0"));
	  }
	
	protected boolean wantToCheck() {
		checkCounter++;
		if (checkCounter > checkFrequency) {
			checkCounter = 0;
			return true;
		} else {
			return false;
		}
	}

	@AfterTest
	public void tearDown() throws Exception {
	    app.stop();

	  }

	public static String returnRandomString(){
		Random rnd = new Random();
		if (rnd.nextInt(4) == 0){
			return "";
		}
		else {
			return "test" + rnd.nextInt(1000);
		}
		
	}
	
	public static String randomDay(){
		String[] bDayArray = new String[32];
		bDayArray[0]="-";
		for (int i=1;i<=31;i++) {
			bDayArray[i]=Integer.toString(i);
		}
		Random rand = new Random();
		String randomDay = String.valueOf(rand.nextInt(bDayArray.length));
		return randomDay;
	}
	
	public static String randomMonth(){
		String[] bMonthArray = {
				"-", "January", "February", "March", "April", "May", "June",
				"July", "August", "September", "October", "November", "December"
		};
		Random rand = new Random();
		String randomMonth = bMonthArray[rand.nextInt(bMonthArray.length)];
		return randomMonth;
	}
	
	public static String randomYear(int start, int end){
		Random rand = new Random();
		String randomYear = String.valueOf(rand.nextInt(end - start +1) + start);
		if (rand.nextInt(4) == 0){
			return "";
		}
		else {
			return randomYear;
		}
	}
	
	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator(){
		return wrapGroupsForDataProvider(generateRandomGroups(5)).iterator();
	}
	
	public static List<Object[]> wrapGroupsForDataProvider(List<GroupData> groups) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (GroupData group : groups){
			list.add(new Object[]{group});
		}
		return list;
	}

	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() throws IOException{
		return wrapContactsForDataProvider(generateRandomContacts(3)).iterator();
	}
	
	public static List<Object[]> wrapContactsForDataProvider(List<ContactData> contacts) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (ContactData contact : contacts){
			list.add(new Object[]{contact});
		}
		return list;
	}

	@DataProvider
	public Iterator<Object[]> randomValidModifyContactGenerator(){
		List<Object[]> list = new ArrayList<Object[]>();
		
		for (int i = 0; i < 3; i++){
			ContactData contact = new ContactData();
			Field stringFieldsArray[] = contact.getClass().getDeclaredFields();
			Random rand = new Random();
			int randomField = rand.nextInt(stringFieldsArray.length);
			Field f = stringFieldsArray[randomField];
			f.setAccessible(true);
			
			try {
				String fieldName = f.getName();
				switch (fieldName){
				default: f.set(contact, returnRandomString());
					break;
				case "bDay":
					contact = contact.withBDay(randomDay());
					break;
				case "bMonth":
					contact = contact.withBMonth(randomMonth());
					break;
				case "bYear":
					contact = contact.withBYear(randomYear(1900, 2015));
					break;
				case "groupName":
					contact = contact.withGroup("");
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
