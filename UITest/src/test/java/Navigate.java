import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;

public class Navigate {
	
	private static WebDriver driver;

	@FindBy(xpath = "/html/body/div[3]/div/div/div[1]/div[3]/div[2]/div[3]/button")
	private WebElement acceptCookiesButton;

	public static void main(String[] args) {
	}
	
	public Navigate(int width, int height) {
        launchBrowser();
		setWindowSize(new Dimension(width,height));
	}

	public Navigate() {
		launchBrowser();
		driver.manage().window().maximize();
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver dr) {
		driver = dr;
	}

	public void acceptCookies() {
		WebElement acceptCookiesButton = driver.findElement(By.
				xpath("/html/body/div[3]/div/div/div[1]/div[3]/div[2]/div[3]/button"));
		acceptCookiesButton.click();
	}

	private void launchBrowser(){
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("http://www.xm.com");
	}

	private void setWindowSize(Dimension dim) {
		driver.manage().window().setSize(dim);
	}






	
	
	
	

}
