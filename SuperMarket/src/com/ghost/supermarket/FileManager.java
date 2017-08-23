package com.ghost.supermarket;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileManager {
	private static String salesResultString="D:\\�ֶ���\\����\\2017��month����¡̩����for test.xls";
	private static String readChargeString="D:\\�ֶ���\\����\\2017��month��for test.xls";
	
	public static FileInputStream readSalesResults(int i){
		String fileNameString=salesResultString.replaceAll("month", String.valueOf(i));//����վ����
		FileInputStream in = null;
		 try {
			in = new FileInputStream(new File(fileNameString));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return in;
	}
	public static FileInputStream readChargeExcel(int i){
		String fileNameString=readChargeString.replaceAll("month", String.valueOf(i));//�Լ�ͳ�Ƶı��
		FileInputStream in = null;
		 try {
			in = new FileInputStream(new File(fileNameString));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return in;
	}

	public static FileOutputStream writeChargeExcel(int i) throws FileNotFoundException{
		FileOutputStream out = new FileOutputStream(new File(readChargeString.replaceAll("month", String.valueOf(i))));
		System.out.println(readChargeString.replaceAll("month", String.valueOf(i)));
		return out;
	}
}
