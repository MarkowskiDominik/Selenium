package bookslist.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bookslist.AbstractPageObject;

public class EditBookModalPage extends AbstractPageObject {
	@FindBy(className = "modal-title")
	private WebElement editBookModalPageHeader;

	@FindBy(name = "idInput")
	private WebElement id;
	@FindBy(name = "titleInput")
	private WebElement title;
	@FindBy(name = "authorInput")
	private WebElement author;
	@FindBy(name = "yearInput")
	private WebElement year;
	@FindBy(name = "genreInput")
	private WebElement genre;
	@FindBy(name = "versionInput")
	private WebElement version;

	@FindBy(name = "save")
	private WebElement saveButton;
	@FindBy(name = "cancel")
	private WebElement cancelButton;

	public EditBookModalPage(WebDriver driver) {
		super(driver);
	}

	public String getEditBookModalPageHeader() {
		return editBookModalPageHeader.getText();
	}

	public WebElement getId() {
		return id;
	}

	public WebElement getTitle() {
		return title;
	}

	public EditBookModalPage setTitle(String title) {
		this.title.sendKeys(title);
		return this;
	}

	public WebElement getAuthor() {
		return author;
	}

	public EditBookModalPage setAuthor(String author) {
		this.author.sendKeys(author);
		return this;
	}

	public WebElement getYear() {
		return year;
	}

	public EditBookModalPage setYear(String year) {
		this.year.sendKeys(year);
		return this;
	}

	public WebElement getGenre() {
		return genre;
	}

	public EditBookModalPage setGenre(String genre) {
		this.genre.sendKeys(genre);
		return this;
	}

	public WebElement getVersion() {
		return version;
	}

	public Boolean isDisabledSaveButton() {
		return saveButton.getAttribute("outerHTML").contains("disabled=\"disabled\"");
	}

	public void clickSaveButton() {
		saveButton.click();
	}

	public void clickCancelButton() {
		cancelButton.click();
	}
}
