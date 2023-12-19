import org.openqa.selenium.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	private WebDriver web_driver;
	
	public HomePage(WebDriver wd) {this.web_driver=wd;}

    public void assertLoadedHomepage(){
        WebElement createNewAccountButton = null;
        try {
            createNewAccountButton = web_driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[3]/div[1]/div[4]/div/div/a"));
        } catch (NoSuchElementException e) {
            System.out.println("The large Create New Account button did not appear");
        }
        Assert.assertNotNull(createNewAccountButton);
    }

    public WebDriver clickResearchAndEducationButton() {
        /*try {
            web_driver.findElement(By.xpath("/html/body/div[2]/div/header/nav/div[2]/div[4]/div/ul[1]/li[4]/a"));
        }
        catch (NoSuchElementException e){
            web_driver.findElement(By.className("fa-bars")).click();
            By rd_button = By.linkText("Research & Education");
            WebDriverWait wait = new WebDriverWait(web_driver, 5);
            wait.until(ExpectedConditions.elementToBeClickable(rd_button)).click();
            return web_driver;
        }*/
        web_driver.findElement(By.xpath("/html/body/div[2]/div/header/nav/div[2]/div[4]/div/ul[1]/li[4]/a")).click();
        return web_driver;
    }


}