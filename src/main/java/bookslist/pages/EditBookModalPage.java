package bookslist.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bookslist.AbstractPageObject;

public class EditBookModalPage extends AbstractPageObject {
	@FindBy(className = "modal-title")
	private WebElement editBookModalPageHeader;

	public EditBookModalPage(WebDriver driver) {
		super(driver);
	}
	
	public String getEditBookModalPageHeader() {
		return editBookModalPageHeader.getText();
	}
	
}
