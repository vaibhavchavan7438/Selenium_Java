package chavan.vaibhav;

import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicTableRowColumns {

	public static void main(String[] args) throws ParseException  {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://demo.guru99.com/test/table.html");
	
		WebElement table=driver.findElement(By.xpath("/html/body/table/tbody"));
		
		List <WebElement> rowNumber=table.findElements(By.tagName("tr"));
		
		System.out.println("Number of rows in table are: " +rowNumber.size());
		
		for(int i=0;i<rowNumber.size();i++) {
			List <WebElement> column_Rows=rowNumber.get(i).findElements(By.tagName("td"));
			int columnNumber=column_Rows.size();
			System.out.println("Number of cells in row number"+i+ "are : "+ columnNumber);
		
			
			for(int j=0; j<columnNumber;j++) {
				String cellText=column_Rows.get(j).getText();
				System.out.println("The cell value in "+i+"th row and"+j+" th column is: " +cellText);
			}
			System.out.println("====================================================================");
		}
		//driver.close();
	}

}
