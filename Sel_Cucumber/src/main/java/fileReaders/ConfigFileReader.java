package fileReaders;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import browsers.BrowserType;

public class ConfigFileReader {
	
	private Properties prop;
	
	public ConfigFileReader() throws IOException
	{
		prop = new Properties();
		try {
			prop.load(new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\main\\resources\\Config.properties")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public String getUrl()
	{
		return prop.getProperty("url");
	}
	
	public BrowserType getBrowser()
	{
		return BrowserType.valueOf(prop.getProperty("browser"));
	}
	
	public int getImplicitWait()
	{
		return Integer.parseInt(prop.getProperty("implicitWait"));
	}

	public int getExplicitWait()
	{
		return Integer.parseInt(prop.getProperty("explicitWait"));
	}
	
	public int getPageLoadTimeout()
	{
		return Integer.parseInt(prop.getProperty("pageLoadTimeout"));
	}
	
	public String getsearchJsonData()
	{
		return prop.getProperty("searchJsonData");
	}
}
