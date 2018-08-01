package stepDefinitions;

import org.testng.Assert;

import contexts.TestContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import factory.PageObjectFactory;
import pageObjects.FadedShirtPage;
import pageObjects.HomePage;
import pageObjects.Tshirts;

public class ICStepDefinitions {
	
	
	/*Step difinitions can be created in multiple classes within the step definitions package for one feature file and it will still read the data as we just mention
	the package name for step definitions in runner.
	But, as we have created a pageObjectFactory, we are trying to minimize the number of times same object gets created.
	Thats the reason we will go ahead with one step definition class  for one feature file from now onwards.
	If one definition is in another class then we would have to create pageObjectFactory class again and some other page objects as well,
	which is redundant object creation, Hence its ideal to use one step definitions class for one feature file.*/
	
	/*Then again we can say keep all the methods and page objects as static , but that is not a good way to keep so many things static in java programmes.
	Keeping static approach was failure coz our driver quits after every run and hence our static POF instance becomes useless.*/
	
	
	/*After reading more, it is understood that in a bigger project you cant have one step definition file for all the scenarios of a feature.
	Due to the above issue now you are  forced to create new Page Factory obbject again and again if the step definitions are distributed.
	This issue well now be handle by the test context constructor added below.
	This is called test conext sharing between various step definitions.
	It uses dependency injection by pico-container.
	Now during the run of a scenario if a different step definitions file is referred than test context sharing will make sure there is no object duplicacy.*/
	
	
	
	
	
	
	TestContext context;
	HomePage home;
	Tshirts tshirts;
	FadedShirtPage fadedShirtPage;
	PageObjectFactory factory;
	
	
	public ICStepDefinitions(TestContext context)
	{
		this.context=context;
		factory = context.getPageObjectFactory();
	}
	
	@When("^User clicks on Tshirt tab$")
	public void user_clicks_on_Tshirt_tab() throws Throwable 
	{
		home = factory.getHomePage();
		home.clickOnTshirts();
		try
		{
			tshirts = factory.getTshirts();
		}
		catch(Exception e)
		{
		System.out.println("tshirts page did not get loaded successfully");
		}
	}

	@Then("^Tshirt tab successfully opens$")
	public void tshirt_tab_successfully_opens() throws Throwable 
	{

		if(tshirts==null)
		{
			Assert.assertTrue(false,"Tshirts tab could not be loaded successfully hence failing");
		}
		else
		{
			System.out.println("Tshirts tab loaded successfully!");
		}
		
	}

	@Then("^User clicks on available item$")
	public void user_clicks_on_available_item() throws Throwable 
	{

		tshirts.clickOnImage();
		try 
		{
			fadedShirtPage = factory.getFadedShirtPage();
		} catch (Exception e) {
			System.out.println("fadedShirtPage tab did not loaded successfully!");
		}
	}

	
	@Then("^fadedShirtPage tab successfully opens$")
	public void fadedShirtPage_tab_successfully_opens() throws Throwable 
	{
		Thread.sleep(3000);

		if(fadedShirtPage==null)
		{
			Assert.assertTrue(false,"fadedShirtPage tab could not be loaded successfully hence failing");
		}
		else
		{
			System.out.println("fadedShirtPage tab loaded successfully!");
		}
		
	}
	
	@Then("^User selects size of the item$")
	public void user_selects_size_of_the_item() throws Throwable {

		fadedShirtPage.selectSize();
	}

	@Then("^User click on addToCart$")
	public void user_click_on_addToCart() throws Throwable 
	{
		fadedShirtPage.clickOnAddToCart();
	}

}
