package helper;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import browsers.ChromeBrowser;

public class WaitHelper 
{
	
		
		
	

	private WebDriver driver;

	public WaitHelper(WebDriver driver)
	{
	this.driver = driver;
	}

	public void setImplicitWait(int time)
	{
	driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);
	}

	public void setPageLoadTimeout(int time)
	{
	driver.manage().timeouts().pageLoadTimeout(time,TimeUnit.SECONDS);
	}

	public WebDriverWait getWaitWithoutPolling(int time)
	{
	WebDriverWait wait = new WebDriverWait(driver,time);
	return wait;
	}

	public WebDriverWait getWaitWithPolling(int time, int pollingTime)
	{
	WebDriverWait wait = new WebDriverWait(driver,time);
	wait.pollingEvery(pollingTime,TimeUnit.SECONDS);
	wait.ignoring(NoSuchElementException.class);
	wait.ignoring(ElementNotVisibleException.class);
	wait.ignoring(StaleElementReferenceException.class);
	wait.ignoring(NoSuchFrameException.class);
	return wait;
	}

	public void waitForVisibilityWithoutTimeout(WebElement element,int time)
	{
	WebDriverWait wait = getWaitWithoutPolling(time);
	wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForVisibilityWithTimeout(WebElement element,int time,int pollingTime)
	{
	WebDriverWait wait = getWaitWithPolling(time,pollingTime);
	wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForTitleIs(int time, String text)
	{
	WebDriverWait wait = getWaitWithoutPolling(time);
	wait.until(ExpectedConditions.titleIs(text));
	}

	public void waitForClickabilityWithoutTimeout(WebElement element,int time)
	{
	WebDriverWait wait = getWaitWithoutPolling(time);
	wait.until(ExpectedConditions.elementToBeClickable(element));
	}


	public void waitForTextPresenceWithoutTimeout(WebElement element,int time,String text)
	{
	WebDriverWait wait = getWaitWithoutPolling(time);
	wait.until(ExpectedConditions.textToBePresentInElement(element,text));
	}
	
	
private void until(WebDriver driver, Function<WebDriver, Boolean> waitCondition, Long timeoutInSeconds){
		WebDriverWait webDriverWait = new WebDriverWait(driver, timeoutInSeconds);
		webDriverWait.withTimeout(timeoutInSeconds, TimeUnit.SECONDS);
		try{
			webDriverWait.until(waitCondition);
		}catch (Exception e){
			System.out.println(e.getMessage());
		}          
	}


public void untilJqueryIsDone(Long timeoutInSeconds)

   {
		until(driver, (d) ->
			{
			Boolean isJqueryCallDone = (Boolean)((JavascriptExecutor) driver).executeScript("return jQuery.active==0");
			if (!isJqueryCallDone) System.out.println("JQuery call is in Progress");
			return isJqueryCallDone;
			}, timeoutInSeconds);
	}
	
	
public void untilPageLoadComplete(Long timeoutInSeconds){
		until(driver, (d) ->
			{
				Boolean isPageLoaded = (Boolean)((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
				if (!isPageLoaded) System.out.println("Document is loading");
				return isPageLoaded;
			}, timeoutInSeconds);
	}
	
}
