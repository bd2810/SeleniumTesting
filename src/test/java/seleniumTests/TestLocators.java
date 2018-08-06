package seleniumTests;


import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLocators {
	
	public static WebDriver driver;
	
	@BeforeClass
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bhavik_D\\git\\SeleniumTesting\\target\\test-classes\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	@Test
	public void openChrome() {
		
		driver.get("https://www.redfin.com");
		System.out.println(driver.getTitle());
		driver.close();		
	}
	
	@Test
	public void searchRedfin() throws InterruptedException {
		
		try {
			
			driver.get("https://www.redfin.com");
			driver.findElement(By.id("search-box-input")).sendKeys("03060");
			driver.findElement(By.xpath("//div[@class='searchInputNode']//button[@title='Search']")).click();
			Thread.sleep(3000);
			String text = driver.findElement(By.xpath("//*[@data-rf-test-id='h1-header']")).getText();
			System.out.println(text);
			assertTrue(text.equals("03060 Real Estate"));	
			
		} finally {
			driver.close();	
		}			
			
	}
	
	@Test
	public void findByLinkText() throws InterruptedException {
		
		try {
			
			driver.get("https://www.redfin.com");
			driver.findElement(By.linkText("Redfin Buyer Savings")).click();
			Thread.sleep(5000);
			
		} finally {
			driver.close();	
		}			
			
	}
	
	
	
	
	
	

}
