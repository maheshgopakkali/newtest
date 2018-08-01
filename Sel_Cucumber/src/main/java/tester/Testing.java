package tester;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import helper.JavaScriptHelper;

public class Testing {
	
	
	public static void main(String[] args)
	{
        /*System.setProperty("webdriver.gecko.driver","geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://automationpractice.com/index.php");
		
		
		
		WebElement findElement = driver.findElement(By.xpath(".//a[@title='Women'][text()='Women']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(findElement).build().perform();
		
		driver.findElement(By.xpath(".//a[@title='T-shirts'][text()='T-shirts']/following::a[@title='T-shirts'][text()='T-shirts']//preceding::a[@title='T-shirts'][text()='T-shirts']")).click();
		
		new JavaScriptHelper(driver).scrollToElement(driver.findElement(By.xpath(".//a[@title='Faded Short Sleeve T-shirts']")));
		
		
		driver.findElement(By.xpath(".//a[@title='Faded Short Sleeve T-shirts']")).click();
		
		WebElement findElement2 = driver.findElement(By.xpath(".//h1[text()='Faded Short Sleeve T-shirts']"));
		System.out.println(findElement2.getText());
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		driver.quit();
		
		*/
		
		String methodName = "scenario2";
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		
		String target = System.getProperty("user.dir")+"\\src\\main\\java\\screenshots\\"+methodName+"\\"+methodName+"_"+sdf.format(cal.getTime())+".png";
		System.out.println(target);
		
	}

}
