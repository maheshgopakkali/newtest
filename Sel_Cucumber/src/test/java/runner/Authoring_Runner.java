package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features={"classpath:features/Authoring.feature"},
		glue= {"classpath:stepDefinitions","classpath:testbase"},
        plugin= {"html:target/cucumber-html-report.html"},
        tags= {"~@Valid , ~@Search","@Invalid"})
public class Authoring_Runner extends AbstractTestNGCucumberTests 
{

}
