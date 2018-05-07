package by.htp.test.driver;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverSingleton {

	private static WebDriver driver;
    private static final Logger logger = LogManager.getRootLogger();
    private static final String DRIVER = "webdriver.chrome.driver";
    private static final String DRIVER_EXE_PATH = "D:\\Projects\\Java\\chromedriver.exe";

    private DriverSingleton(){
    	
    }; 
 
    public static WebDriver getDriver(){
        if (null == driver){
            System.setProperty(DRIVER, DRIVER_EXE_PATH);
            driver = new ChromeDriver();
            driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            logger.info("Browser started");
        }
        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }
}