package bookslist.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import bookslist.AbstractPageObject;

public class DialogAPage extends AbstractPageObject {
	@FindBy(tagName = "h2")
	private WebElement dialogAHeader;

	@FindBy(xpath = "//*/tbody/tr[1]")
	private WebElement firstRow;
	@FindBy(className = "active")
	private WebElement activeRow;
	@FindBy(xpath = "//*/tbody/tr[last()]")
	private WebElement lastRow;
	@FindBys({
		@FindBy(tagName = "tbody"),
		@FindBy(tagName = "tr")
	})
	private List<WebElement> allRows;

	@FindBy(className = "btn-primary")
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

	public void selectLastRow() {
		lastRow.click();
	}

	public Boolean isSelectedRow() {
		for (WebElement row : allRows) {
			if (row.getAttribute("class").contains("active")) {
				return true;
			}
		}
		return false;
	}

	public WebElement getSelectedRow() {
		return activeRow;
	}
	
	public int getSelectedRowIndex() {
		int index = 0;
		for (WebElement row : allRows) {
			if (row.getAttribute("class").contains("active")) {
				return index;
			}
			index++;
		}
		return index;
	}

	public WebElement getFirstRow() {
		return firstRow;
	}

	public WebElement getLastRow() {
		return lastRow;
	}

	public List<WebElement> getAllRows() {
		return allRows;
	}

	public AddBookModalPage openAddBookModalDialog() {
		addBookButton.click();
		return PageFactory.initElements(driver, AddBookModalPage.class);
	}

	public Boolean isDisabledEditButton() {
		return editBookButton.getAttribute("outerHTML").contains("disabled=\"disabled\"");
	}

	public EditBookModalPage openEditBookModalDialog() {
		editBookButton.click();
		return PageFactory.initElements(driver, EditBookModalPage.class);
	}

	public Boolean isDisabledDeleteButton() {
		return deleteBookButton.getAttribute("outerHTML").contains("disabled=\"disabled\"");
	}

	public DeleteBookModalPage openDeleteBookModalDialog() {
		deleteBookButton.click();
		return PageFactory.initElements(driver, DeleteBookModalPage.class);
	}
}
