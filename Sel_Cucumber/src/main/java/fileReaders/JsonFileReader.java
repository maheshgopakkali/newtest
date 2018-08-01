package fileReaders;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import factory.FileReaderFactory;
import jsonTestData.SearchJsonData;

public class JsonFileReader {
	
	private final String customerFilePath = FileReaderFactory.getInstance().getConfigReader().getsearchJsonData();
	private List<SearchJsonData> searchData;
	
	public JsonFileReader()
	{
		searchData = getSearchData();
	}
	
	
	private List<SearchJsonData> getSearchData()
	{
		BufferedReader bufferedreader = null;
		try {
			bufferedreader = new BufferedReader(new FileReader(new File(customerFilePath)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Gson gson = new Gson();
		SearchJsonData[] searchJsonDatas = gson.fromJson(bufferedreader, SearchJsonData[].class);
		
		return Arrays.asList(searchJsonDatas);
	}
	
	public String getSearchString(String name)
	{
		for (SearchJsonData searchJsonData : searchData)
		{
			if (searchJsonData.name.equals(name))
				{
				return searchJsonData.searchText;
				}
		}
		return null;
	}

}
