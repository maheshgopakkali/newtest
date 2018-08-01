package contexts;

import org.apache.log4j.Logger;

import factory.PageObjectFactory;
import helper.LoggerHelper;
import testbase.TestBase;

public class TestContext 
{
	
	private PageObjectFactory factory;
	public ScenarioContext scenarioContext;
	Logger log = LoggerHelper.getLogger(TestContext.class) ;
	
	public TestContext()
	{
		factory = new PageObjectFactory(TestBase.driver);
		scenarioContext = new ScenarioContext();
	}

	public PageObjectFactory getPageObjectFactory()
	{
		log.info("getting the Page object factory from  the test context");
		return factory;
	}
}
