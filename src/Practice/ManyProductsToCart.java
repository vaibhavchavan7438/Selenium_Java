package Practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class ManyProductsToCart {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
		WebDriver driver = new FirefoxDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String[] vegetableNames = { "Tomato", "Cucumber", "Potato" };
		


		List<WebElement> products = driver.findElements(By.xpath("//div[@class='product']"));


			
			for(int i=0;i<vegetableNames.length;i++) {
				String vegName=vegetableNames[i];
				//System.out.println("vegname =" +vegName);

				for (WebElement element : products) {
					String[] vegetables = element.getText().split("-");
					String formattedVegetableName = vegetables[0].trim();
					//System.out.println("formattedvegName " + formattedVegetableName);
					
					
				int count=0;
				if(vegName.contains(formattedVegetableName)) {
					count++;
					//Assert.assertEquals(vegName, formattedVegetableName);
					
					driver.findElement(By.xpath("//h4[contains(text(),'"+vegName+" - 1 Kg')]/parent::div[@class='product']//div[@class='product-action']//button[@type='button']")).click();
					
					
					
					if(count==vegetableNames.length) {
						break;
					}
					
				}
			}
		}
	}

}
