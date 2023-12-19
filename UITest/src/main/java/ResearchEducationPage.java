import org.junit.Assert;
import org.openqa.selenium.*;

public class ResearchEducationPage {

	private WebDriver web_driver;

	public ResearchEducationPage(WebDriver wd) {this.web_driver=wd;}

    public void assertLoadedResearchEducationPage(){
        WebElement infoBox = null;
        try {
            infoBox = web_driver.findElement(By.xpath("/html/body/div[2]/div/header/nav/div[2]/div[4]/div/ul[1]/li[4]/div/div/div[1]"));
        } catch (NoSuchElementException e) {
            System.out.println("The info box \"Research & Education\" did not appear");
        }
        Assert.assertNotNull(infoBox);
    }

    public WebDriver clickOnEconomicCalendar() {
        JavascriptExecutor js = (JavascriptExecutor) web_driver;
        js.executeScript("window.scrollBy(0,500)", "");

        web_driver.findElement(By.xpath("/html/body/div[2]/div/header/nav/div[2]/div[4]/div/ul[1]/li[4]/div/div/div[3]/div[1]/ul/li[6]/a")).click();
        return web_driver;
    }

    public WebDriver clickOnEducationalVideos() throws InterruptedException {
        web_driver.findElement(By.linkText("Educational Videos")).click();
        Thread.sleep(2000);
        return web_driver;
    }

}