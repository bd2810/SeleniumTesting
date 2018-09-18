package com.personal.bhavik.seleniumTest.utilities;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.personal.bhavik.seleniumTest.TestBaseClass;
import com.personal.bhavik.seleniumTest.shutterfly.pages.HomePage;
import com.personal.bhavik.seleniumTest.shutterfly.tests.HomePageTopPanelTests;

public class ShutterflyUtilities extends TestBaseClass {

	static SeleniumUtilities mySeleniumUtilities = new SeleniumUtilities(getDriver());

	private final static Logger logger = LoggerFactory.getLogger(HomePageTopPanelTests.class);

	public ShutterflyUtilities() {

	}

	public static void closeModalPopUp() throws Exception {

		logger.info("Checking for the sign up popup");
		
		try {
			
			if (mySeleniumUtilities.doesElementExist(HomePage.modalPopUp)) {

				logger.info("Sign up popup detected");
				mySeleniumUtilities.click(HomePage.modalPopUpClose);
				Thread.sleep(1000);

			} else {
				logger.info("Sign up popup not detected");
			}			
			
		} catch (NoSuchElementException ex) {
        	
		}



	}

}
