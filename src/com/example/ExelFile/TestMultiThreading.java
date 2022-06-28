package com.example.ExelFile;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

class ReadXlSheet implements Runnable{

	XSSFSheet sheet = null;
	
	public void setSheet(XSSFSheet sheet) {
		this.sheet = sheet;
	}

	@Override
	public void run() {
		Iterator<Row> itr = sheet.iterator();    
		while (itr.hasNext())                 
		{  
			Row row = itr.next();  
			
			Iterator<Cell> cellIterator = row.cellIterator();   
			while (cellIterator.hasNext())   
			{  
				Cell cell = cellIterator.next();  
				switch (cell.getCellType())               
				{  
				case Cell.CELL_TYPE_STRING:     
					System.out.print(cell.getStringCellValue() + "\t\t\t");  
					break;  
				case Cell.CELL_TYPE_NUMERIC:      
					System.out.print(cell.getNumericCellValue() + "\t\t\t");  
					break;  
				default:  
				}  
			}  
			System.out.println("");  
		}  		
	}

}

public class TestMultiThreading 
{ 
	public static void main(String[] args){  
		try{  
			
			File file = new File("C:\\\\Users\\\\DELL\\\\Desktop\\\\work-sapce\\\\ExelFileRead\\\\src\\\\com\\\\example\\\\ExelFile\\\\Read.xlsx");  
			
			FileInputStream fis = new FileInputStream(file);   

			
			XSSFWorkbook wb = new XSSFWorkbook(fis);   
			XSSFSheet sheet = wb.getSheetAt(0); 
			
			ReadXlSheet readXlSheet = new ReadXlSheet();
			readXlSheet.setSheet(sheet);
			
			Thread t1 = new Thread(readXlSheet);
			t1.start();
			
			
			XSSFSheet sheet1 = wb.getSheetAt(1); 
            
			ReadXlSheet readXlSheet1 = new ReadXlSheet();
			readXlSheet1.setSheet(sheet1);
			
			Thread t2 = new Thread(readXlSheet1);
			t2.start();

		}catch(Exception e){  
			e.printStackTrace();  
		}  
	}  
}
