package chavan.vaibhav;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Hovering {

	public static void main(String[] args) throws InterruptedException  {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

//		driver.get("https://opensource-demo.orangehrmlive.com/");
//		
//
//		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
//		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
//		
//		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
//		
//		driver.findElement(By.xpath("//b[contains(text(),'Time')]")).click();
//		
//		WebElement dropDown=driver.findElement(By.xpath("//select[@id='time_startingDays']"));
//		Select select=new Select(dropDown);
//		select.selectByVisibleText("Monday");
//		
//		driver.findElement(By.xpath("//input[@id='btnSave']"));
//		 	
//		Thread.sleep(1000);
//		
//		driver.close();
		
		driver.get("https://www.flipkart.com/");
		
		//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		WebDriverWait wait =new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div/button"))).click();
		
		WebElement electronics =driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div/ul/li[1]/span"));

	Actions builder=new Actions(driver);
	builder.moveToElement(electronics).build().perform();
	
	driver.findElement(By.linkText("Apple")).click();
	//driver.close();
	}
}