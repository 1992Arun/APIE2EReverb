package org.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public static XSSFSheet sheet;
	
	
	public static String[][] reader(String filepath, String sheetName)  {
		

		
		
		try {
			
			FileInputStream fi = new FileInputStream(filepath);
			XSSFWorkbook wb = new XSSFWorkbook(fi);
			
			 sheet = wb.getSheet(sheetName);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 XSSFRow row = sheet.getRow(0);
		 
		 int rowNum = sheet.getPhysicalNumberOfRows();
		 
	 int celln = row.getLastCellNum();
		
		
		String[][] data= new String[rowNum-1][celln];
		
	//	List<String[]> data = new ArrayList();
		
		for(int i=1; i<=data.length;i++) {

				data[i-1][0] = cell(i,0);
				data[i-1][1] = cell(i,1);
				data[i-1][2] = cell(i,2);
				data[i-1][3] = cell(i,3);
				data[i-1][4] = cell(i,4);	
				
		       if(sheetName.equals("PUT")) continue;	
		       
				data[i-1][5] = cell(i,5);
				data[i-1][6] = cell(i,6);
	 
				
			}
		return data ;
			

		
		}
		
		
	public static String cell(int row, int column) {
		
		String value;
		
		XSSFRow row2 = sheet.getRow(row);
		
		 XSSFCell cell = row2.getCell(column);
		
		int cellType = cell.getCellType();
		
		if(cellType==1) {
			
			value = cell.getStringCellValue();
			
		} else if(DateUtil.isCellDateFormatted(cell)) {
			
			
			Date dateCellValue = cell.getDateCellValue();
			
			SimpleDateFormat d = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
			
			         value=d.format(dateCellValue);
		
		}else  {
		
		
			double num = cell.getNumericCellValue();
			
			long l = (long)num;
			
			value=String.valueOf(l);
			
		
	}
		return value;
	

	}
	
//	
//	public static void main(String[] args) {
//		
//		String[][] reader = reader(System.getProperty("user.dir") + "\\src\\test\\resources\\NewFile.xlsx",
//				"PUT");
//		
//		for(int i=0; i<reader.length;i++) {
//			
//			String updatedtitle = reader[i][0];
//
//			String updateddescription = reader[i][1];
//
//			String updatedamount = reader[i][2];
//
//			String currency = reader[i][3];
//
//			String uuid = reader[i][4];
//			
//			System.out.println(updatedtitle);
//
//		}
//		
//	}
	
	
	
}

