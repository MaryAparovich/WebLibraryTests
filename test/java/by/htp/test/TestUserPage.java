package by.htp.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.htp.test.driver.DriverSingleton;
import by.htp.test.step.Steps;

public class TestUserPage {
	private Steps steps;
	private final String login = "boby";
	private final String password = "qwer";
	private final String headerUserPage = "User page";
	private final String titleUserPage = "Home page";

	@BeforeMethod(groups = { "openMainPage" })
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
	}

	@Test(groups = { "openMainPage" })
	public void checkOpenUserPage() {
		steps.authorization(login, password);
		Assert.assertEquals(steps.openUserPage(), headerUserPage);
	}

	@Test (groups = {"link"})
	public void checkLinkToProfile() {
		steps.authorization(login, password);
		String actualProfileName = steps.getTheProfileNameByLink();
		Assert.assertEquals(actualProfileName, login);
	}

	@Test(groups = { "logoutFromMainPage" })
	public void checkLogoutFromUserPage() {
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
