package com.ghost.supermarket;

import java.io.IOException;

public class Start {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*ExcelManager excelManager=new ExcelManager();
		excelManager.initResultIndex();
		excelManager.initChargeExcel();
		excelManager.fillSalesAmout();*/
		//forѭ�����µ����£�ע������ʱ������Ҫ��FileManager������
		for(int i=2;i<=7;i++){
			ExcelManager excelManager=new ExcelManager();
			excelManager.initResultIndex(i);
			excelManager.initChargeExcel(i);
			excelManager.fillSalesAmout(i);
		}
		
		
	}

}
