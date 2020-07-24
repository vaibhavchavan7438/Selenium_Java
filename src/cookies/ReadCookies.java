package cookies;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;
import java.util.StringTokenizer;
import java.lang.Boolean;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadCookies {

//	public static void main(String[] args) {
//
//		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
//		System.setProperty("webdriver.chrome.silentOutput", "true");
//		WebDriver driver=new ChromeDriver(); 
//		
//		try {
//			File file=new File("cookies.data");
//			FileReader freader=new FileReader(file);
//			BufferedReader breader=new BufferedReader(freader);
//			
//			String strLine;
//			while((strLine=breader.readLine())!=null) {
//				StringTokenizer tok=new StringTokenizer(strLine,";");
//				
//				while(tok.hasMoreTokens()) {
//					String name=tok.nextToken();
//					String value = tok.nextToken();					
//			        String domain = tok.nextToken();					
//			        String path = tok.nextToken();					
//			        Date expiry = null;	
//			        
//			        String val;
//			        while(!(val=tok.nextToken()).equals(null)) {
//			        	expiry=new Date(val);
//			        }
//			        
//			        String s=tok.nextToken();
//			        Boolean isSecure=Boolean.parseBoolean(s);
//			       
//			        
//			        Cookie ck = new Cookie(name,value,domain,path,expiry,isSecure);			
//			        System.out.println(ck);
//			        driver.manage().addCookie(ck);
//			 
//				}
//				
//			}
//		}
//		catch(Exception e) {
//			
//		}
//		   driver.get("http://demo.guru99.com/test/cookie/selenium_aut.php");	
//		
//	}
//
//	

	public static void main(String[] args){ 
    	WebDriver driver;     
       	System.setProperty("webdriver.chrome.driver","C://chromedriver.exe");					
        driver=new ChromeDriver();					
    try{			
     
        File file = new File("Cookies.data");							
        FileReader fileReader = new FileReader(file);							
        BufferedReader Buffreader = new BufferedReader(fileReader);							
        String strline;			
        while((strline=Buffreader.readLine())!=null){									
        StringTokenizer token = new StringTokenizer(strline,";");									
        while(token.hasMoreTokens()){					
        String name = token.nextToken();					
        String value = token.nextToken();					
        String domain = token.nextToken();					
        String path = token.nextToken();					
        Date expiry = null;					
        		
        String val;			
        if(!(val=token.nextToken()).equals("null"))
		{		
        	expiry = new Date(val);					
        }		
        Boolean isSecure = new Boolean(token.nextToken()).								
        booleanValue();		
        Cookie ck = new Cookie(name,value,domain,path,expiry,isSecure);			
        System.out.println(ck);
        driver.manage().addCookie(ck); // This will add the stored cookie to your current session					
        }		
        }		
        }catch(Exception ex){					
        ex.printStackTrace();			
        }		
        driver.get("http://demo.guru99.com/test/cookie/selenium_aut.php");					
}	
}
