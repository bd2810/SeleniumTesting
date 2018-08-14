package seleniumTests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {

	static Capabilities chromeCapabilities = DesiredCapabilities.chrome();
	static Capabilities firefoxCapabilities = DesiredCapabilities.firefox();
    private GooglePage google;
    private RemoteWebDriver chrome;
    private RemoteWebDriver firefox;
    ChromeOptions dc = new ChromeOptions();

	
    @BeforeTest
    public void setUp() throws MalformedURLException {
    	System.out.println("Before suite setup begins..");
    	
    	String[] commands = { "docker-compose", "up", "-d" };
    	//cmd.executeCommand(commands);
        ChromeOptions dc = new ChromeOptions();
		RemoteWebDriver chrome = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);
		RemoteWebDriver firefox = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxCapabilities);
		google = new GooglePage(chrome);
		System.out.println("Before suite setup ends..");
    }
    
    @Test
    public void googleTest() throws InterruptedException {
    	System.out.println("googleTest begins..");
        google.goTo();
        System.out.println(chrome.getTitle());
        google.searchFor("automation");
        Assert.assertTrue(google.getResults().size() >= 10);
        System.out.println("googleTest ends..");
    }
    
    @AfterTest
    public void tearDown() throws InterruptedException {
        chrome.quit();
        System.out.println("Tear down ends..");
        String[] commands = {"docker-compose", "down"};
    	//cmd.executeCommand(commands);
    }

/*	public static void main(String[] args) throws MalformedURLException {


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
*/	
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


