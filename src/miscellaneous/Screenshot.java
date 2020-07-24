package miscellaneous;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Screenshot {
WebDriver driver;

@Test
public void testScreenshot() throws IOException {
	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
	System.setProperty("webdriver.chrome.silentOutput", "true");
	driver=new ChromeDriver();
	Screenshot.CaptureScreenshot(driver, "G:\\scrnsht4.png");
	
	driver.get("https://www.google.co.in/");
	Screenshot.CaptureScreenshot(driver, "G:\\scrnsht2.png");
	driver.manage().window().maximize();
	Screenshot.CaptureScreenshot(driver, "G:\\scrnsht3");
}
/**
 * @param driver
 * @param filePath
 * @throws IOException
 */


public static void CaptureScreenshot(WebDriver driver, String filePath) throws IOException {
	
	TakesScreenshot shot=((TakesScreenshot)driver);
	
	File src=shot.getScreenshotAs(OutputType.FILE);
	
	File fileDest=new File(filePath);

	FileUtils.copyFile(src,fileDest);
	
	
}

}
