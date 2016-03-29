package ldrygala.petclinic.pages;

import ldrygala.petclinic.AbstractPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractPageObject{
	@FindBy(linkText="Find owners")
	private WebElement findOwner;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver.get("http://demo-spring-petclinic.cfapps.io/");
	}
	
	public FindOwnersPage clickFindOwner() {
		findOwner.click();
		return PageFactory.initElements(driver, FindOwnersPage.class);
	}
	
}
