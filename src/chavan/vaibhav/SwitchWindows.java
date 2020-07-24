package chavan.vaibhav;

import java.util.Iterator;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SwitchWindows {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		System.setProperty("FirefoxDriver.SystemProperty.BROWSER_LOGFILE", "null");
		WebDriver driver=new FirefoxDriver();
		driver.get("http://demo.guru99.com/popup.php");
		driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();


		String mainWindow=driver.getWindowHandle();
		
		Set<String> s1=driver.getWindowHandles();
		Iterator<String> i1=s1.iterator();
		
		while(i1.hasNext()) {
			String childWindow=i1.next();
			if(!mainWindow.equalsIgnoreCase(childWindow)) {
				driver.findElement(By.xpath("/html/body/form/table/tbody/tr[5]/td[2]/input")).sendKeys("vaibhav67@gmail.com");
				
				driver.findElement(By.name("btnLogin")).click();
				driver.close();

			}
			
			driver.switchTo().window(mainWindow);
			
						
		}
		
		
		
	}

}
