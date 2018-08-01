package contexts;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import helper.LoggerHelper;

public class ScenarioContext {
	
	Logger log = LoggerHelper.getLogger(ScenarioContext.class) ;
	
	private Map<String,String> scenarioContexts;
	
	public ScenarioContext()
	{
		scenarioContexts = new HashMap<String,String>();
	}

	public String getContext(String key)
	{
		return scenarioContexts.get(key);
	}
	
	public void setContext(String key,String value)
	{
		log.info("setting up the scenario context for the key "+key);
		scenarioContexts.put(key, value);
	}
}
