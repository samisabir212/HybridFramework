package Utility;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="getDataSuite1") //must define name of dp
	public static Object[][] getDataSuite1(Method m){
		
		System.out.println(m.getName());

		/*
		* passing the excel suite1 file path from constants class
		*
		* */
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);

		/*
		* testcase = m.getname --
		* is getting the name of the method we are passing --
		* the dataprovider to and using it as the testcase name
		* then we pass the testcase name to getData parameter
		* se we can get the testcase name of the suite we are testing.
		* */

		String testcase = m.getName();
		
		return CommonUtils.getData(testcase, excel);

		
		
	}
	
	@DataProvider(name="getDataSuite2")
	public static Object[][] getDataSuite2(Method m){
		
		System.out.println(m.getName());
		ExcelReader excel = new ExcelReader(Constants.SUITE2_XL_PATH);
		
		String testcase = m.getName();
		
		return CommonUtils.getData(testcase, excel);

		
		
	}

}
