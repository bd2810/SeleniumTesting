package com.personal.bhavik.seleniumTest.utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

	
	public void finishTest(String testName, boolean testResult) {
		
		myWebDriver.close();
		
		if(testResult) {
			
			logger.info("Test '"+testName+"' has passed.");
		} else {
			
			logger.error("Test '"+testName+"' has failed.");
		}
	}
	
	public WebElement getElementLoose(String locatorID) {
		
		List<WebElement> elements = null;
		WebElement element = null;
		
		try {			
			elements = myWebDriver.findElements(By.cssSelector(locatorID));
			if (elements.size() > 0) {
				
				logger.info("Found element using cssSelector");
				element = elements.get(0);
				return element;
				
			} else {
				
				elements = myWebDriver.findElements(By.className(locatorID));
				if (elements.size() > 0) {
					
					logger.info("Found element using className");
					element = elements.get(0);
					return element;
				}
			}
		} catch (NoSuchElementException ex) {
			
			logger.debug("Cound not find element with id '"+locatorID+"' either using cssSelector or className");
			
		}
		return element;	
		
	}

}
