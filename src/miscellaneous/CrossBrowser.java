package miscellaneous;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowser {
	WebDriver driver;

	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) {

		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		} else if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		}
	}
	
	@Test
	@Parameters("browser")
	public void verify() {
		
		driver.get("https://www.google.com/");
		
		String exp="Google";
		String act=driver.getTitle();
		
		Assert.assertEquals(exp,act);
	}
	
	@AfterTest
	@Parameters("browser")
	public void closeBrowser() {
		driver.close();
		
	}
	
}
