package practicePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hpsf.Array;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class loginDetailParameterization {

	WebDriver driver;
	static Workbook book;
	static Sheet sheet;
	static String sheetName = "login";
	static String filePath = "C:\\Users\\Vaibhav\\Desktop\\credential.xlsx";

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		// System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE , "null");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://demo.guru99.com/V4/index.php");
	}

	@DataProvider(name = "getLoginData")
	public static Object[][] getExcelData() throws IOException {

//		FileInputStream fis = new FileInputStream(filePath);
//
//		book = WorkbookFactory.create(fis);
//
	   File file=new File(filePath);
	   FileInputStream fis=new FileInputStream(file);
		book=new XSSFWorkbook(fis);
		sheet = book.getSheet(sheetName);

		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		System.out.println(rowCount);
		int colCount = sheet.getRow(0).getLastCellNum();
		System.out.println(colCount);

		Object[][] data = new Object[rowCount][colCount];
		for (int row = 0; row < rowCount; row++) {
			for (int col = 0; col < colCount; col++) {
				data[row][col] = sheet.getRow(row+1).getCell(col).toString();
				System.out.println(data[row][col]);
			}
		}
		return data;

	}

	@Test(dataProvider = "getLoginData")
	public void loginTest(String username, String password) {
		driver.findElement(By.name("uid")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);

		driver.findElement(By.name("btnLogin")).click();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
