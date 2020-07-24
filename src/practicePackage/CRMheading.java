package practicePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CRMheading {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://classic.crmpro.com");
		driver.manage().window().maximize();
	
		String h1=driver.findElement(By.cssSelector("h1.skrollable.skrollable-between")).getText();
		driver.findElement(By.cssSelector("button[data-slide='next']")).click();
		Thread.sleep(5000);
		String h2=driver.findElement(By.cssSelector("h1.skrollable.skrollable-between")).getText();
		
		System.out.println(h1);
		System.out.println(h2);
	}

}
