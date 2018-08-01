package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helper.JavaScriptHelper;
import helper.WaitHelper;

public class Tshirts
{

private WebDriver driver;
private WaitHelper wait;

@FindBy(xpath=".//div[@id='center_column']//span[@class='cat-name']")
WebElement title;

@FindBy(xpath=".//a[@title='Faded Short Sleeve T-shirts']")
WebElement tshirtImage;


public Tshirts(WebDriver driver)
{
this.driver = driver;
PageFactory.initElements(driver,this);
wait = new WaitHelper(driver);
wait.waitForVisibilityWithoutTimeout(title, 10);
}

public void clickOnImage()
{
	new JavaScriptHelper(driver).scrollIntoView(tshirtImage);
	tshirtImage.click();
}

}