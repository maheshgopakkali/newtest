package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import helper.WaitHelper;

public class LoginPage 
{

	private WebDriver driver;
	private WaitHelper wait;
	
	@FindBy(xpath=".//input[@id='email']")
	WebElement email;
	
	@FindBy(xpath=".//input[@id='passwd']")
	WebElement password;

	@FindBy(xpath=".//button[@id='SubmitLogin']")
	WebElement submit;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
		wait = new WaitHelper(driver);
		wait.waitForVisibilityWithTimeout(email, 15, 1);		
	}
	
	
	public void registeredUserLogin(String email,String pwd)
	{
		
		wait.waitForVisibilityWithoutTimeout(this.email,10);
		wait.waitForVisibilityWithoutTimeout(this.password,10);
		
		
		
		this.email.clear();
		this.email.sendKeys(email);
		password.clear();
		password.sendKeys(pwd);
	}
	
	
	public void emailEntry(String email)
	{
		wait.waitForVisibilityWithoutTimeout(this.email,10);
		this.email.clear();
		this.email.sendKeys(email);
	}
	
	public void passwordEntry(String pwd)
	{
		wait.waitForVisibilityWithoutTimeout(this.password,10);
		password.clear();
		password.sendKeys(pwd);
	}
	
	public void clickSubmit()
	{
		wait.waitForVisibilityWithoutTimeout(this.submit,10);
		submit.click();
	}
	}
	

