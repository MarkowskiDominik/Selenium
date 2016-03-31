package bookslist;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import bookslist.pages.WelcomePage;

@RunWith(SeleniumScreenshotJUnit4Runner.class)
public class AbstractSelenium {
	private WebDriver driver;

	@Before
	public void setUp() {
		driver = WebDriverFactory.getWebDriver(WebDriverFactory.browser.CHROME);
	}

	public WelcomePage openBooksList() {
		return PageFactory.initElements(driver, WelcomePage.class);
	}

	public void takeScreenshot() throws IOException {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\tmp\\" + screenshot.getName());
		FileUtils.copyFile(screenshot, destFile);
		System.out.println(String.format("[[ATTACHMENT|%s]]", destFile.getAbsolutePath()));
	}

	@After
	public void thearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
