package bookslist.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bookslist.AbstractPageObject;

public class WelcomePage extends AbstractPageObject {
	@FindBy(linkText = "dialog A")
	private WebElement linkDialogA;
	@FindBy(linkText = "dialog B")
	private WebElement linkDialogB;
	@FindBy(linkText = "Dialog A")
	private WebElement navbarDialogA;
	@FindBy(linkText = "Dialog B")
	private WebElement navbarDialogB;

	public WelcomePage(WebDriver driver) {
		super(driver);
		this.driver.get("http://localhost:9000/#/main/welcome");
	}

	public DialogAPage clickLinkDialogA() {
		linkDialogA.click();
		return PageFactory.initElements(driver, DialogAPage.class);
	}

	public DialogBPage clickLinkDialogB() {
		linkDialogB.click();
		return PageFactory.initElements(driver, DialogBPage.class);
	}

	public DialogAPage clickNavbarDialogA() {
		navbarDialogA.click();
		return PageFactory.initElements(driver, DialogAPage.class);
	}

	public DialogBPage clickNavbarDialogB() {
		navbarDialogB.click();
		return PageFactory.initElements(driver, DialogBPage.class);
	}
}
