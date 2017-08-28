package rough;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestParameterization {
	
	
	@Test(dataProvider="getData")
	public void testData(Hashtable<String,String> data){
		
	System.out.println(data.get("Iteration")+"-------"+data.get("TestData")+"-------"+data.get("Browser")+"-------"+data.get("RunMode"));
		
	}
	
	@DataProvider
	public static Object[][] getData(){
		
	ExcelReader excel = new ExcelReader("C:\\Users\\Selenium\\Desktop\\hybridframework\\testdata.xlsx");
		
		String sheetName = "TestData";
		String testCase = "UserRegTest";
		//Test case start from
		
		int testCaseRowNum=1;
		
		while(!excel.getCellData(sheetName, 0, testCaseRowNum).equalsIgnoreCase(testCase)){
			
			
			testCaseRowNum++;
		}
		
		System.out.println("Test case starts from : "+testCaseRowNum);
		
		
		//total cols & rows - cols starts and test data starts from
		
		
		int colsStartRowNum=testCaseRowNum+1;
		int dataStartRowNum=colsStartRowNum+1;
		
		
		//total cols in test are
		
		int cols=0;
		
		while(!excel.getCellData(sheetName, cols, colsStartRowNum).trim().equals("")){
			
			cols++;
			
		}
		
		System.out.println("Total cols in a test are : "+cols);
		
		
		//total rows in a test are
		
		int rows=0;
		
		while(!excel.getCellData(sheetName, 0, dataStartRowNum+rows).trim().equals("")){
			
			rows++;
			
		}

		System.out.println("Total rows are : "+rows);
		
		//printing the test data
		Object[][] data = new Object[rows][1];
		int i=0;
		for(int row=dataStartRowNum; row<dataStartRowNum+rows;row++){
			Hashtable<String, String> table =new Hashtable<String,String>();
			for(int col=0;col<cols;col++){
				
				
				//System.out.println(excel.getCellData(sheetName, col, row));
				String Testdata = excel.getCellData(sheetName, col, row);
				String colName = excel.getCellData(sheetName, col, colsStartRowNum);
				table.put(colName, Testdata);
			
			
			}
			
			data[i][0] = table;
			i++;
		}
		
		return data;
	}

}
