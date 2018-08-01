package factory;

import org.openqa.selenium.WebDriver;

import pageObjects.AccountPage;
import pageObjects.FadedShirtPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchPage;
import pageObjects.Tshirts;

public class PageObjectFactory {
	
	private AccountPage accountpage;
	private FadedShirtPage fsPage;
	private HomePage home;
	private LoginPage login;
	private Tshirts tshirts;
	private WebDriver driver;
	private SearchPage searchPage;
	
	public PageObjectFactory(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public Tshirts getTshirts()
	{
		return (tshirts == null) ? new Tshirts(driver) : tshirts;
	}
	
	
	public LoginPage getLoginPage()
	{
		return (login == null) ? new LoginPage(driver) : login;
	}
	
	
	public HomePage getHomePage()
	{
		return (home == null) ? new HomePage(driver) : home;
	}
	
	
	public AccountPage getAccountPage()
	{
		return (accountpage == null) ? new AccountPage(driver) : accountpage;
	}
	
	public FadedShirtPage getFadedShirtPage()
	{
		return (fsPage == null) ? new FadedShirtPage(driver) : fsPage;
	}
	
	public SearchPage getSearchPage()
	{
		return (searchPage == null) ? new SearchPage(driver) : searchPage;
	}

}
