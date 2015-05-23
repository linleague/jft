package com.example.tests;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.*;

import static com.example.tests.TestBase.returnRandomString;
import static com.example.tests.TestBase.randomDay;
import static com.example.tests.TestBase.randomMonth;
import static com.example.tests.TestBase.randomYear;

public class ContactDataGenerator {

	public static void main(String[] args) throws IOException {
		if (args.length < 3) {
			System.out.println("Please specify parameters: <amount of test data>, <file>, <format>.");
			return;
		}
		
		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2];
		
		if (file.exists()){
			System.out.println("File " + file + " already exists. Please remove it manually.");
		}

		
		List<ContactData> contacts = generateRandomContacts(amount);
		if ("csv".equals(format)){
			saveContactsToCsvFile(contacts, file);
		} else if ("xml".equals(format)) {
			saveContactsToXmlFile(contacts, file);
		} else {
			System.out.println("Unknown format " + format);
			return;
		}
	}

	private static void saveContactsToXmlFile(List<ContactData> contacts, File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		String xml = xstream.toXML(contacts);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();
	}
	
	public static List<ContactData> loadContactsFromXmlFile(File file) {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		return (List<ContactData>) xstream.fromXML(file);
	}
	

	private static void saveContactsToCsvFile(List<ContactData> contacts, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContactData contact : contacts) {
			writer.write(contact.getFirstName() + "," + 
						contact.getLastName() + "," +
						contact.getAddress() + "," +
						contact.getHomePhone() + "," +
						contact.getWorkPhone() + "," +
						contact.getMobilePhone() + "," +
						contact.getEmail() + "," +
						contact.getEmail2() + "," +
						contact.getAddress2() + "," +
						contact.getHomePhone2() + "," +
						contact.getbDay() + "," +
						contact.getbMonth() + "," +
						contact.getbYear()+ ",!" + "\n" );
		}
		writer.close();
	}
	
	public static List<ContactData> loadContactsFromCsvFile(File file) throws IOException {
		List<ContactData> list = new ArrayList<ContactData>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = bufferedReader.readLine();
		while (line != null) {
			String[] part = line.split(",");
			ContactData contact = new ContactData()
			.withFirstName(part[0])
			.withLastName(part[1])
			.withAddress(part[2])
			.withHomePhone(part[3])
			.withWorkPhone(part[4])
			.withMobilePhone(part[5])
			.withEmail(part[6])
			.withEmail2(part[7])
			.withAddress2(part[8])
			.withHomePhone2(part[9])
			.withBDay(part[10])
			.withBMonth(part[11])
			.withBYear(part[12]);
			list.add(contact);
			line = bufferedReader.readLine();
		}
		bufferedReader.close();
		return list;
	}


	public static List<ContactData> generateRandomContacts(int amount) {
		List<ContactData> list = new ArrayList<ContactData>();
		for (int i = 0; i < amount; i++){
			ContactData contact = new ContactData()
			.withFirstName(returnRandomString())
			.withLastName(returnRandomString())
			.withAddress(returnRandomString())
			.withHomePhone(returnRandomString())
			.withWorkPhone(returnRandomString())
			.withMobilePhone(returnRandomString())
			.withEmail(returnRandomString())
			.withEmail2(returnRandomString())
			.withAddress2(returnRandomString())
			.withHomePhone2(returnRandomString())
			.withBDay(randomDay())
			.withBMonth(randomMonth())
			.withBYear(randomYear(1900, 2015));
			//.withGroup();
		    list.add(contact);
		}
		return list;
	}
	
	
	

}
