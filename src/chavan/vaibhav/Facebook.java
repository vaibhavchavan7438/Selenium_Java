package chavan.vaibhav;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import java.util.concurrent.TimeoutException;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;
public class Facebook {

	public static void main(String[] args) throws TimeoutException, InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		
				
//		WebDriverWait myWait=new WebDriverWait(driver, 30);
		
        
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");

		WebDriver driver=new ChromeDriver(options); 
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		//WebElement fbImage=driver.findElement(By.xpath("//*[@id=\"blueBarDOMInspector\"]/div/div/div/div[1]/h1/a/i"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		WebElement login=driver.findElement(By.id("email"));
		WebElement password=driver.findElement(By.id("pass"));
		
		
		FileInputStream fis=new FileInputStream("G:\\programs_eclipse\\FirstSelenium\\src\\chavan\\vaibhav\\credentials.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		login.sendKeys(prop.getProperty("username"));
		
		password.sendKeys(prop.getProperty("password"));
		
		
	 	
		System.out.println("text entered into fields");
		

		WebElement signInButton=driver.findElement(By.xpath("//*[@id=\"u_0_b\"]"));
		signInButton.submit();


		//Click on navigation label to bring up selection list
		driver.findElement(By.id("userNavigationLabel")).click();
		Thread.sleep(10000);
		
		
		try {
		//Click on logout button from drop down menu 
		WebDriverWait wait=new WebDriverWait(driver, 60);
		System.out.println("waiting....");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//li[14]//a[1]//span[1]//span[1]"))));
		driver.findElement(By.xpath("//li[14]//a[1]//span[1]//span[1]")).click();
		}
		catch(Exception E) {
			E.printStackTrace();
		}
//		
		
	

		System.out.println("Execution completed");
	}

}
