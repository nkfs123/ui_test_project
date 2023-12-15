import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import org.junit.*;


public class Navigate {
	
	private static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Setting system properties of ChromeDriver
		/*System.setProperty("webdriver.chrome.driver", "C:\\Users\\nkfsf\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		HomePage hp = new HomePage(driver);
		
		hp.clickSignInButton();*/

	}
	
	public Navigate () {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nkfsf\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	
	
	

}
