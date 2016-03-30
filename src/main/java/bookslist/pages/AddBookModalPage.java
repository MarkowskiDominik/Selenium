package bookslist.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bookslist.AbstractPageObject;

public class AddBookModalPage extends AbstractPageObject {
	@FindBy(className = "modal-title")
	private WebElement addBookModalPageHeader;

	@FindBy(name = "titleInput")
	private WebElement title;
	@FindBy(name = "authorInput")
	private WebElement author;
	@FindBy(name = "yearInput")
	private WebElement year;
	@FindBy(name = "genreInput")
	private WebElement genre;

	@FindBy(name = "save")
	private WebElement saveButton;
	@FindBy(name = "cancel")
	private WebElement cancelButton;

	public AddBookModalPage(WebDriver driver) {
		super(driver);
	}

	public String getAddBookModalPageHeader() {
		return addBookModalPageHeader.getText();
	}

	public WebElement getTitle() {
		return title;
	}

	public AddBookModalPage setTitle(String title) {
		this.title.sendKeys(title);
		return this;
	}
	
	public Boolean isRequiredTitle() {
		return title.getAttribute("outerHTML").contains("required=\"required\"");
	}

	public WebElement getAuthor() {
		return author;
	}

	public AddBookModalPage setAuthor(String author) {
		this.author.sendKeys(author);
		return this;
	}

	public Boolean isRequiredAuthor() {
		return author.getAttribute("outerHTML").contains("required=\"required\"");
	}

	public WebElement getYear() {
		return year;
	}

	public AddBookModalPage setYear(String year) {
		this.year.sendKeys(year);
		return this;
	}

	public WebElement getGenre() {
		return genre;
	}

	public AddBookModalPage setGenre(String genre) {
		this.genre.sendKeys(genre);
		return this;
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
