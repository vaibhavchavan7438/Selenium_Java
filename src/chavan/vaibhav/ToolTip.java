package chavan.vaibhav;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;




public class ToolTip {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://demo.guru99.com/test/tooltip.html");
		
		Actions builder=new Actions (driver);
		
		String expectedToolTip="What's new in 3.2";
		
		WebElement download=driver.findElement(By.xpath("//*[@id=\"download_now\"]"));
		builder.clickAndHold().moveToElement(download);
		builder.moveToElement(download).build().perform();
		
		String actualToolTip=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/a")).getText();
		
		if(expectedToolTip.equals(actualToolTip)) {
			System.out.println("Test case passed");
		}
		
	driver.close();
	}

}
