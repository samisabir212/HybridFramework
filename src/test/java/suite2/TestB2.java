package suite2;

import java.util.Hashtable;

import org.testng.annotations.Test;

import Utility.CommonUtils;
import Utility.Constants;
import Utility.DataProviders;
import Utility.ExcelReader;

public class TestB2 {

	
	@Test(dataProviderClass=DataProviders.class,dataProvider="getDataSuite2")
	public void testB2(Hashtable<String,String> data){
		
		ExcelReader excel = new ExcelReader(Constants.SUITE2_XL_PATH);
		CommonUtils.checkExecution("Suite2", "TestB2", data.get("RunMode"), excel);
	
		
		
	}
}
