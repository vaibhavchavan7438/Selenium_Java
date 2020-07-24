package practicePackage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.guru99.com/selenium-tutorial.html");

		List<WebElement> performLinks=findValidLinks(driver);
		for(WebElement element: performLinks) {
			System.out.println("link >>"+element+ " is  ---->>" + findBrokenUrl(new URL(element.getAttribute("href"))));
		}
		
		

	}

	public static List findValidLinks(WebDriver driver) {

		List<WebElement> linkElement = new ArrayList<WebElement>();

		linkElement = driver.findElements(By.tagName("a"));

		linkElement.addAll(driver.findElements(By.tagName("img")));

		List<WebElement> finalLinkList = new ArrayList<WebElement>();

		for(WebElement element:linkElement) {
			
			if(element.getAttribute("href")!=null) {
				finalLinkList.add(element);
				
			}
			
		}
		return finalLinkList;
	}

	public static String findBrokenUrl(URL url) {
		
		String response="";
		
		try {
			HttpURLConnection con=(HttpURLConnection) url.openConnection();
			con.connect();
			response=con.getResponseMessage();
			con.disconnect();
			return response;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
		
			
			e.printStackTrace();
			return e.getMessage();
		}
		
	}
}
