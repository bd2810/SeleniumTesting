package com.personal.bhavik.seleniumTest.shutterfly.tests;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.personal.bhavik.seleniumTest.TestBaseClass;
import com.personal.bhavik.seleniumTest.utilities.SeleniumUtilities;

public class HomePageTopPanelTests extends TestBaseClass {

	private static String URL = "https://www.shutterfly.com";
	private String testName;
	SeleniumUtilities mySeleniumUtilities;

	@BeforeMethod
	public void getTestName(Method method) {

		testName = method.getName();
	}

	@Test
	public void testCloseModalPopUP() throws Exception {

		try {

			initializeWebUI(testName, URL);

			/*
			 * WebElement elem =
			 * driver.findElement(By.cssSelector(".legacy.modal.fade.in"));
			 * 
			 * if (elem != null) {
			 * driver.findElement(By.className("modal-close")).click(); }
			 * 
			 */ 
			} finally {
				 
				 mySeleniumUtilities.finishTest(testName);
			}

	}

	public void initializeWebUI(String testName, String URL) throws Exception {

		createWebDriver(testName, URL);
		mySeleniumUtilities = new SeleniumUtilities(testName, getDriver());
	}

}
