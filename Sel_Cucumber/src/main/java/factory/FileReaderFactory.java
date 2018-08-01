package factory;

import java.io.IOException;

import fileReaders.ConfigFileReader;
import fileReaders.JsonFileReader;
import fileReaders.XmlFileReader;

public class FileReaderFactory 
{
	private static FileReaderFactory readerFactory;
	private static ConfigFileReader configReader;
	private static XmlFileReader xmlReader;
	private static JsonFileReader jsonReader;

	private FileReaderFactory()
	{

	}

	public static FileReaderFactory getInstance()
	{
		if (readerFactory==null)
		{
			readerFactory = new FileReaderFactory();
			return readerFactory;
		}

		else 
			return readerFactory;
	}

	public ConfigFileReader getConfigReader() throws IOException
	{
		//return 	(configReader == null) ? new ConfigFileReader() : configReader;

		if(configReader==null) {
			configReader=new ConfigFileReader();
			return configReader;
		}
		else{
			return configReader;
		}

	}


	public XmlFileReader getXmlFileReader()
	{
		return 	(xmlReader == null) ? new XmlFileReader() : xmlReader;
	}

	public JsonFileReader getJsonFileReader()
	{
		return 	(jsonReader == null) ? new JsonFileReader() : jsonReader;
	}
}
