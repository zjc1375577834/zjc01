package springboot.testng.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelExportUtil {
	private Workbook workbook ;
	private String fileName;
	private Sheet sheet ;
	private Row row;
	private int rowNum = 0;
	private int cellNum = 0;

	
	public ExcelExportUtil(String file) {
		this.fileName = file;
		boolean contains = file.contains(".xls");
		if (!contains) {
			workbook = new HSSFWorkbook();
		}else {
			workbook = new XSSFWorkbook();
		}
	}
	public Sheet createSheet(String sheetName) {
		Sheet sheet1 = workbook.createSheet(sheetName);
		this.sheet = sheet1;
		Row createRow = sheet.createRow(0);
		this.row = createRow;
		rowNum++;
		
		return sheet1;
	}
	
	public Row createRow(int rows) {
		Row row = sheet.createRow(rows);
		return row;
	}
	public void write(String  value) {
		
		this.row.createCell(cellNum).setCellValue(value);
		cellNum++;
	}
	public void writeNextLine(String value) {
	   this.cellNum = 0;
	   Row row2 = this.sheet.createRow(rowNum);
	   rowNum++;
	   this.row = row2;
	   write(value);
	   
	}
	public void writeLine(List<String> vList) {
		for (String value : vList) {
			write(value);
		}
		this.cellNum = 0;
		this.row = this.sheet.createRow(rowNum);
		
		rowNum++;
	}
	public void writeFile() {
		
		try {
			File file = new File(fileName);

			workbook.write(new FileOutputStream(file));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
