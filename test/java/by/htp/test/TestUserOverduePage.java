package by.htp.test;

import static org.testng.Assert.assertEquals;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.htp.test.driver.DriverSingleton;
import by.htp.test.step.Steps;

public class TestUserOverduePage {
	private Steps steps;
	private final String login = "test";
	private final String password = "test";
	private final String headerOverduerPage = "Overdue books";
	private final String titleUserPage = "Home page";

	@BeforeMethod(groups = { "openMainPage" })
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
	}

	@Test(groups = { "openMainPage" })
	public void checkOpenUserOverduePage() {
		steps.authorization(login, password);
		Assert.assertEquals(steps.openUserOverduePage(), headerOverduerPage);		
	}
	
	@Test(groups = { "returnBook" })
	public void checkReturnBook() {
		steps.authorization(login, password);
		int countOfOverdueBooks = steps.getCountOfOverdueBooks();
		steps.returnBook();
		int countOfOverdueBooksAfterReturn = steps.getCountOfOverdueBooks();
		Assert.assertEquals(countOfOverdueBooksAfterReturn, countOfOverdueBooks-1);
	}
	
	@Test(groups = { "logoutFromMainPage" })
	public void checkLogoutFromUserOverduePage() {
		steps.authorization(login, password);
		steps.exitFromUserPage();
		String actualTitle = DriverSingleton.getDriver().getTitle();
		Assert.assertEquals(actualTitle, titleUserPage);
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
	steps.closeDriver();
	}
}
