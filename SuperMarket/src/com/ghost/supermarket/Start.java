package com.ghost.supermarket;

import java.io.IOException;

public class Start {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ExcelManager excelManager=new ExcelManager();
		excelManager.initResultIndex();
		excelManager.initChargeExcel();
		excelManager.fillSalesAmout();
		
	}

}
