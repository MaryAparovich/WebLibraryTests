package by.htp.test.page;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainUserOverduePage extends AbstractPage {
	private final Logger logger = LogManager.getRootLogger();
	private WebDriverWait driverWait;

	@FindBy(id = "header")
	private WebElement header;
	
	@FindBy(xpath = "//td[@class='sorting_1']")
	private List<WebElement> books;

	@FindBy(name = "button")
	private List<WebElement> checkInButton;

	public MainUserOverduePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {

	}
	
	public String getHeaderText() 
	{ 
		return header.getText();
	}
	
	public List<WebElement> getBooks() { 
		List<WebElement> listBooks = books;
		return listBooks;
	}
	
	public void checkInClick() 
	{ 
		List<WebElement> listCheckInButtons = checkInButton;
		listCheckInButtons.get(0).click();
	}
}
