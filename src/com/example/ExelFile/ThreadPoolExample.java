package com.example.ExelFile;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

class ExcelTest  implements Runnable{

	int index;


	public ExcelTest(int index) {
		this.index = index;
	}


	@Override
	public void run() {


		try {

			System.err.println(Thread.currentThread().getName());

			File file = new File("C:\\Users\\DELL\\Desktop\\work-sapce\\ExelFileRead\\src\\com\\example\\ExelFile\\read.xlsx"); 
			FileInputStream fis = new FileInputStream(file); 

			XSSFWorkbook wb=new XSSFWorkbook(file);
			
            XSSFSheet sheet=wb.getSheetAt(index);

			Iterator<Row> rowIterator = sheet.iterator();

			while (rowIterator.hasNext())                 
			{  
				Row row = rowIterator.next();

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
		} catch(Exception e){
			e.printStackTrace(); 

		}

	}
}

public class ThreadPoolExample {

	public static void main(String[] args) {

		ExecutorService  executorService =Executors.newFixedThreadPool(2);

		for(int i=0;i<2;i++) {

			ExcelTest excelTest = new ExcelTest(i);
			executorService.execute(excelTest);
		}

		executorService.shutdown(); 


	}

}


