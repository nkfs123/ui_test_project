import org.junit.Assert;
import org.openqa.selenium.*;


public class EducationalVideosPage {

	private WebDriver web_driver;

	public EducationalVideosPage(WebDriver wd) {this.web_driver=wd;}

    public WebDriver clickOnLesson1_1() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) web_driver;
        js.executeScript("window.scrollBy(0,1000)", "");
        web_driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/div[1]/ul/li[2]/button")).click();
        Thread.sleep(1000);
        web_driver.findElement(By.partialLinkText("Introduction to the Financial Markets"));
        return web_driver;
    }

    public void playVideo(int durationInSeconds) throws InterruptedException {
        web_driver.switchTo().frame(web_driver.findElement(By.tagName("iframe")));
        web_driver.findElement(By.className("player-big-play-button")).click();
        Thread.sleep((long)durationInSeconds*1000);
        web_driver.switchTo().defaultContent();
    }
}