package bookslist.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bookslist.AbstractPageObject;

public class DialogAPage extends AbstractPageObject {
	@FindBy(tagName = "h2")
	private WebElement dialogAHeader;
	
	@FindBy(xpath = "//*/tbody/tr[1]")
	private WebElement firstRow;
	@FindBy(className = "active")
	private WebElement activeRow;

	@FindBy(xpath = "//*/tbody/tr[1]/td[1]")
	private WebElement firstTitleFromTable;
	@FindBy(xpath = "//*/tbody/tr[last()]/td[1]")
	private WebElement lastTitleFromTable;
	
	@FindBy(className = "btn-primary")
//	@FindBy(xpath = "/html/body/div[2]/div/section/button[1]")
	private WebElement addBookButton;
	@FindBy(className = "btn-success")
	private WebElement editBookButton;
	@FindBy(className = "btn-danger")
	private WebElement deleteBookButton;

	public DialogAPage(WebDriver driver) {
		super(driver);
	}
	
	public String getDialogAHeader() {
		return dialogAHeader.getText();
	}

	public void selectFirstRow() {
		firstRow.click();
	}

	public WebElement getSelectedRow() {
		return activeRow;
	}

	public String getFirstTitleFromTable() {
		return firstTitleFromTable.getText();
	}

	public String getLastTitleFromTable() {
		return lastTitleFromTable.getText();
	}
	
	public AddBookModalPage openAddBookModalDialog() {
		addBookButton.click();
		return PageFactory.initElements(driver, AddBookModalPage.class);
	}
	
	public EditBookModalPage openEditBookModalDialog() {
		editBookButton.click();
		return PageFactory.initElements(driver, EditBookModalPage.class);
	}
	
	public DeleteBookModalPage openDeleteBookModalDialog() {
		deleteBookButton.click();
		return PageFactory.initElements(driver, DeleteBookModalPage.class);
	}
}
