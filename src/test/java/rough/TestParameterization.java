package rough;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestParameterization {
	
	
	@Test(dataProvider = "getData")
	public void testData(Hashtable<String,String> data){ //returned data from each set of rows in table

		//to invoke the tables of data use data.get and pass the name of the column.
	System.out.println(data.get("Iteration")+"-------"+data.get("TestData")+"-------"+data.get("Browser")+"-------"+data.get("RunMode"));
		
	}












	@DataProvider //our data provider will be provided to the testData Class
	public static Object[][] getData(){ //form of 2 dimensional array

		ExcelReader excel = new ExcelReader("/Users/sami/Desktop/HybridFrameWork_EXCEL/testdata.xlsx");

		//initialize sheetname and testcase
		String sheetName = "TestData";
		String testCase = "UserRegTest";

		//Test case start from
		int testCaseRowNum=1;
		
		while(!excel.getCellData(sheetName, 0, testCaseRowNum).equalsIgnoreCase(testCase)){
			/*
			* while not (!) testcase string variable doesnt equal the name of the test case
			* increment from row 1 until it equals that name of the test case
			* */
			
			testCaseRowNum++;
		}
		
		System.out.println("Test case starts from : " + testCaseRowNum);
		
		
		//total cols & rows - cols starts and test data starts from
		int colsStartRowNum = testCaseRowNum+1; //testcase start +1 will be the column names where to start to read the columns
		int dataStartRowNum = colsStartRowNum+1; //the data will start a row after the column names +1


		//total cols in test set to 0
		int cols = 0;

		//this is to get and read the columns row names
		while(!excel.getCellData(sheetName, cols, colsStartRowNum).trim().equals("")){

			/*
			* while excel column rows are not "" (empty) move to the next column until it is
			* */
			//making the columns start from 0 to empty
			//the rows of the columns will start at colsStartRowNum which is testCaseRowNum + 1

			cols++; //increment column until empty
			
		}
		
		System.out.println("Total cols in a test are : "+cols);


		//total rows in a test are set to zero
		int rows=0;

		//this is to get the number of rows of test data
		while(!excel.getCellData(sheetName, 0, dataStartRowNum+rows).trim().equals("")){
			//colnum starts at 0 for the test data row of column
			//data should be dataStartRowNum + rows    because we will be incrementing the rows
			//if it doenst equal an empty space then move on to the next row until empty

			//incrementing the rows until empty
			rows++;
			
		}

		System.out.println("Total rows are : "+rows);
		
		//printing the test data
		Object[][] data = new Object[rows][1]; //column will alawys start at 1
		//rows is set at 0 column is set to 1 until their is an empty column where the test stops

		int i = 0; //our counter


		/*
		* for every row we will create a hashtable
		* */
		for(int row = dataStartRowNum; row < dataStartRowNum + rows; row++){


			Hashtable<String, String> table = new Hashtable<String,String>();


			for(int col=0; col<cols; col++){
				
				
				//System.out.println(excel.getCellData(sheetName, col, row));
				//starting testdata below the column row
				String Testdata = excel.getCellData(sheetName, col, row); //stored as the value

				//the row should be where the columns are. starting at the column row
				String colName = excel.getCellData(sheetName, col, colsStartRowNum); //stored as the key



				/*
				* Key and value
				* column name is the key and value is the test data
				* */
				table.put(colName, Testdata);

			}

			/*
			* for each set of data our table will be created
			* then increment until the number of rows are done
			* */
			data[i][0] = table; //creating a table for each row
			i++;



		}
		
		return data;
	}

}
