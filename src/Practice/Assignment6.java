package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment6 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.qaclickacademy.com/");
		
		driver.findElement(By.xpath("//a[contains(text(),'Practice')]")).click();
		
		driver.findElement(By.id("checkBoxOption1")).click();
		
		String checkboxLable=driver.findElement(By.xpath("//div[@id='checkbox-example']//label[@for='bmw']")).getText();
		
		Select dropdown=new Select(driver.findElement(By.id("dropdown-class-example")));
		dropdown.selectByVisibleText(checkboxLable);
		
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(checkboxLable);
		driver.findElement(By.xpath("//input[@id='confirmbtn']")).click();
		
		
		
		Thread.sleep(2000);
		String alertMessage=driver.switchTo().alert().getText();
		
		if(alertMessage.contains(checkboxLable)) {
			Assert.assertTrue(true);
			System.out.println("Test case passed");
		}
		else {
			System.out.println("Test case failed");
		}
		
		driver.close();
	}

}
