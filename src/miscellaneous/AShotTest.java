package miscellaneous;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
public class AShotTest {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriver driver  = new ChromeDriver();	

		driver.get("http://demo.guru99.com/test/guru99home/");
		driver.manage().window().maximize();
				
		// Find the element to take a screenshot

		WebElement element =driver.findElement(By.xpath("//*[@id=\"rt-header\"]/div/div[1]/div/a/img"));
		Screenshot screenshot=new AShot().takeScreenshot(driver, element);
		
		BufferedImage expImage=ImageIO.read(new File("G:\\ElementScreenshot.png"));
		
		BufferedImage actualImage=screenshot.getImage();
		
		ImageDiffer imageDiffer=new ImageDiffer();
		ImageDiff imgDiff=imageDiffer.makeDiff(expImage, actualImage); 
		
		if(imgDiff.hasDiff()==true) {
			System.out.println("Images are same");
		}
		
		else System.out.println("Images are not same");
		
	}
}