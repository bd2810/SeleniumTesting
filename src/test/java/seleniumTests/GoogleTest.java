package seleniumTests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.GooglePage;

public class GoogleTest {
	
	private WebDriver driver;
    private GooglePage google;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        ChromeOptions dc = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);
        google = new GooglePage(driver);
    }

    @Test
    public void googleTest() throws InterruptedException {
        google.goTo();
        google.searchFor("automation");
        Assert.assertTrue(google.getResults().size() >= 10);
    }
    
    @AfterTest
    public void tearDown() throws InterruptedException {
        driver.close();
    }

}
