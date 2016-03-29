package bookslist.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bookslist.AbstractPageObject;

public class DialogBPage extends AbstractPageObject {
	@FindBy(xpath = "//*/div[2]/div/h2")
	private WebElement dialogBHeader;

	public DialogBPage(WebDriver driver) {
		super(driver);
	}
	
	public String getDialogBHeader() {
		return dialogBHeader.getText();
	}
	
}
