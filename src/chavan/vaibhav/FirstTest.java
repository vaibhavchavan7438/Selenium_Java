package chavan.vaibhav;

import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstTest {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
		WebDriver driver = new FirefoxDriver();

		driver.get("https://www.makemytrip.com/");

		driver.findElement(By.xpath("//input[@id='fromCity']")).click();

		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Mumbai" + Keys.ARROW_DOWN + Keys.ENTER);

	}
}
