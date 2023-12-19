import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.concurrent.TimeUnit;

public class TestSuite_windowMaximized {
	
	public static Navigate n;
	public static HomePage homePage;

	@Before
	public void launch() {
		n = new Navigate();
		n.acceptCookies();
		homePage = new HomePage(n.getDriver());
	}

	@Test
	@DisplayName("SubTest 1: Open Home page (make any check here if needed)")
	public void goToHomePage() {
		homePage.assertLoadedHomepage();
	}
	@Test
	@DisplayName("SubTest 2: Click the Research and Education link located at the top menu - make any check here if needed")
	public void clickResearchAndEducation() throws InterruptedException {
		ResearchEducationPage researchEducationPage = new ResearchEducationPage(n.getDriver());
		Thread.sleep(2000);
		n.setDriver(homePage.clickResearchAndEducationButton());
        Thread.sleep(2000);
		researchEducationPage.assertLoadedResearchEducationPage();
	}

	@Test
	@DisplayName("SubTests 3 to 6")
	public void economicCalendarTests() throws InterruptedException {
		ResearchEducationPage researchEducationPage = new ResearchEducationPage(n.getDriver());
		EconomicCalendarPage economicCalendarPage = new EconomicCalendarPage((n.getDriver()));
		Thread.sleep(2000);
		n.setDriver(homePage.clickResearchAndEducationButton());
		Thread.sleep(2000);
		n.setDriver(researchEducationPage.clickOnEconomicCalendar());
		Thread.sleep(2000);
		economicCalendarPage.assertEconomicCalendarHeader();
		Thread.sleep(2000);
		economicCalendarPage.setSliderToSpecificDateRange("Today");
		Thread.sleep(2000);
		economicCalendarPage.assertDisplayedDates("Today");
		Thread.sleep(2000);
		economicCalendarPage.setSliderToSpecificDateRange("Tomorrow");
		Thread.sleep(2000);
		economicCalendarPage.assertDisplayedDates("Tomorrow");
		Thread.sleep(2000);
		economicCalendarPage.setSliderToSpecificDateRange("Next Week");
		Thread.sleep(2000);
		economicCalendarPage.assertDisplayedDates("Next Week");
		Thread.sleep(2000);
	}

	@Test
	@DisplayName("SubTests 7 - 9: Click Educational Videos AND Click the Lesson 1.1 “Introduction to the Financial Markets AND Educational video should play for a minimum of 5 seconds")
	public void testEducationalVideo() throws InterruptedException {
		ResearchEducationPage researchEducationPage = new ResearchEducationPage(n.getDriver());
		EducationalVideosPage educationalVideosPage = new EducationalVideosPage(n.getDriver());
		Thread.sleep(2000);
		n.setDriver(homePage.clickResearchAndEducationButton());
		Thread.sleep(5000);
		n.setDriver(researchEducationPage.clickOnEducationalVideos());
		Thread.sleep(2000);
		n.setDriver(educationalVideosPage.clickOnLesson1_1());
		Thread.sleep(2000);
		educationalVideosPage.playVideo(5);
	}
	
	@After
	public void closeBrowser() {
		n.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		n.getDriver().close();
	}
	
	

}
