package chavan.vaibhav;     

import java.util.Iterator;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



public class Practice {
public static void main(String[] args) {
	
	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
	System.setProperty("webdriver.chrome.silentOutput", "true");
	WebDriver driver=new ChromeDriver();
	
	driver.get("https://classic.freecrm.com/");
	
	driver.findElement(By.name("username")).sendKeys("batchautomation");
	
	driver.findElement(By.name("password")).sendKeys("test@12345");
	
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Actions builder =new Actions(driver);
	driver.switchTo().frame("mainpanel");
	WebElement contacts= driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
	
	builder.moveToElement(contacts).build().perform();
	
	driver.findElement(By.xpath("//a[contains(text(),'New Contact')]")).click();
	
	Select select=new Select(driver.findElement(By.name("title")));
	select.selectByVisibleText("Mr.");
	driver.findElement(By.name("first_name")).sendKeys("ABC");
	
	driver.findElement(By.name("surname")).sendKeys("LMN");
	
	driver.findElement(By.xpath("//input[@type='submit' and @value='Save']")).click();
	
	
	
	//driver.close();
}
}
