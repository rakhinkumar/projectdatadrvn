package datadriven;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel001 {
	XSSFWorkbook wb;
	XSSFSheet sheet;
	public ReadExcel001 (String excelpath) {
	try
	{
		File src=new File(excelpath);
		FileInputStream fis=new FileInputStream(src);
		wb=new XSSFWorkbook(fis);
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
}
	public String getData(int sheetnumber,int row,int column)
	{
		sheet = wb.getSheetAt(sheetnumber);
	    String data = "";
	    XSSFRow currentRow = sheet.getRow(row);
	    if (currentRow != null) {
	        XSSFCell currentCell = currentRow.getCell(column);
	        if (currentCell != null) {
	            if (currentCell.getCellType() == CellType.STRING) {
	                data = currentCell.getStringCellValue();
	            } else if (currentCell.getCellType() == CellType.NUMERIC) {
	                data = String.valueOf(currentCell.getNumericCellValue());
	            }
	        }}
	            
		return data; 
	}
	public int getRowCount(int sheetIndex) {
        int row = wb.getSheetAt(sheetIndex).getLastRowNum();
        row = row + 0;
        return row;
	}
}
		


