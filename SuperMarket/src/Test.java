import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Test {
	public static void main(String[] args)throws Exception 
	   {
	      //Create Blank workbook
	      XSSFWorkbook workbook = new XSSFWorkbook(); 
	      //Create file system using specific name
	      FileOutputStream out = new FileOutputStream(new File("d:\\createworkbook.xlsx"));
	      workbook.createSheet("abc").createRow(0).createCell(0);
	      XSSFCellStyle style = workbook.createCellStyle();
			style.setFillForegroundColor(IndexedColors.VIOLET.getIndex()); 
			XSSFCell cell=workbook.getSheetAt(0).getRow(0).getCell(0);
			style.setFillPattern(CellStyle.SOLID_FOREGROUND); 
			cell.setCellStyle(style); 
	      workbook.write(out);
	      out.close();
	      System.out.println("createworkbook.xlsx written successfully");
	   }
}
