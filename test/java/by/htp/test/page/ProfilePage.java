package by.htp.test.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import by.htp.test.driver.DriverSingleton;

public class ProfilePage extends AbstractPage {
	private final Logger logger = LogManager.getRootLogger();
	private WebDriverWait driverWait;

	@FindBy(xpath = "//div[@id = 'info-results']")
	private WebElement profileName;

	public ProfilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {

	}

	public String getHeaderText() {
		return profileName.getText();
	}
}
