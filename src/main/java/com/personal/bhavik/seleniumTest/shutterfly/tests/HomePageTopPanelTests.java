package com.personal.bhavik.seleniumTest.shutterfly.tests;

import java.lang.reflect.Method;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.personal.bhavik.seleniumTest.TestBaseClass;
import com.personal.bhavik.seleniumTest.utilities.SeleniumUtilities;
import com.personal.bhavik.seleniumTest.utilities.ShutterflyUtilities;
import com.personal.bhavik.seleniumTest.shutterfly.pages.HomePage;

public class HomePageTopPanelTests extends TestBaseClass {

	private static String URL = "https://www.shutterfly.com";
	private String testName;
	SeleniumUtilities mySeleniumUtilities;
	ShutterflyUtilities myShutterflyUtilities;
	private final static Logger logger = LoggerFactory.getLogger(HomePageTopPanelTests.class);

	
	@BeforeClass
	public void beforeClass () {
		
		BasicConfigurator.configure();
	}
	
	
	@BeforeMethod
	public void beforeMethod(Method method) {

		testName = method.getName();		
		logger.info("*** Beginning test: " + testName + " ***");
	}
	
	@Test
	public void testCloseModalPopUP() throws Exception {
		
		boolean testResult = false;

		try {
			
			initializeWebUI(testName, URL);

			if (mySeleniumUtilities.doesElementExist(HomePage.modalPopUp)) {

				logger.info("Sign up popup detected");
				mySeleniumUtilities.click(HomePage.modalPopUpClose);
				Thread.sleep(1000);

			}
			
			testResult = !mySeleniumUtilities.doesElementExist(HomePage.modalPopUp);
			
		} finally {
			
			assert(testResult);
			mySeleniumUtilities.finishTest(testName, testResult);
		}

	}
	
	@Test
	public void testShutterflyIcon() throws Exception {
		
		boolean testResult = false;

		try {

			initializeWebUI(testName, URL);

			ShutterflyUtilities.closeModalPopUp();		
			
			testResult = mySeleniumUtilities.isElementDisplayed(HomePage.shutterflyIcon);
			
			
		} finally {
			
			assert(testResult);
			mySeleniumUtilities.finishTest(testName, testResult);
		}

	}

	public void initializeWebUI(String testName, String URL) throws Exception {

		createWebDriver(testName, URL);
		mySeleniumUtilities = new SeleniumUtilities(testName, getDriver());
	}
	
	
	@AfterMethod
	public void afterMethod(Method method) {

		testName = method.getName();
		logger.info("*** Ending test: " + testName + " ***");
	}


}
