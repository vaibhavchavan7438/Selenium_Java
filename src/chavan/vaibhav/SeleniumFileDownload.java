package chavan.vaibhav;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumFileDownload {
	public static void main(String[] args) {
        
		 System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		 System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
		 WebDriver driver = new FirefoxDriver();
			
		driver.get("http://demo.guru99.com/test/yahoo.html");
	
		WebElement downloadButton=driver.findElement(By.id("messenger-download"));
		
		String sourceLocation=downloadButton.getAttribute("href");
		String wget_Command="cmd /c C:\\Wget\\wget.exe -P D:\\ --no-check-certificate " +sourceLocation;
		
		try {
			Process exec=Runtime.getRuntime().exec(wget_Command);
			int exitVal=exec.waitFor();
			System.out.println("Exit value is : " +exitVal);
		}
		catch(RuntimeException|IOException | InterruptedException ex) {
			System.out.println(ex.toString());
		}
	    driver.close();
			
			
			
			
	 }

}
