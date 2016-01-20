package com.ghost.supermarket;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileManager {
	private static String salesResultString="D:\\�ֶ���\\����\\10��¡̩����for test.xls";
	private static String readChargeString="D:\\�ֶ���\\����\\2015��10��for test.xls";
	public static FileInputStream readSalesResults(){
		String fileNameString=salesResultString;//����վ����
		FileInputStream in = null;
		 try {
			in = new FileInputStream(new File(fileNameString));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return in;
	}
	public static FileInputStream readChargeExcel(){
		String fileNameString=readChargeString;//�Լ�ͳ�Ƶı��
		FileInputStream in = null;
		 try {
			in = new FileInputStream(new File(fileNameString));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return in;
	}
	public static FileOutputStream writeChargeExcel() throws FileNotFoundException{
		FileOutputStream out = new FileOutputStream(new File(readChargeString));
		return out;
	}
}
