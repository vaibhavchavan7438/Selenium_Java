package chavan.vaibhav;

import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MaxCellValue {
	public static void main(String[] args) throws ParseException  {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://money.rediff.com/gainers");
		
		String max;
		double r=0,m=0;
		
		
		List NumberOfColumns=driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/thead/tr/th"));
		List NumberOfRows=driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr/td[1]"));
		
		System.out.println("Number of Columns are :" + NumberOfColumns.size());
		System.out.println("Number of rows are: " + NumberOfRows.size());
		
		String sample=driver.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[2]/td[4]")).getText();
		//System.out.println(sample);
		
		for(int i=1;i<NumberOfRows.size();i++) {
			
			max=driver.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr["+(i+1)+"]/td[4]")).getText().trim();
			
			NumberFormat nf=NumberFormat.getNumberInstance();
			Number num=nf.parse(max);
			max=num.toString();
			
			m=Double.parseDouble(max);
			if(m>r) {
				r=m;
			}
			
		}
		System.out.println("Max value is : " +r);
		
		TakesScreenshot shot=(TakesScreenshot) driver;
		
		File srcFile=shot.getScreenshotAs(OutputType.FILE);
		
		File destFile=new File("D:\\abc.png");
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		
		
		driver.close();
	}

}
