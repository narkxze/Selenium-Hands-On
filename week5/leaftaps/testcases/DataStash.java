package week5.leaftaps;

import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataStash {
	static XSSFWorkbook wb;
	static XSSFSheet ws;

	public static String[][] runCreateLead(String workbook, String sheet) throws IOException{
		wb = new XSSFWorkbook("./dataStash/"+workbook+".xlsx");
		String[][] data = new String[3][8];
		 ws = wb.getSheet(sheet);
		int rowCount = ws.getLastRowNum();
		int columnCount = ws.getRow(0).getLastCellNum();
		for(int i = 1; i<=rowCount; i++) {
			for(int j = 0; j<columnCount; j++) {
				String cellValue = ws.getRow(i).getCell(j).getStringCellValue();
				data[i-1][j] = cellValue;
			}
		}
		wb.close();
		return data;
	}
	
	public static String[][] runEditLead(String workbook, String sheet) throws IOException{
		wb = new XSSFWorkbook("./dataStash/"+workbook+".xlsx");
		String[][] data = new String[3][2];
		ws = wb.getSheet(sheet);
		int rowCount = ws.getLastRowNum();
		int columnCount = ws.getRow(0).getLastCellNum();
		for(int i = 1; i<=rowCount; i++) {
			for(int j = 0; j<columnCount; j++) {
				String cellValue = ws.getRow(i).getCell(j).getStringCellValue();
				data[i-1][j] = cellValue;
			}	
		} 
		wb.close();
		return data;	
	}

	public static String[][] runDuplicateLead(String workBook, String sheet) throws IOException {
		wb = new XSSFWorkbook("./dataStash/"+workBook+".xlsx");
		String[][] data = new String[3][1];
		ws = wb.getSheet(sheet);
		int rowCount = ws.getLastRowNum();
		int columnCount = ws.getRow(0).getLastCellNum();
		for(int i = 1; i<=rowCount; i++) {
			for(int j = 0; j<columnCount; j++) {
				String cellValue = ws.getRow(i).getCell(j).getStringCellValue();
				data[i-1][j] = cellValue;
			}	
		} 
		wb.close();
		return data;	
	}

	public static String[][] runMergeLead(String workBook, String sheet) throws IOException {
		wb = new XSSFWorkbook("./dataStash/"+workBook+".xlsx");
		String[][] data = new String[1][2];
		ws = wb.getSheet(sheet);
		int rowCount = ws.getLastRowNum();
		int columnCount = ws.getRow(0).getLastCellNum();
		for(int i = 1; i<=rowCount; i++) {
			for(int j = 0; j<columnCount; j++) {
				String cellValue = ws.getRow(i).getCell(j).getStringCellValue();
				data[i-1][j] = cellValue;
			}	
		} 
		wb.close();
		return data;	
	}

	public static String[][] runDeleteLead(String workBook, String sheet) throws IOException {
		wb = new XSSFWorkbook("./dataStash/"+workBook+".xlsx");
		String[][] data = new String[3][1];
		ws = wb.getSheet(sheet);
		int rowCount = ws.getLastRowNum();
		int columnCount = ws.getRow(0).getLastCellNum();
		for(int i = 1; i<=rowCount; i++) {
			for(int j = 0; j<columnCount; j++) {
				String cellValue = ws.getRow(i).getCell(j).getStringCellValue();
				data[i-1][j] = cellValue;
			}	
		} 
		wb.close();
		return data;	
		
	}
}
