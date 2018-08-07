package seleniumTests;


import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLocators {
	
	public static WebDriver driver;
	
	@BeforeClass
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
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
			WebElement element = driver.findElement(By.id("search-box-input"));
			element.sendKeys("03060");
			
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
	
	@Test
	public void findByXpathHref() throws InterruptedException {
		
		try {
			
			driver.get("https://www.yahoo.com");
			driver.findElement(By.xpath("//a[@href='https://www.yahoo.com/news/']")).click();
			Thread.sleep(3000);
			String text = driver.findElement(By.xpath("//a[@title='News Home']")).getText();
			System.out.println(text);
			assertTrue(text.equals("News Home"));
		
		} finally {
			driver.close();	
		}			
			
	}
	
    public void hoverOver(String automationTag) {
        WebElement ele = driver.findElement(By.id(automationTag));
        System.out.println("Success: " + automationTag + " found prior to move to element.");
        Actions action = new Actions(driver);
        action.moveToElement(ele).build().perform();
        System.out.println("Success: hover over action performed.");
    }
	
	
	@Test
	public void testShutterfly() throws InterruptedException {
		
		try {
			
			driver.get("https://www.shutterfly.com");
			driver.manage().window().maximize();
			Thread.sleep(3000);
			WebElement elem = driver.findElement(By.cssSelector(".legacy.modal.fade.in"));
			
			if (elem != null) {
				driver.findElement(By.className("modal-close")).click();
			}
			
			List <WebElement> elements = driver.findElements(By.className("catItem"));		
			
			for (WebElement e : elements) {
				
				if (e.getText().equals("Home Décor")) {
					e.click();
					break;
				}
			}
			
			List <WebElement> elements2 = driver.findElements(By.className("productWrapper"));		
			
			for (WebElement e2 : elements2) {
				
				if (e2.getText().contains("Canvas Prints")) {
					e2.click();
					Thread.sleep(5000);
					break;
				}
			}
			

		
		} finally {
			driver.close();	
		}			
			
	}
	
	
	
	

}
