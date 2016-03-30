package bookslist.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bookslist.AbstractPageObject;

public class AddBookModalPage extends AbstractPageObject {
	@FindBy(className = "modal-title")
	private WebElement addBookModalPageHeader;

	public AddBookModalPage(WebDriver driver) {
		super(driver);
	}
	
	public String getAddBookModalPageHeader() {
		return addBookModalPageHeader.getText();
	}
	
}
