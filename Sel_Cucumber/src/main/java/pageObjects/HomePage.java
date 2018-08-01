package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helper.WaitHelper;

public class HomePage 
{
	
	private WebDriver driver;
	private WaitHelper wait;
	
	@FindBy(xpath=".//a[@title='Log in to your customer account']")
	WebElement signin;
	
	@FindBy(xpath=".//a[@title='Women'][text()='Women']")
	WebElement woman;


	@FindBy(xpath=".//a[@title='T-shirts'][text()='T-shirts']/following::a[@title='T-shirts'][text()='T-shirts']//preceding::a[@title='T-shirts'][text()='T-shirts']")
    WebElement tshirts;
	
	@FindBy(xpath=".//input[@id='search_query_top']")
	WebElement searchBar;
	
	@FindBy(xpath=".//input[@id='search_query_top']/following::button[1]")
	WebElement searchButton;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
		wait = new WaitHelper(driver);
		wait.waitForVisibilityWithTimeout(signin, 15, 1);		
	}
	
	public void clickOnSignIn()
	{
	wait.waitForClickabilityWithoutTimeout(signin, 10);
	signin.click();
	}
	
	public void clickOnTshirts()
	{
	Actions act = new Actions(driver);
	act.moveToElement(woman).build().perform();
	wait.waitForVisibilityWithoutTimeout(tshirts, 5);
	tshirts.click();
	}
	
	public void searchText(String searchText)
	{
		wait.waitForVisibilityWithoutTimeout(searchBar, 5);
		searchBar.sendKeys(searchText);
		searchButton.click();
	}
	
	}

