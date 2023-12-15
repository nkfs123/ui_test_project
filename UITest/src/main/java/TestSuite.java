import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestSuite {
	
	public static Navigate n;
	
	
	@Test
	public void clickLoginTest() {
		n = new Navigate();
		HomePage hp = new HomePage(n.getDriver());
		hp.clickSignInButton();
	}
	
	@Test
	public void failedLogin() {
		SignInPage sp = new SignInPage(n.getDriver());
		sp.enterEmail();
		n.getDriver().close();
	}
	
	

}
