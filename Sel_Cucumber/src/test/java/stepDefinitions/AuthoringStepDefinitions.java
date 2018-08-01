package stepDefinitions;

import org.apache.log4j.Logger;
import org.testng.Assert;

import contexts.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import exceptions.UserCouldNotLogIn;
import factory.FileReaderFactory;
import factory.PageObjectFactory;
import helper.LoggerHelper;
import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchPage;
import testbase.TestBase;

public class AuthoringStepDefinitions {

	
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
	
	
	/*if the context from one step def file to another remains the same then page object factory would remain the same then the intialized page objects will not be created redundantly*/
	
	
	TestContext context;
	HomePage home;
	LoginPage loginPage;
	AccountPage accountPage;
	PageObjectFactory factory;
	SearchPage searchPage;
	Logger log = LoggerHelper.getLogger(AuthoringStepDefinitions.class);
	
	
	public AuthoringStepDefinitions(TestContext context)
	{
		this.context=context;
		factory = context.getPageObjectFactory();
	}
	
	@Given("^Opne chrome and start app$")
	public void opne_chrome_and_start_app() throws Throwable {

		log.info("^Opne chrome and start app is starting inside AuthoringStepDefinitions $");
		TestBase.driver.get(FileReaderFactory.getInstance().getConfigReader().getUrl());
		
	}
	
	@When("^User clicks on signin button$")
	public void user_clicks_on_signin_button() throws Throwable {
		
		home = factory.getHomePage();
		home.clickOnSignIn();
		loginPage = factory.getLoginPage();
    }

	@Then("^User provides valid \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_provides_valid_and(String arg1, String arg2) throws Throwable {
		
		loginPage.registeredUserLogin(arg1, arg2);
		context.scenarioContext.setContext("user",arg1);
	}

	@Then("^User clicks on submit button$")
	public void user_clicks_on_submit_button() throws Throwable {
		
		loginPage.clickSubmit();
		
		try {
			accountPage = factory.getAccountPage();
		} catch (Exception e) {
			System.out.println("Account page did not get loaded.");
		}
	}

	@Then("^User logged in successfully$")
	public void user_logged_in_successfully() throws Throwable {
		
	   if(accountPage==null)
	   {
		   //Assert.assertTrue(false,"User was not able to login as account page object could not get created.");
		   throw new UserCouldNotLogIn(context.scenarioContext.getContext("user")+" was not able to login as account page object could not get created.");
	   }
	   else if(accountPage!=null)
	   {
		   Assert.assertTrue(true,context.scenarioContext.getContext("user")+" got logged in so passing this step..");
	   }
	}
	
	@Then("^User did not log in successfully$")
	public void user_didnot_log_in_successfully() throws Throwable {
		
		 if(accountPage==null)
		   {
			 Assert.assertTrue(true,context.scenarioContext.getContext("user")+" did not get logged in so passing this step..");
			 //throw new UserCouldNotLogIn("User could not log in");
		   }
		 else if(accountPage!=null)
		 {
			 Assert.assertTrue(false,context.scenarioContext.getContext("user")+" got logged in so failing this step..");
		 }
	}
	
	
	
	@When("^\"([^\"]*)\" enters search text and clicks search button$")
	public void enters_search_text_and_clicks_search_button(String arg1) throws Throwable {

		home = factory.getHomePage();
		String searchString = FileReaderFactory.getInstance().getJsonFileReader().getSearchString(arg1);
		context.scenarioContext.setContext("search",searchString);
		
		home.searchText(searchString);
		try {
			searchPage = factory.getSearchPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Search page did not get loaded successfully...!!!");
		}
		
	}

	@Then("^search results should be displayed correctly$")
	public void search_results_should_be_displayed_correctly() throws Throwable {

		if(searchPage==null)
		   {
			 Assert.assertTrue(false,context.scenarioContext.getContext("search")+" string was not searched");
			 //throw new UserCouldNotLogIn("User could not log in");
		   }
		 else if(searchPage!=null)
		 {
			 Assert.assertTrue(true,context.scenarioContext.getContext("search")+" string was successfully searched");
		 }
	}
	
	
	
	
	@Then("^User provides valid email \"([^\"]*)\"$")
	public void user_provides_valid_email(String arg1) throws Throwable {
           loginPage.emailEntry(arg1);
	}

	@Then("^User provides valid password \"([^\"]*)\"$")
	public void user_provides_valid_password(String arg1) throws Throwable 
	{
          loginPage.passwordEntry(arg1);
	}

}
