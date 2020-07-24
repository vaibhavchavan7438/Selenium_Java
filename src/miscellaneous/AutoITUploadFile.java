package miscellaneous;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AutoITUploadFile {

	
	WebDriver driver;
	@BeforeTest
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver=new ChromeDriver(); 
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		
	}
	@Test(priority=1)
	public void uploadFile() throws InterruptedException {
		driver.get("http://demo.guru99.com/test/autoit.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		try {
			Robot robot=new Robot();
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.delay(5000);
		
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
driver.findElement(By.xpath("//*[@id=\"input_3\"]"));
		driver.findElement(By.xpath("//input[@id='input_5']")).click();
		//driver.get("https://png2jpg.com/");
		//driver.findElement(By.xpath("//*[@id=\"pick-files\"]/span[2]")).click();
		
		try {
			Runtime.getRuntime().exec("G:\\AutoIT\\FileUpload.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("File Upload successfully");
		
	}
//	@Test(priority=2)
//	public void convertAndDownload() {
//		WebElement element=driver.findElement(By.xpath("//*[@id=\"o_1e5clbsg8eht1sr7glj106n9acl\"]/div/div[4]/div[1]"));
//		
//		WebDriverWait wait=new WebDriverWait(driver, 60);
//		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		element.click();
//		
//		System.out.println("File downloaded");
//	}
//	
	
}
