package ldrygala.petclinic.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ldrygala.petclinic.AbstractPageObject;

public class OwnerInfomrationPage extends AbstractPageObject {
	@FindBy(linkText = "Edit Owner")
	private WebElement editOwner;
	@FindBy(linkText = "Add New Pet")
	private WebElement addNewPet;

	public OwnerInfomrationPage(WebDriver driver) {
		super(driver);
	}
	
	public NewPetPage clickAddNewPet() {
		addNewPet.click();
		return PageFactory.initElements(driver, NewPetPage.class);
	}

}
