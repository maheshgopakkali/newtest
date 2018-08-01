package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features= {"."},
		glue= {"classpath:stepDefinitions","classpath:testbase"},
		plugin= {"html:target/cucumber-html-report.html","rerun:target/rerun.txt"},
		tags= {"@approved"},
		monochrome=true
		)
public class AllFeature_Runner extends AbstractTestNGCucumberTests {

}
