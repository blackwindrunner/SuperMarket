package com.ghost.supermarket;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.PaintStyle.GradientPaint.GradientType;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;

import com.ghost.supermarket.pojo.Product;

public class ExcelManager {
	private HSSFWorkbook salesExcelBook;
	private HSSFWorkbook chargeExcelBook;
	private int productCodeColumnIndex;
	private int productNameColumnIndex;
	private int deliveryPriceColumnIndex;
	private int saleroomColumnIndex;
	private int dataRowStart;
	private int salesAmountColumnIndex;
	private List<Product> productList = new ArrayList<Product>();
	private Map<String, Integer> productCodeAndRepeatNumberMap = new HashMap<String, Integer>();
	private Map<String, Integer> productCodeAndRowNumberMap = new HashMap<String, Integer>();
	/**
	 * ��ʼ�����۽����
	 * @throws IOException
	 */
	public void initResultIndex() throws IOException {
		salesExcelBook = new HSSFWorkbook(FileManager.readSalesResults());
		HSSFSheet firstSheet = salesExcelBook.getSheetAt(0);
		firstSheet.getRow(1);
		Iterator<Row> rowIterator = firstSheet.iterator();
		outer: while (rowIterator.hasNext()) {
			HSSFRow row = (HSSFRow) rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				if (Cell.CELL_TYPE_STRING == cell.getCellType()) {
					if ("��Ʒ����".equals(cell.getStringCellValue())) {
						productCodeColumnIndex = cell.getColumnIndex();//�����Ʒ���������е�������
					}
					if ("��Ʒ����".equals(cell.getStringCellValue())) {
						productNameColumnIndex = cell.getColumnIndex();//�����Ʒ���������е�������
					}
					if ("���۶�(������)".equals(cell.getStringCellValue())) {
						deliveryPriceColumnIndex = cell.getColumnIndex();//������۶������е�������
					}
					if ("��������".equals(cell.getStringCellValue())) {
						salesAmountColumnIndex = cell.getColumnIndex();//�������������е�������
					}
					if ("ʵ�����۶�".equals(cell.getStringCellValue())) {
						saleroomColumnIndex = cell.getColumnIndex();//���ʵ�����۶������е�������
						dataRowStart = row.getRowNum() + 1;
						break outer;
					}
				}
			}
		}
		System.out.println(productCodeColumnIndex);
		System.out.println(deliveryPriceColumnIndex);
		System.out.println(saleroomColumnIndex);
		System.out.println(dataRowStart);
		rowIterator = firstSheet.iterator();
		while (rowIterator.hasNext()) {
			HSSFRow row = (HSSFRow) rowIterator.next();
			if (row.getRowNum()>=dataRowStart) {
				//��ÿһ����Ʒ����װ��Product����
				HSSFCell productCodeCell =row.getCell(productCodeColumnIndex);
				HSSFCell productNameCell =row.getCell(productNameColumnIndex);
				HSSFCell deliveryPriceCodeCell =row.getCell(deliveryPriceColumnIndex);
				HSSFCell saleroomCodeCell =row.getCell(saleroomColumnIndex);
				HSSFCell salesAmountCell =row.getCell(salesAmountColumnIndex);
				Product product=new Product();
				product.setProductCode(productCodeCell.getNumericCellValue());
				product.setProductName(productNameCell.getStringCellValue());
				product.setDeliveryPrice(deliveryPriceCodeCell.getNumericCellValue());
				product.setSaleroom(saleroomCodeCell.getNumericCellValue());
				product.setSalesAmount(salesAmountCell.getNumericCellValue());
				//��ÿһ����Ʒ�����뵽��Ʒ�б���
				productList.add(product);
			}
		}
//		System.out.println(projectList.get(144).getProductCode());
//		salesExcelBook.close();
	}
	/**
	 * ��ʼ���۸��
	 * @throws IOException
	 */
	public void initChargeExcel() throws IOException {
		chargeExcelBook = new HSSFWorkbook(FileManager.readChargeExcel());
		HSSFSheet spreadsheet = chargeExcelBook.getSheet("Sheet1");
//		HSSFRow row = spreadsheet.getRow(3);
//		System.out.println(spreadsheet.getRow(3).getCell(2));
		 for (int j = 3; j < spreadsheet.getPhysicalNumberOfRows(); j++) { 
             HSSFRow row=spreadsheet.getRow(j); 
//             System.out.println(row.getCell(2));
             //���Լ������ظ����������г���
         /*    System.out.println("row"+row);
             System.out.println("cell"+row.getCell(2));
             System.out.println("string"+row.getCell(2).toString());*/
             if (row == null) {
				continue;
			}
             if ( productCodeAndRepeatNumberMap.get(row.getCell(2)+"")==null) {
            	 productCodeAndRepeatNumberMap.put(row.getCell(2)+"", 1);
            	 productCodeAndRowNumberMap.put(row.getCell(2)+"", j);
			}else{
				productCodeAndRepeatNumberMap.put(row.getCell(2)+"", productCodeAndRepeatNumberMap.get(row.getCell(2)+"")+1);
			}
		 }
//		 System.out.println(chargeMap.get("210727.0"));
//		 System.out.println(chargeMap.get("192422.0"));
//		 chargeExcelBook.close();
	}
	
	public void fillSalesAmout() throws IOException{
		chargeExcelBook = new HSSFWorkbook(FileManager.readChargeExcel());
		HSSFSheet firstSheet =  chargeExcelBook.getSheet("Sheet1");
		HSSFCellStyle style = chargeExcelBook.createCellStyle();
		HSSFSheet secondSheet =  chargeExcelBook.getSheet("Sheet2");
		while(secondSheet.getPhysicalNumberOfRows()!=0) {
			Row row=secondSheet.getRow(secondSheet.getLastRowNum());  
			secondSheet.removeRow(row);  
		}
		HSSFRow titleRow=secondSheet.createRow(0);
		titleRow.createCell(0).setCellValue("��Ʒ����");
		titleRow.createCell(1).setCellValue("��Ʒ����");
		titleRow.createCell(2).setCellValue("��������");
		titleRow.createCell(3).setCellValue("���۶�����ۣ�");
		titleRow.createCell(4).setCellValue("ʵ�����۶�");
		for (Product product : productList) {
//			System.out.println("a:"+product.getProductCode());
			Integer chargeNumbers=productCodeAndRepeatNumberMap.get(product.getProductCode()+"");
			
			
			if (chargeNumbers==null&&product.getProductCode()!=0){
				//record to other sheet
				HSSFRow newRow=secondSheet.createRow(secondSheet.getPhysicalNumberOfRows()+1);
				HSSFCell newCell_0 = newRow.createCell(0);
				newCell_0.setCellValue(product.getProductCode());
				HSSFCell newCell_1 = newRow.createCell(1);
				newCell_1.setCellValue(product.getProductName());
				HSSFCell newCell_2 = newRow.createCell(2);
				newCell_2.setCellValue(product.getSalesAmount());
				HSSFCell newCell_3 = newRow.createCell(3);
				newCell_3.setCellValue(product.getDeliveryPrice());
				HSSFCell newCell_4 = newRow.createCell(4);
				newCell_4.setCellValue(product.getSaleroom());
				
				
			}else {
				if (productCodeAndRowNumberMap.get(product.getProductCode()+"")==null) {
					continue;
				}
				HSSFRow row = firstSheet.getRow(productCodeAndRowNumberMap.get(product.getProductCode()+""));
				if (row ==null) {
					continue;
				}
				HSSFCell cell = row.getCell(7);
				if (cell==null) {
					continue;
				}
				if (chargeNumbers>1) {
					style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex()); 
					style.setFillPattern(CellStyle.SOLID_FOREGROUND); 
					cell.setCellStyle(style); 
				}else if (chargeNumbers==1) {
					//put value in this sheet
//				    System.out.println("row"+row);
//		             System.out.println("cell"+row.getCell(7));
//		             System.out.println("string"+row.getCell(7).toString());
					cell.setCellValue(product.getSalesAmount());
					//ʹ�����еĹ�ʽ���м���
					chargeExcelBook.getCreationHelper().createFormulaEvaluator().evaluateAll();
					DecimalFormat df = new DecimalFormat("#.##");    
					if (product.getDeliveryPrice()!=Double.parseDouble(df.format(row.getCell(12).getNumericCellValue()))) {
						HSSFCell cell_12 = row.getCell(12);
						style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex()); 
						style.setFillPattern(CellStyle.SOLID_FOREGROUND); 
						cell_12.setCellStyle(style); 
					}
//					get_double = Double.parseDouble(df.format(row.getCell(13).getNumericCellValue()));  
					if (product.getSaleroom()!=Double.parseDouble(df.format(row.getCell(13).getNumericCellValue()))) {
						HSSFCell cell_13 = row.getCell(13);
						style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex()); 
						style.setFillPattern(CellStyle.SOLID_FOREGROUND); 
						cell_13.setCellStyle(style); 
					}
				}
			}
		}
		FileOutputStream out = null;
		try {
			out = FileManager.writeChargeExcel();
			chargeExcelBook.getCreationHelper().createFormulaEvaluator().evaluateAll();
			chargeExcelBook.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
