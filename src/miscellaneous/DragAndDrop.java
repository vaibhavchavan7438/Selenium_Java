package miscellaneous;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragAndDrop {

	WebDriver driver;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://demo.guru99.com/test/drag_drop.html");
	}

	@Test
	private void dragTest() {

		WebElement from1 = driver.findElement(By.xpath("//li[contains(@class,'block15 ui-draggable')]"));

		WebElement to1 = driver.findElement(By.xpath("//*[@id='loan']/li"));

		Actions builder = new Actions(driver);
		builder.dragAndDrop(from1, to1).build().perform();
		String s=driver.findElement(By.xpath("//*[@id=\"loan\"]/li")).getText();

		Assert.assertEquals(s, "SALES");
	}

	@AfterTest
	private void closeBrowser() {
		driver.close();
	}
}
