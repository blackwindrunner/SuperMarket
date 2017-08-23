package com.ghost.supermarket;

import java.io.IOException;

public class Start {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*ExcelManager excelManager=new ExcelManager();
		excelManager.initResultIndex();
		excelManager.initChargeExcel();
		excelManager.fillSalesAmout();*/
		//for循环几月到几月，注意年暂时还是需要到FileManager中配置
		for(int i=2;i<=7;i++){
			ExcelManager excelManager=new ExcelManager();
			excelManager.initResultIndex(i);
			excelManager.initChargeExcel(i);
			excelManager.fillSalesAmout(i);
		}
		
		
	}

}
