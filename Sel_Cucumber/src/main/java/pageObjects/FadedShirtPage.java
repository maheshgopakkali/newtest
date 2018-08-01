package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helper.DropDownHelper;
import helper.WaitHelper;

public class FadedShirtPage {
	
	
	private WebDriver driver;
	private WaitHelper wait;
	
	@FindBy(xpath=".//h1[text()='Faded Short Sleeve T-shirts']")
	WebElement titleText;
	

	@FindBy(xpath=".//select[@id='group_1']")
	WebElement sizeDropdown;
	
	@FindBy(xpath=".//span[text()='Add to cart']")
	WebElement addToCart;
	
	public FadedShirtPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
		wait = new WaitHelper(driver);
		wait.waitForVisibilityWithoutTimeout(titleText, 15);		
	}
	
	public void selectSize()
	{
		wait.waitForVisibilityWithoutTimeout(sizeDropdown, 5);
		new DropDownHelper().selectOptionByVisibleText(sizeDropdown, "M");
	}
	
	public void clickOnAddToCart()
	{
		wait.waitForVisibilityWithoutTimeout(addToCart, 5);
		addToCart.click();
		
	}
	
	
	

}
