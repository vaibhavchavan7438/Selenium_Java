package miscellaneous;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
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
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.javatpoint.com/java-tutorial");
		
		BrokenLinks bl=new BrokenLinks();
		
		List<WebElement> performLinks=bl.allLinks(driver);
		System.out.println("number of links : " + performLinks.size());
		
		for(WebElement element: performLinks) {
			
			String s=element.getAttribute("href")+ " returned " + bl.brokenLink(new URL(element.getAttribute("href")));
			System.out.println(s);
		}
		
		
	}
	public List allLinks(WebDriver driver) {
		
		
		List<WebElement> allLink=new ArrayList();
		allLink=driver.findElements(By.tagName("a"));
		
		allLink.addAll(driver.findElements(By.tagName("img")));
		
		List finalList=new ArrayList();
		

		for(WebElement linkElement:allLink) {
			if(linkElement.getAttribute("href")!=null) {
				finalList.add(linkElement);
			}
		}
		return finalList;
		
	}
	
	public String brokenLink(URL url) {
		
		String response="";
		
		try {
			HttpURLConnection con= (HttpURLConnection) url.openConnection();
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
