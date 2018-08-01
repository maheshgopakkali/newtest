package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helper.WaitHelper;

public class AccountPage {
	
	private WebDriver driver;
	private WaitHelper wait;
	
	@FindBy(xpath=".//h1[text()='My account']")
	WebElement myAccountHeader;

	
	public AccountPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
		wait = new WaitHelper(driver);
		wait.waitForVisibilityWithTimeout(myAccountHeader, 15, 1);		
	}

}
