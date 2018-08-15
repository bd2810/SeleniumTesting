package com.personal.bhavik.seleniumTest.utilities;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SeleniumUtilities {
	
    private final static Logger logger = LoggerFactory.getLogger(SeleniumUtilities.class);
    public String testName;
    private final WebDriver myWebDriver;
	
    public SeleniumUtilities(String testName) {
        this.testName = testName;
        this.myWebDriver=null;
    }

    public SeleniumUtilities(String testName, WebDriver passedWebDriver) {
        this.testName = testName;
        this.myWebDriver = passedWebDriver;
    }

	
	public void finishTest(String testName) {
		
		myWebDriver.close();
	}

}
