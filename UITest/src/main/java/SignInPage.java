import org.openqa.selenium.*;

public class SignInPage {
	
private WebDriver web_driver;
	
public SignInPage(WebDriver wd) {this.web_driver=wd;}

private WebElement emailField;
private WebElement loginButton;

public void enterEmail() {
	emailField = web_driver.findElement(By.xpath("//*[@id=\"identifierId\"]"));
	emailField.sendKeys("blabla");
	loginButton = web_driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span"));
	loginButton.click();
}

}
