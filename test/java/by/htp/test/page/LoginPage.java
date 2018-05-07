package by.htp.test.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractPage
{
	private final Logger logger = LogManager.getRootLogger();
	private final String BASE_URL = "http://node51579-env-1995265.mycloud.by/login.jsp";
	private WebDriverWait driverWait;

	@FindBy(name = "login")
	private WebElement loginField;

	@FindBy(name = "password")
	private WebElement passwordField;
	
	@FindBy(xpath = "//*[@id=\"login_form\"]/button")
	private WebElement loginButton;

	public LoginPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage()
	{
		driver.navigate().to(BASE_URL);
		logger.info("Login page opened");
	}
	
	public void login(String login, String password) 
	{ 
		loginField.sendKeys(login);
		passwordField.sendKeys(password);
		loginButton.click();
	}
}
