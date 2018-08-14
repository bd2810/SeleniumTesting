package seleniumTests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestGoogleGetTitle {

	static Capabilities chromeCapabilities = DesiredCapabilities.chrome();
	static Capabilities firefoxCapabilities = DesiredCapabilities.firefox();
	private WebDriverWait wait;

	@FindBy(name = "q")
	private WebElement searchBox;

	@FindBy(css = "input.lsb")
	private WebElement searchButton;

	@FindBy(className = "rc")
	private List<WebElement> searchResults;

	@Test
	public void testGoogleGetTitle() throws MalformedURLException {

		// CmdUtilities.exec("cd C:\\Users\\Bhavik_D\\Documents\\Personal
		// Github\\SeleniumTesting");
		// CmdUtilities.exec("docker-compose up -d");
		RemoteWebDriver chrome = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeCapabilities);
		RemoteWebDriver firefox = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxCapabilities);

		// run against chrome
		chrome.get("https://www.google.com");
		System.out.println(chrome.getTitle());
		
		// run against firefox
		firefox.get("https://www.google.com");
		System.out.println(firefox.getTitle());

		chrome.quit();
		firefox.quit();
		// CmdUtilities.exec("docker-compose down");
	}
	
	@Test
	public void testGoogleSearch() {

		RemoteWebDriver chrome = null;
		
		try {
			chrome = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeCapabilities);
			
			// run against chrome
			chrome.get("https://www.google.com");
			wait.until(ExpectedConditions.elementToBeClickable(this.searchButton));
			 
			searchBox.sendKeys("automation");
			wait.until(ExpectedConditions.elementToBeClickable(this.searchButton));
			searchButton.click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.className("rc")));
			
			List<WebElement> results = searchResults;
			
			System.out.println(results.get(0).getText());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} finally {
			chrome.quit();
		}	
		
	}

}
