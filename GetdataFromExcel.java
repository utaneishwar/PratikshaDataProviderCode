package PratikshaLogicForDataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetdataFromExcel
{
	// excelpath    //Sheet1
	public static String[] FetchData(String path, String sheetname) throws IOException, InterruptedException
	{ 
		//  { {Kishor@gmail.com, Kishor@123},{Ishwar@gmail.com,ishwar@123},{nilesh@gmail.com, nilesh@123}};

		File file = new File(path);
		FileInputStream fis =new FileInputStream(file);
		XSSFWorkbook wb =new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet(sheetname); //"DataByPratiksha"

		int rowcount = sheet.getLastRowNum()+1;                	// 6
		int columncount = sheet.getRow(0).getLastCellNum();  	// 7
		System.out.println(rowcount);     						// 6
		System.out.println(columncount);  						// 7
		System.out.println("row and column count printed");
	//	Object [][]data=new Object[rowcount][columncount];   //[][]
		
		
		String []data=new String[rowcount];  // 
	//	First Name Last Name Age Email Salary Department Action,Cierra Vega 39 cierra@example.com 10000 Insurance delete 
		//          00             01      10                11         20                21 
		//  { {Kishor@gmail.com, Kishor@123, Age, email, Action},{Ishwar@gmail.com,ishwar@123},{nilesh@gmail.com, nilesh@123}};
         // It Read all kind of data  from excel
		DataFormatter df =new DataFormatter();
		for(int i=0; i<rowcount; i++)
		{                   
			for(int j=0; j<columncount; j++)
			{
				// 1          //0
				data[i]=df.formatCellValue(sheet.getRow(i).getCell(j)); //Vega
				//data1[i-1][j]= sheet.getRow(i).getCell(j).getStringCellValue();
			    //System.out.print(data[i]+" ");	
			}
			//System.out.println();
		}
		
		return data;  // we get data from excel in the form of two dimensional array.

	}
}
