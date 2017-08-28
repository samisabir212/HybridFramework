package suite1;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.CommonUtils;
import Utility.Constants;
import Utility.DataProviders;
import Utility.ExcelReader;

public class TestA2 {

	@Test(dataProviderClass=DataProviders.class,dataProvider="getDataSuite1")
	public void testA2(Hashtable<String,String> data){
		
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		CommonUtils.checkExecution("Suite1", "TestA2", data.get("RunMode"), excel);
	
		
	}

}
