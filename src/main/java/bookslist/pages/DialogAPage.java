package bookslist.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bookslist.AbstractPageObject;

public class DialogAPage extends AbstractPageObject {
	@FindBy(tagName = "h2")
	private WebElement dialogAHeader;
	@FindBy(xpath = "//*/tr[1]/td[1]")
	private WebElement firstTitleFromTable;
	@FindBy(xpath = "//*/tr[last()]/td[1]")
	private WebElement lastTitleFromTable;

	public DialogAPage(WebDriver driver) {
		super(driver);
	}
	
	public String getDialogAHeader() {
		return dialogAHeader.getText();
	}

	public String getFirstTitleFromTable() {
		return firstTitleFromTable.getText();
	}

	public Object getLastTitleFromTable() {
		return lastTitleFromTable.getText();
	}
	
}
