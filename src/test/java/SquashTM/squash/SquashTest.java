package SquashTM.squash;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



public class SquashTest {
	
	@Test
	public void SquashTest() throws InterruptedException{

		System.setProperty("webdriver.chrome.driver", "C:\\Installation\\driver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://192.168.102.95:8089/squash/login");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"login-form-button-set\"]/input")).click();
		Thread.sleep(3000);
		driver.close();
	}

}
