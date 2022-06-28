package com.example.ExelFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlSXWriterExample {
	
	public static void main(String[] args)   
	{  
		try  
		{  
            XSSFWorkbook wb= new XSSFWorkbook();
			XSSFSheet sheet = wb.createSheet("EmployeeDetail"); 
			
			XSSFRow rowOne = sheet.createRow((short)0); 
			
			rowOne.createCell(0).setCellValue("FirstName"); 
			rowOne.createCell(1).setCellValue("Last Name");  
			rowOne.createCell(2).setCellValue("Phone Number");  
			rowOne.createCell(3).setCellValue("Place");  
			rowOne.createCell(4).setCellValue("State");  
			
			
            XSSFRow rowTwo = sheet.createRow((short)1); 
			
            rowTwo.createCell(0).setCellValue("sonam"); 
            rowTwo.createCell(1).setCellValue("gour");  
            rowTwo.createCell(2).setCellValue("9999944455");  
            rowTwo.createCell(3).setCellValue("Ashoknagar");  
            rowTwo.createCell(4).setCellValue("MP");  
			
			
          XSSFRow rowThree = sheet.createRow((short)2); 
			
          rowThree.createCell(0).setCellValue("Gourav"); 
          rowThree.createCell(1).setCellValue("Rajput");  
          rowThree.createCell(2).setCellValue("8889997788");  
          rowThree.createCell(3).setCellValue("Ashoknagar");  
          rowThree.createCell(4).setCellValue("MP");  
			
          FileOutputStream fis = new FileOutputStream("C:\\\\Users\\\\DELL\\\\Desktop\\\\work-sapce\\\\ExelFileRead\\\\src\\\\com\\\\example\\\\ExelFile\\\\write.xlsx"); 
          wb.write(fis);
          
          System.out.println("Excel file has been generated successfully.");  
			
		}catch(Exception e) {
		 
			e.printStackTrace();  
		}
	}
}


