package bookslist;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.opera.core.systems.OperaDriver;

public class WebDriverFactory {
	public static enum browser {
		CHROME, FIREFOX, IE, OPERA
	}

	public static WebDriver getWebDriver(browser browserName) {
		String driversDirPath = "src/main/resources/drivers";
		WebDriver driver;

		switch (browserName) {
		case CHROME:
			System.setProperty("webdriver.chrome.driver", driversDirPath + "\\chromedriver.exe");
			driver = getWebDriver(DesiredCapabilities.chrome());
			break;
		case FIREFOX:
			driver = getWebDriver(DesiredCapabilities.firefox());
			break;
		case IE:
			System.setProperty("webdriver.ie.driver", driversDirPath + "\\IEDriverServer.exe");
			driver = getWebDriver(DesiredCapabilities.internetExplorer());
			break;
		case OPERA:
			driver = getWebDriver(DesiredCapabilities.opera());
			break;
		default:
			System.setProperty("webdriver.chrome.driver", driversDirPath + "\\chromedriver.exe");
			driver = getWebDriver(DesiredCapabilities.chrome());
		}

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		return driver;
	}

	private static WebDriver getWebDriver(Capabilities capabilities) {
		String browserType = capabilities.getBrowserName();
		if (browserType.equals("firefox"))
			return new FirefoxDriver(capabilities);
		if (browserType.startsWith("internet explorer"))
			return new InternetExplorerDriver(capabilities);
		if (browserType.equals("chrome"))
			return new ChromeDriver(capabilities);
		if (browserType.equals("opera"))
			return new OperaDriver(capabilities);
		throw new Error("Unrecognized browser type: " + browserType);
	}
}