package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Excellabourcat {

	

	@DataProvider(name = "labourcategory")
	public String [][] getData() throws Exception
	{
		//public static void main(String[] args) throws Exception {
		File filepath=new  File(".\\TestData\\Labourcat.xlsx");
		System.out.println(filepath.exists());

		FileInputStream fis=new FileInputStream(filepath);

		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet1");

		//to check how many rows in sheet and how many cell
		//System.out.println(sheet.getPhysicalNumberOfRows());
		System.out.println(sheet.getLastRowNum());
		//store rows in a variable so 
		int noOfRows = sheet.getPhysicalNumberOfRows();
		int noOfClo =sheet.getRow(0).getLastCellNum();

		String [][] data=new String[noOfRows-1][noOfClo];
		for(int i=0; i<noOfRows-1; i++)
		{
			for(int j=0; j<noOfClo; j++)
			{
				//Dataformatter convert all type of data in string
				DataFormatter df=new DataFormatter();

				data[i][j]= df.formatCellValue(sheet.getRow(i+1).getCell(j));
				//System.out.println(df.formatCellValue(sheet.getRow(i).getCell(j)));
				//System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());			
			}
			//this is use for line break
			System.out.println();
		}

		workbook.close();
		fis.close();
		for (String[] dataArr : data) {
			System.out.println(Arrays.toString(dataArr));
		}
		return data;

	}	
}
