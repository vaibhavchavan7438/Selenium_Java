package cookies;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WriteCookies {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriver driver=new ChromeDriver(); 
	
		driver.get("http://demo.guru99.com/test/cookie/selenium_aut.php");
		
		 driver.findElement(By.name("username")).sendKeys("abc123");							
	        driver.findElement(By.name("password")).sendKeys("123xyz");							
	        driver.findElement(By.xpath("//button[@name='submit']")).click();	
	        
		File file=new File("cookies.data");
		
		try {
			file.delete();
			
			file.createNewFile();
			
			FileWriter fwrite=new FileWriter(file);
			
			BufferedWriter bwrite=new BufferedWriter(fwrite);
			
			for (Cookie ck:driver.manage().getCookies()) {
				
				bwrite.write(ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure());
				
				bwrite.newLine();
				
			}
			bwrite.close();
			fwrite.close();
			
			System.out.println("Cookies have been written");
			
		}catch(Exception e) {
		 e.printStackTrace();
		}
		
	}

}
