package miscellaneous;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AjaxTest {

	
	WebDriver driver;
	WebDriverWait wait;
	@BeforeTest
	private void setup() {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver=new ChromeDriver(); 
		driver.navigate().to("http://demo.guru99.com/test/ajax.html");
		
	}
	
	@Test
	private void ajaxTest() {

		WebElement container=driver.findElement(By.xpath("//div[@class='container']//form"));
		wait=new WebDriverWait(driver, 10);
		WebElement noText=driver.findElement(By.xpath("//p[@class='radiobutton']"));
		wait.until(ExpectedConditions.visibilityOf(container));
		
		//Before ajax
		
		String noTextString=noText.getText().trim();
		
		driver.findElement(By.xpath("//input[@id='yes']")).click();

		driver.findElement(By.xpath("//input[@id='buttoncheck']")).click();
		
		//After Ajax
		
		wait.until(ExpectedConditions.visibilityOf(noText));
		String textString=noText.getText().trim();
		
		Assert.assertNotEquals(noTextString, textString);
		
	}
}
