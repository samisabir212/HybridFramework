package rough;

public class TestData {




	public static void main(String[] args) {


		ExcelReader excel = new ExcelReader("/Users/sami/Desktop/HybridFrameWork_EXCEL/testdata.xlsx");


		//initialize sheetname and testcase
		String sheetName = "TestData";
		String testCase = "LoginTest"; //updatable testcases


		//Test case start from
		int testCaseRowNum=1;


		while(!excel.getCellData(sheetName, 0, testCaseRowNum).equalsIgnoreCase(testCase)){
			/*
			* while not (!) testcase string variable doesnt equal the name of the test case
			* increment from row 1 until it equals that name of the test case
			* */
			
			testCaseRowNum++;
		}
		
		System.out.println("Test case starts from : "+testCaseRowNum);
		
		
		//total cols & rows - cols starts and test data starts from
		int colsStartRowNum = testCaseRowNum+1; //testcase start +1 will be the column names where to start to read the columns
		int dataStartRowNum = colsStartRowNum+1; //the data will start a row after the column names +1
		
		
		//total cols in test set to 0
		int cols = 0;

		//this is to get and read the columns row names
		while(!excel.getCellData(sheetName, cols, colsStartRowNum).trim().equals("")){
			//making the columns start from 0
			//the rows of the columns will start at colsStartRowNum which is testCaseRowNum + 1

			cols++;
			
		}
		
		System.out.println("Total cols in a test are : "+cols);
		
		
		//total rows in a test are set to zero
		int rows = 0;

		//this is to get the number of rows of test data
		while(!excel.getCellData(sheetName, 0, dataStartRowNum+rows).trim().equals("")){
			//colnum starts at 0 for the test data row of column
			//data should be dataStartRowNum + rows    because we will be incrementing the rows
			//trim.equeal... if it doenst equal an empty space then move on to the next row

			//incrementing the rows
			rows++;
			
		}


		System.out.println("Total rows are : "+rows);



		//printing the test data
		for(int row = dataStartRowNum; row<dataStartRowNum+rows;row++){
			
			for(int col=0;col<cols;col++){
				
				
				System.out.println(excel.getCellData(sheetName, col, row));
				
			}
			
			
		}
		
		
	}

}
