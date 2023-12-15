import org.openqa.selenium.*;



import org.junit.*;


public class HomePage {
	
	private WebDriver web_driver;
	
	public HomePage(WebDriver wd) {this.web_driver=wd;}
  
   //Variables
	
    //@FindBy(xpath = "//*[@id=\"quick_login_register\"]")
	private WebElement clickAccept;
    private WebElement signInButton;

    
   //Methods
    public void clickSignInButton() {
    	clickAccept = web_driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div"));
    	clickAccept.click();
    	//WebElement acceptCookies = web_driver.findElement(null)
    	signInButton = web_driver.findElement(By.xpath("//*[@id=\"gb\"]/div/div[2]/a/span"));
        signInButton.click();
    }
}