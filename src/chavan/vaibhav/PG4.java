package chavan.vaibhav;
import java.text.NumberFormat;

import java.text.ParseException;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;





public class PG4 {

//	public static void main(String[] args) throws ParseException  {
//
//		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
//		System.setProperty("webdriver.chrome.silentOutput", "true");
//		WebDriver driver = new ChromeDriver();
//		
//		driver.get("http://demo.guru99.com/test/newtours/");
//	
//		String underConsTitle = "Under Construction: Mercury Tours";	
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		
//		List <WebElement> linkElements=driver.findElements(By.tagName("a"));
//		String[] linkTexts=new String[linkElements.size()];
//		
//		int i=0;
//		
//		for(WebElement e:linkElements) {
//			linkTexts[i]=e.getText();
//			i++;
//			
//		}
//		
//		for(String t: linkTexts) {
//		driver.findElement(By.linkText(t)).click();
//		
//		if(driver.getTitle().equalsIgnoreCase(underConsTitle)) {
//			System.out.println("\"" + t + "\"" + " is under construction.");	
//		}
//		else {
//			System.out.println("\"" + t + "\""								
//                    + " is working Fine ");		
//		}
//		driver.navigate().back();
//		
//		}
//		driver.quit();
//	}

	public static void main(String[] args) {									
        String baseUrl = "http://demo.guru99.com/test/newtours/";					
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");					
        WebDriver driver = new ChromeDriver();					
        		
        String underConsTitle = "Under Construction: Mercury Tours";					
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);					

			driver.get(baseUrl);					
        List<WebElement> linkElements = driver.findElements(By.tagName("a"));							
        String[] linkTexts = new String[linkElements.size()];							
			int					i = 0;					

			//extract the link texts of each link element		
			for (WebElement e : linkElements) {							
			linkTexts[i] = e.getText();							
			i++;			
        }		

			//test each link		
			for (String t : linkTexts) {							
			driver.findElement(By.linkText(t)).click();					
			if (driver.getTitle().equals(underConsTitle)) {							
                System.out.println("\"" + t + "\""								
                        + " is under construction.");
                driver.navigate().back();	
            } else {			
                System.out.println("\"" + t + "\""								
                        + " is working.");	
                driver.navigate().back();	
            }		
			//driver.navigate().back();			
        }		
			driver.quit();			
    }		
}
 	