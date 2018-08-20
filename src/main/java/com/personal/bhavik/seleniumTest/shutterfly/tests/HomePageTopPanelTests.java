package com.personal.bhavik.seleniumTest.shutterfly.tests;

import java.lang.reflect.Method;

import org.openqa.selenium.WebElement;
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
		
		WebElement elem = null;
		boolean testResult = false;

		try {

			initializeWebUI(testName, URL);
			Thread.sleep(5000);

			elem = mySeleniumUtilities.getElementLoose(".legacy.modal.fade.in");

			if (elem.isDisplayed()) {
				mySeleniumUtilities.getElementLoose("modal-close").click();
				Thread.sleep(3000);
			}
			
			testResult = !elem.isDisplayed();
			assert(testResult);
			
		} finally {

			mySeleniumUtilities.finishTest(testName, testResult);
		}

	}

	public void initializeWebUI(String testName, String URL) throws Exception {

		createWebDriver(testName, URL);
		mySeleniumUtilities = new SeleniumUtilities(testName, getDriver());
	}

}
