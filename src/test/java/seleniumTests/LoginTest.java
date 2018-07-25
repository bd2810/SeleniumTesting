package seleniumTests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class LoginTest {

	static Capabilities chromeCapabilities = DesiredCapabilities.chrome();
	static Capabilities firefoxCapabilities = DesiredCapabilities.firefox();

	public static void main(String[] args) throws MalformedURLException {

		RemoteWebDriver chrome = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeCapabilities);
		RemoteWebDriver firefox = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxCapabilities);

		// run against chrome
		chrome.get("https://ci-api-gateway.cf.isus.emc.com");
		
		//chrome.manage().window().maximize();
		
		WebElement user = chrome.findElement(By.id("username"));
		user.sendKeys("a@a.com");
		
		WebElement submit = chrome.findElement(By.name("submit"));
		submit.click();
		System.out.println(chrome.getTitle());

		// run against firefox
		//firefox.get("https://www.google.com");
		//System.out.println(firefox.getTitle());

		chrome.quit();
		firefox.quit();
	}

	

	//@Test
	public static void testLogin() throws MalformedURLException {	

		//ChromeOptions cap = new ChromeOptions();
		Capabilities cap = DesiredCapabilities.chrome();
		
        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/grid/wd/hub"), cap);
		
		driver.get("https://ci-api-gateway.cf.isus.emc.com");
		
		driver.manage().window().maximize();
		
		WebElement user = driver.findElement(By.id("username"));
		user.sendKeys("a@a.com");
		
		WebElement submit = driver.findElement(By.name("submit"));
		submit.click();
		
		Assert.assertTrue(driver.findElement(By.id("shell-plugin-area")).isDisplayed());
		
		driver.close();
	
		/*		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bhavik_D\\Documents\\Personal Github\\SeleniumTesting\\src\\"
		+ "test\\resources\\chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
driver.get("https://ci-api-gateway.cf.isus.emc.com");

driver.manage().window().maximize();

WebElement user = driver.findElement(By.id("username"));
user.sendKeys("a@a.com");

WebElement submit = driver.findElement(By.name("submit"));
submit.click();

//WebElement welcome = driver.findElement(arg0)

//driver.close();

*/
		
	}

}
