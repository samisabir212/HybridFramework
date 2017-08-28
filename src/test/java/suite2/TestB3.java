package suite2;

import java.util.Hashtable;

import org.testng.annotations.Test;

import Utility.CommonUtils;
import Utility.Constants;
import Utility.DataProviders;
import Utility.ExcelReader;

public class TestB3 {

	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="getDataSuite2")
	public void testB3(Hashtable<String,String> data){
		
		ExcelReader excel = new ExcelReader(Constants.SUITE2_XL_PATH);
		CommonUtils.checkExecution("Suite2", "TestB3", data.get("RunMode"), excel);
	
		
	}
}
