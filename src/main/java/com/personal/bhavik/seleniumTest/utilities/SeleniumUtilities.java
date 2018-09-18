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
    
    public SeleniumUtilities(WebDriver passedWebDriver) {
    	
    	this.myWebDriver = passedWebDriver;
    }
	
    public SeleniumUtilities(String testName) {
        this.testName = testName;
        this.myWebDriver=null;
    }

    public SeleniumUtilities(String testName, WebDriver passedWebDriver) {
        this.testName = testName;
        this.myWebDriver = passedWebDriver;
    }

	
	public void finishTest(String testName, boolean testResult) {		
		
		if(testResult) {
			
			logger.info("Test '"+testName+"' has passed.");
		} else {
			
			logger.error("Test '"+testName+"' has failed.");
		}
		
		myWebDriver.close();
	}
	
	public WebElement getElementLoose(String locatorID) {
		
		List<WebElement> elements = null;
		WebElement element = null;
		
		try {			
			elements = myWebDriver.findElements(By.cssSelector(locatorID));
			if (elements.size() > 0) {
				
				logger.info("Found element using cssSelector: " + locatorID);
				element = elements.get(0);
				return element;
				
			} else {
				
				elements = myWebDriver.findElements(By.className(locatorID));
				if (elements.size() > 0) {
					
					logger.info("Found element using className: " + locatorID);
					element = elements.get(0);
					return element;
				}
			}
		} catch (NoSuchElementException ex) {
			
			logger.debug("Cound not find element with id '"+locatorID+"' either using cssSelector or className");
			
		}
		return element;	
		
	}
	
	public boolean isElementDisplayed (String locatorID) {
		
		boolean result = false;
		
		WebElement element = null;
		
		element = getElementLoose(locatorID);
		
		result = element.isDisplayed();
		
		return result;
	}
	
	public void click(String locatorID) {
		
		WebElement element = null;
		
		element = getElementLoose(locatorID);
		
		logger.info("Clicking on WebElement with locatorID: " + locatorID);
		
		element.click();
	}
	
	public void clickWebElement(WebElement element) {		
		
		element.click();
	}
	
	public String getText(WebElement element) {
		
		String text = null;
		
		element.getText();
		
		return text;
	}
	
    public boolean doesElementExist(String locatorID) {
    	
        logger.info("Checking for existence of webElement: " + locatorID);

        boolean result = false;
        WebElement element = null;        
        
        try {
        	
        	element = getElementLoose(locatorID);
        	
            if (element == null) {
                logger.info("No element found");
                return result;
                
            } else {
                logger.info("1 or more elements found");
                return true;
            }
        	
        } catch (NoSuchElementException ex) {
        	
        	logger.debug("Cound not find element '"+locatorID);		
		}

        return result;
    }

}
