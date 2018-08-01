package testbase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

import browsers.BrowserType;
import browsers.ChromeBrowser;
import browsers.FirefoxBrowser;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import factory.FileReaderFactory;

public class TestBase 
{

	public static WebDriver driver;
	
	public WebDriver getBrowser(BrowserType btype)
	{
		switch(btype)
		{
		case Chrome:
			return new ChromeBrowser().getChromeDriver();
		case Firefox:
			return new FirefoxBrowser().getFirefoxBrowser();
		default:
				return null;
		}
		
	}
	
	public void setupBrowser(BrowserType btype) throws IOException
	{
		driver = getBrowser(btype);
		driver.manage().timeouts().implicitlyWait(FileReaderFactory.getInstance().getConfigReader().getImplicitWait(),TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(FileReaderFactory.getInstance().getConfigReader().getPageLoadTimeout(),TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public void getScreenCapture(String methodName)
	{
		File file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\screenshots\\"+methodName);

		if(!file.exists())
			file.mkdir();
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		
		String target = System.getProperty("user.dir")+"\\src\\main\\java\\screenshots\\"+methodName+"\\"+methodName+"_"+sdf.format(cal.getTime())+".png";
		
		try {
			Files.copy(source,new File(target));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void getResult(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			getScreenCapture(scenario.getName());
		}
		
	}
	
	
	@Before
	public void before() throws IOException
	{
		setupBrowser(FileReaderFactory.getInstance().getConfigReader().getBrowser());
	}
	
	@After
	public void after(Scenario scenario)
	{
		getResult(scenario);
    	driver.quit();
	}
	
	
}
