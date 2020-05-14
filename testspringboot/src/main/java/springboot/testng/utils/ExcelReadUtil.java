package springboot.testng.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


public class ExcelReadUtil {
	
	private Workbook workbook;
	private int tempLine = 0;
	private int sheetAt = 0;
	
	public ExcelReadUtil(String filePath) {
		readExcel(filePath);
	}
	
	
	public List<String> readNextLine() {
		tempLine++;
		return readLine(tempLine);
	}
	public List<String> readLine(Integer line) {
		Sheet sheet = readSheet(sheetAt);
		this.tempLine = line;
		return readLine(sheet, line);
		
	}
	public List<String> readLine(Sheet sheet, Integer line) {
		int num = sheet.getLastRowNum();
		if (line > num) {
			throw new RuntimeException("列表最大行数为"+num);
		}
		Row row = sheet.getRow(line);
		return readRow(row);
	}
	
	public int getRows() {
		int num = readSheet(this.sheetAt).getLastRowNum();
		return num;
	}
	private  List<String> readRow(Row row){
		 List<String> list = new LinkedList<String>();
		 short cellNum = row.getLastCellNum();
		 for (short i = 0; i < cellNum ; i++) {
			 Cell cell = row.getCell(i);
			 String value = null;
			 if (cell == null) {

			 }else {
				 CellType cellType = cell.getCellType();
				 if (cellType.equals(CellType.STRING)) {
					 value = cell.getStringCellValue();
				 }
				 if (CellType.NUMERIC.equals(cellType)) {
					 value = String.valueOf(cell.getNumericCellValue());
				 }

			 }
			 list.add(value);
		 }
		return list;
		
	}
	public Sheet readSheet(Integer sheetAt) {
		int sheets = workbook.getNumberOfSheets();
		if (sheetAt > sheets) {
			throw new RuntimeException("sheet数量最大为"+sheets);
		}
		return workbook.getSheetAt(sheetAt);
	}
	private  void readExcel(String fileUrl) {
		try {
			boolean contains = fileUrl.contains(".xls");
			if (!contains) {
			workbook = new HSSFWorkbook(new FileInputStream(fileUrl));
			}else { 
				workbook = new XSSFWorkbook(new FileInputStream(fileUrl));
			}
			//获取第一个 sheet
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void setSheet(int sheet ) {
		this.sheetAt = sheet;
	}

	public Workbook getWorkbook() {
		return workbook;
	}
}
