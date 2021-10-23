package utils;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcel {
	static XSSFWorkbook wb;
	static XSSFSheet ws;
	public static String[][] excelData(String workbook, String sheet) throws IOException{
		wb = new XSSFWorkbook("./data/"+workbook+".xlsx");
		/* String[][] data = new String[3][8]; */
		 ws = wb.getSheet(sheet);
		int rowCount = ws.getLastRowNum();
		int columnCount = ws.getRow(0).getLastCellNum();
		String[][] data = new String[rowCount][columnCount];
		for(int i = 1; i<=rowCount; i++) {
			for(int j = 0; j<columnCount; j++) {
				String cellValue = ws.getRow(i).getCell(j).getStringCellValue();
				data[i-1][j] = cellValue;
			}
		}
		wb.close();
		return data;
		/*
		 * //3. Get into the row XSSFRow row = ws.getRow(i); 
		 * //4. Get into cell XSSFCell
		 * cell = row.getCell(1);
		 *  //5. To read the data 
		 *  String stringCellValue =
		 * cell.getStringCellValue();
		 */
		//System.out.println(stringCellValue);
		}
		//6. Close the workbook

	}

