package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helper.WaitHelper;

public class SearchPage 
{

	private WebDriver driver;
	
	@FindBy(xpath=".//div[@id='center_column']//p")
	WebElement searchText;
	
	public SearchPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
		WaitHelper wait = new WaitHelper(driver);
		wait.waitForVisibilityWithoutTimeout(searchText, 10);
	}
	
	
}
