package com.personal.bhavik.seleniumTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeSuite;

public class TestBaseClass {
	
	private static WebDriver driver;
	public static final String chromeDriverPath = "./src/main/resources/selenium/chromedriver.exe";	
	
	private final static Logger logger = LoggerFactory.getLogger(TestBaseClass.class);
	
	@BeforeSuite
	public void setUp() {
		
		
	}
	
	public WebDriver getDriver() {
		
        return driver;
    }
	
	protected static void createWebDriver(String testName, String URL) {
		
		try {
			
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(URL);
			
		} catch (Throwable e) {

            logger.info("Caught in ciqSeleniumProcessingUtilities");
            e.printStackTrace();

        }
		

		
	}

}
