package Commons;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	private String projectFolder = System.getProperty("user.dir");
	private WebDriver driver;
	
	protected WebDriver getBrowserDriver(String browserName) {
		if(browserName.equals("firefox_ui")) {
			System.setProperty("webdriver.gecko.driver", projectFolder + "\\browserDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if(browserName.equals("chrome_ui")) {
			System.setProperty("webdriver.chrome.driver", projectFolder + "\\browserDriver\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();    
			options.setExperimentalOption("useAutomationExtension", false);
			options.setExperimentalOption("excludeSwitches", 
			        Collections.singletonList("enable-automation"));
			driver = new ChromeDriver(options); 
//		} else if (browserName.equals("firefox_headless")) {
//			System.setProperty("webdriver.gecko.driver", projectFolder + "\\browserDriver\\geckodriver.exe");
//			FirefoxOptions firefoxOptions = new FirefoxOptions();
//			firefoxOptions.addArguments("firefox_headless");
//			firefoxOptions.addArguments("window-size=1366x768");
//			driver = new FirefoxDriver(firefoxOptions);
//		} else if (browserName.equals("chrome_headless")) {
//			System.setProperty("webdriver.chrome.driver", projectFolder + "\\browserDriver\\chromedriver.exe");
//			ChromeOptions chromeOptions = new ChromeOptions();
//			chromeOptions.addArguments("headless");
//			chromeOptions.addArguments("window-size=1366x768");
//			driver = new ChromeDriver(chromeOptions);
		} else if (browserName.equals("edge_chromium")) {
			System.setProperty("webdriver.edge.driver", projectFolder + "\\browserDriver\\msedgedriver.exe");
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Please input valid browser name value");
		}
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		
		return driver;
	}

}
