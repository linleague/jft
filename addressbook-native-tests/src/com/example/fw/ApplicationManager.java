package com.example.fw;

import java.io.IOException;
import java.util.Properties;


public class ApplicationManager {
	
	protected Properties properties;
	private ContactHelper contactHelper;
	private ProcessHelper processHelper;
	private AutoItHelper autoItHelper;

	
	public void start() throws IOException {
		getProcessHelper().startAppUnderTest();
	}
	
	public void stop() {
		getProcessHelper().stopAppUnderTest();
	}
	
	public ApplicationManager(Properties properties) throws IOException{
	    this.properties = properties;
	    this.start();

	}

	public String getProperty(String key, String defaultValue){
		return properties.getProperty(key, defaultValue);
	}
	
	public ProcessHelper getProcessHelper() {
		if (processHelper == null) {
			processHelper = new ProcessHelper(this);
		}
		return processHelper;
	}
	
	public ContactHelper getContactHelper() {
		if (contactHelper == null) {
			contactHelper = new ContactHelper(this);
		}
		return contactHelper;
	}

	public AutoItHelper getAutoItHelper() {
		if (autoItHelper == null) {
			autoItHelper = new AutoItHelper(this);
		}
		return autoItHelper;
	}


}
