package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
features={"@target/rerun.txt"},
glue={"classpath:stepDefinitions","classpath:testbase"},
plugin={"html:target/Cucumber_Failed_Test_Rerun_report.html"}
)
public class FailedTest_Runner extends AbstractTestNGCucumberTests {

}
