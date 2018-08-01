package helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerHelper
{
public static Logger log;

public static Logger getLogger(@SuppressWarnings("rawtypes") Class className)
{
if (log==null)
{
try {
	PropertyConfigurator.configure(new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\main\\resources\\log4j.properties")));
} catch (FileNotFoundException e) {
	System.out.println("Logger properties file has some issues...!");
	e.printStackTrace();
}
log = Logger.getLogger(className);
return log;
}
else 
{log = Logger.getLogger(className);
return log;
}
}
}
