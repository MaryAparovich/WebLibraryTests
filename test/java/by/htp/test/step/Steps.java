package by.htp.test.step;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import by.htp.test.driver.DriverSingleton;
import by.htp.test.page.LoginPage;
import by.htp.test.page.MainUserOverduePage;
import by.htp.test.page.MainUserPage;
import by.htp.test.page.ProfilePage;

public class Steps {

	private WebDriver driver;
	private MainUserPage mainUserPage;
	private WebDriverWait driverWait;
	private LoginPage loginPage;
	private MainUserOverduePage mainUserOverduePage;
	private ProfilePage profilePage;

	private final Logger logger = LogManager.getRootLogger();

	public void initBrowser() {
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver() {
		DriverSingleton.closeDriver();
	}
	
	public void authorization(String login, String password) {
		loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.login(login, password);
	}
	
	public String openUserPage() {
		mainUserPage = new MainUserPage(driver);
		String headerText = mainUserPage.getHeaderText();
		return headerText;
	}
	
	public String openUserOverduePage() {
		mainUserOverduePage = new MainUserOverduePage(driver);
		String headerText = mainUserOverduePage.getHeaderText();
		return headerText;
	}
	
	public void exitFromUserPage() {
		mainUserPage = new MainUserPage(driver);
		mainUserPage.logout();
	}
	
	public String getTheProfileNameByLink() {
		mainUserPage = new MainUserPage(driver);
		profilePage = new ProfilePage(driver);
		mainUserPage.clickProfile();
		String profileText = profilePage.getHeaderText();
		return profileText;
	}
	
	public int getCountOfOverdueBooks() {
		mainUserOverduePage = new MainUserOverduePage(driver);
		int countBooks = mainUserOverduePage.getBooks().size();
		return countBooks;
	}
	
	public void returnBook() {
		mainUserOverduePage = new MainUserOverduePage(driver);
		mainUserOverduePage.checkInClick();
	}
}
