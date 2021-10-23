package utils;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel  {
	
	static XSSFWorkbook wb;
	static XSSFSheet ws;
	public static String[][] runReadExcel(String workBook, String sheetName) throws IOException {
		wb = new XSSFWorkbook("C:\\Users\\nares\\eclipse-workspace\\ServiceNow-POM\\src\\test\\data\\"+workBook+".xlsx");
		ws = wb.getSheet(sheetName);
		int rowCount = ws.getLastRowNum();
		int columnCount = ws.getRow(0).getLastCellNum();
		String[][] data = new String[rowCount][columnCount]; 
		for(int i =1; i<=rowCount; i++) {
			for(int j =0; j<columnCount; j++) {
				String cellValue = ws.getRow(i).getCell(j).getStringCellValue();
				data[i-1][j] = cellValue;
			}
		}
		wb.close();
		return data;
		
		
	}
}
