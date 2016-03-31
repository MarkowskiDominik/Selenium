package bookslist.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bookslist.AbstractPageObject;

public class DeleteBookModalPage extends AbstractPageObject {
	@FindBy(className = "modal-title")
	private WebElement deleteBookModalPageHeader;

	@FindBy(name = "delete")
	private WebElement deleteButton;
	@FindBy(name = "cancel")
	private WebElement cancelButton;

	public DeleteBookModalPage(WebDriver driver) {
		super(driver);
	}

	public String getDeleteBookModalPageHeader() {
		return deleteBookModalPageHeader.getText();
	}

	public void clickDeleteButton() {
		deleteButton.click();
	}

	public void clickCancelButton() {
		cancelButton.click();
	}
}
