package chavan.vaibhav;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import okio.Timeout;

public class Iframe {

	public WebDriver driver;
		@BeforeTest
		public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		}
		
		@Test(priority=1)
		public void findFrame() throws InterruptedException {
		driver.get("http://demo.guru99.com/test/guru99home/");
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
//		int size=driver.findElements(By.tagName("iFrame")).size();
//		
//		for (int i=0;i<=size;i++) {
//			driver.switchTo().frame(i);
//			int total=driver.findElements(By.xpath("html/body/a/img")).size();
//			System.out.println(total);
//			driver.switchTo().defaultContent();
//		}
		driver.switchTo().frame(1);
		driver.findElement(By.xpath("html/body/a/img")).click();
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		
		String act=driver.getTitle();
		String exp="Demo Guru99 Page";
		Assert.assertEquals(act,exp);
		}
		@Test(priority=2)
		public void closeBrowser() {
		driver.close();
		}
		
	

}
