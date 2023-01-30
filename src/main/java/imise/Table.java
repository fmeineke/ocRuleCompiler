package imise;

import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * Utility class to work with an xls document (currently no used?)
 */
public class Table  {

	/**
	 * Sheet in xls document
	 */
	Sheet sheet;

	/**
	 * Stores columns
	 */
	HashMap<String,Integer> head = new HashMap<String,Integer>();

	/**
	 * Row of sheet
	 */
	Row row;

	/**
	 * Row index
	 */
	int rowIndex;
	
	String getString(int r,String column) {
		if (rowIndex != r) row = sheet.getRow(r);
		Cell cell = row.getCell(head.get(column));
		cell.setCellType(CellType.STRING);
		String s = cell.getStringCellValue().trim();
		return s;
	}
	int getLastRowNum() {
		return sheet.getLastRowNum();
	}
	
	public Table(Workbook wb,String sheetName,int header, Log log) throws Exception {
		sheet = wb.getSheet(sheetName);
		if (sheet == null) log.fatal("no \""+sheetName+"\" sheet");
		Row headerRow = sheet.getRow(header);
		if (headerRow == null) {
			log.fatal("expected Header Row is empty");
		}
		for (int j = 0; j  < headerRow.getLastCellNum(); j++) {
			head.put(headerRow.getCell(j).toString().trim().toUpperCase(),j);
		}
	}
}
