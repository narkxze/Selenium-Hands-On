package servicenow;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataStash {
static XSSFWorkbook wb;
static XSSFSheet ws;
	public static String[][] readData(String workBook, String sheetName) throws IOException {
		 wb = new XSSFWorkbook("./dataStash/"+workBook+".xlsx");
		String[][] data = new String[3][6];
		 ws = wb.getSheet(sheetName);
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
	
	public static String[][] updateData(String workBook, String sheetName) throws IOException{
		String data[][] = new String[1][4];
		wb = new XSSFWorkbook("./dataStash/"+workBook+".xlsx");
		ws = wb.getSheet(sheetName);
		int rowCount = ws.getLastRowNum();
		int columnCount = ws.getRow(0).getLastCellNum();
		for(int i =1;i<=rowCount;i++) {
			for(int j = 0; j<columnCount;j++) {
				String cellValue = ws.getRow(i).getCell(j).getStringCellValue();
				data[i-1][j] = cellValue;
			}
		}
		wb.close();
		return data;
	}
	
	public static String[][] assignData(String workBook, String sheetName) throws IOException{
		String data[][] = new String[1][2];
		wb = new XSSFWorkbook("./dataStash/"+workBook+".xlsx");
		ws = wb.getSheet(sheetName);
		int rowCount = ws.getLastRowNum();
		int columnCount = ws.getRow(0).getLastCellNum();
		for(int i =1;i<=rowCount;i++) {
			for(int j = 0; j<columnCount;j++) {
				String cellValue = ws.getRow(i).getCell(j).getStringCellValue();
				data[i-1][j] = cellValue;
			}
		}
		wb.close();
		return data;
	}

}
