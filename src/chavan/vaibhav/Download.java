package chavan.vaibhav;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Download {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://demo.guru99.com/test/yahoo.html");
	WebElement download=	driver.findElement(By.xpath("//*[@id='messenger-download']"));
	
	String location=download.getAttribute("href");
	
	String wget=("cmd /c C:\\Wget\\wget.exe -P D:\\ --no-check-certificate " + location);
	
	try {
		Process exec=Runtime.getRuntime().exec(wget);
		int exitVal = exec.waitFor();
        System.out.println("Exit value: " + exitVal);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	
	
}
