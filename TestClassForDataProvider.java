package PratikshaLogicForDataProvider;

import java.io.IOException;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestClassForDataProvider
{
	@Test(dataProvider = "dataProvider")
	public void getdata(String action) throws IOException, InterruptedException
	{		String t []= providedatafromexcel();
		for(String tt:t)
		{
			System.out.println(tt);
		}
		System.out.println("code is successfull run");
//		String[][] verifydata = providedatafromexcel();  //sheet1
//		System.out.println(verifydata.length);  // 6
		System.out.println(" length printed inside Testcase");

//		String readdata = Arrays.toString(verifydata[0]);
//		System.out.println(readdata);
	}
	
	@DataProvider(name = "dataProvider")
	public String[]providedatafromexcel() throws IOException, InterruptedException 
	{
		String path =System.getProperty("user.dir")+"\\ExcelOrganizationData.xlsx";
		//String path ="C:\\Users\\intel\\git\\makemytrip\\ExcelOrganizationData.xlsx";
		String sheetname="DataByPratiksha";
		// NOTE: To come data from fetchdataclass in the form of two dimentional array                  
		 String[]data = GetdataFromExcel.FetchData(path, sheetname); 
		 return data ;
	}
}
