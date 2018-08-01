package helper;

import org.openqa.selenium.WebElement;

public class GenericHelper
{

public boolean isElementDisplayed(WebElement element)
{
if (element == null)
return false;

try
{
element.isDisplayed();
return true;
}
catch (Exception e)
{
return false;
}
}

public String getElementText(WebElement element)
{
if (!isElementDisplayed(element))
return null;

String text = element.getText();
return text;
}


public boolean verifyTextEquals(WebElement element,String expectedText)
{
String text = null;
if ((text = getElementText(element))==null)
return false;

if(text.equalsIgnoreCase(expectedText))
return true;
else 
return false;
}
}

