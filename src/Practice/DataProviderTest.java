package Practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

	WebDriver driver;
	
	static Workbook book;
	static Sheet sheet;
	
	static String filePath="C:\\Users\\Vaibhav\\Desktop\\SeleniumSheet1.xls";
	static String sheetName="Sheet1";
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		
		driver=new ChromeDriver();
		
		driver.get("https://www.google.com/");
		
	}
	
	@Test(dataProvider="searchKeyword")
	public void test(String user, String keyword) {
		
		driver.findElement(By.name("q")).sendKeys(keyword);
		
		System.out.println("user " +user + " has entered "+keyword+ " keyword in the searchbox");
		String text=driver.findElement(By.name("q")).getAttribute("value");
		
		System.out.println(text + " :::: " +keyword);
		
		Assert.assertEquals(text, keyword);
		
	}
	
	@DataProvider(name="searchKeyword")
	public static Object[][] getDataFromDataProvider(){
		File file= new File(filePath);
		try {
			FileInputStream fis=new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Workbook wb=new HSSFWorkbook();
		Sheet sheet=wb.getSheet(sheetName);
		
		
		int rowCount=sheet.getLastRowNum();
		System.out.println("rowCount"+rowCount);
		int columnCount=sheet.getRow(0).getLastCellNum();
		System.out.println("columns" + columnCount);
		Object[][] data=new Object[rowCount][columnCount];
		for(int row=1;row<rowCount;row++) {
			for(int col=0;col<columnCount;col++) {
				data[row][col]=sheet.getRow(row).getCell(col).toString();
				System.out.println(data[row][col]);
			}
		}
		
		
		return data;
		
//		return new Object[][] {
//			{"Vaibhav", "Amazon"},
//			{"Suraj","Flipkart"}
//		}
		
//		FileInputStream file = null;
//		try {
//			file = new FileInputStream(filePath);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		try {
//			book = WorkbookFactory.create(file);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		sheet = book.getSheet(sheetName);
//		
//		int rowCount=sheet.getLastRowNum();
//		int columnCount=sheet.getRow(0).getLastCellNum();
//		Object[][] data = new Object[rowCount][columnCount];//Object[][] data= new Object[rowCount][colCount];
//		// System.out.println(sheet.getLastRowNum() + "--------" +
//		// sheet.getRow(0).getLastCellNum());
//		for (int i = 0; i < rowCount; i++) {
//			for (int k = 0; k < columnCount; k++) {
//				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
//				 System.out.println(data[i][k]);
//			}
//		}
//		return data;
	}
	
	
	 @AfterMethod
	 public void tearDown() {
		 driver.close();
	 }
}
