import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;
import java.util.List;

public class EconomicCalendarPage {

	private WebDriver web_driver;

	public EconomicCalendarPage(WebDriver wd) {this.web_driver=wd;}

   //Methods

    public void assertEconomicCalendarHeader() {
        WebElement economicCalendarHeader = null;
        try {
            economicCalendarHeader = web_driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/section/div/div[3]/div[1]/h2"));
        } catch (NoSuchElementException e) {
            System.out.println("The header of the economic calendar page did not appear");
        }
        Assert.assertNotNull(economicCalendarHeader);
    }

    public void setSliderToSpecificDateRange(String dateRange) throws InterruptedException {
        web_driver.switchTo().frame(0);
        Thread.sleep(5000);
        WebElement slider = web_driver.findElement(By.className("mat-slider-thumb"));
        WebElement text;
        Actions move = new Actions(web_driver);
        int i = 0;
        do {
            Action action = move.dragAndDropBy(slider, i, 0).build();
            action.perform();
            i += 10;
            text = web_driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/div/table/tbody/tr/td/economic-calendar/div/tc-economic-calendar-landing/div/tc-economic-calendar-view-container/div/div/div[2]/div[1]/tc-time-filter-container/div/div/span/span/div"));
        } while (!text.getText().equals(dateRange));

        web_driver.switchTo().defaultContent();
    }

    public void assertDisplayedDates(String dateRange) {
        web_driver.switchTo().frame(0);
        List<WebElement> selectedDates;
        List<WebElement> datesInRange;

        switch (dateRange) {
            case "Today":
                selectedDates = web_driver.findElements(By.className("mat-calendar-body-selected"));
                Assert.assertEquals(Integer.parseInt(selectedDates.get(0).getText()), LocalDateTime.now().getDayOfMonth());
                Assert.assertEquals(selectedDates.size(),1);
                break;
            case "Tomorrow":
                selectedDates = web_driver.findElements(By.className("mat-calendar-body-selected"));
                Assert.assertEquals(Integer.parseInt(selectedDates.get(0).getText()), LocalDateTime.now().plusDays(1).getDayOfMonth());
                Assert.assertEquals(selectedDates.size(),1);
                break;
            case "Next Week":
                selectedDates = web_driver.findElements(By.className("mat-calendar-body-selected"));
                datesInRange = web_driver.findElements(By.className("mat-calendar-body-in-range"));
                Assert.assertEquals(Integer.parseInt(selectedDates.get(0).getText()), LocalDateTime.now().plusDays(6).getDayOfMonth());
                Assert.assertEquals(Integer.parseInt(selectedDates.get(1).getText()), LocalDateTime.now().plusDays(12).getDayOfMonth());
                Assert.assertEquals(selectedDates.size(),2);
                Assert.assertEquals(datesInRange.size(),7);
                int i = 6;
                for (WebElement date : datesInRange) {
                    Assert.assertEquals(Integer.parseInt(date.getText()), LocalDateTime.now().plusDays(i).getDayOfMonth());
                    i++;
                }
                break;
            default:
                break;
        }
        web_driver.switchTo().defaultContent();
    }
}