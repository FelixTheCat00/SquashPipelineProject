package SquashTM.squash;


import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



public class SquashTest {
	WebDriver driver;
	String browser =System.getProperty("browser").toLowerCase().trim();
	
	@Before
	public void setupTest() {
		
		
		if (browser.equals("chrome")) {
		//	System.setProperty("webdriver.chrome.driver", "C:\\Installation\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if (browser.equals("firefox")) {
			//		  System.setProperty("webdriver.chrome.driver", "C:\\Installation\\driver\\geckodriver.exe");
			   driver = new FirefoxDriver();
		}
	}
	
	@Test
	public void SquashTest() throws InterruptedException{

		driver.get("http://192.168.102.95:8089/squash/login");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"login-form-button-set\"]/input")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='test-case-link']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//ins[@class='jstree-icon'])[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='tree-create-button']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Nouveau cas de test...')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='add-test-case-name']")).sendKeys("SQ Test");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='Ajouter' and @style]")).click();
		Thread.sleep(4000);
		String nomTest = driver.findElement(By.xpath("//a[@class='jstree-clicked ui-state-default' and contains(text(),'SQ Test')]")).getText();
		assertTrue(nomTest.contains("SQ Test"));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='jstree-clicked ui-state-default' and contains(text(),'SQ Test')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-trash']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='del-node-confirm-btn']")).click();
		Thread.sleep(3000);
		driver.close();
	}

}
