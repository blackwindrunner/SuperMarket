package com.ghost.supermarket;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileManager {
	private static String salesResultString="D:\\阎东鹏\\超市\\2017年month月祥隆泰销量for test.xls";
	private static String readChargeString="D:\\阎东鹏\\超市\\2017年month月for test.xls";
	
	public static FileInputStream readSalesResults(int i){
		String fileNameString=salesResultString.replaceAll("month", String.valueOf(i));//从网站下载
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
		String fileNameString=readChargeString.replaceAll("month", String.valueOf(i));//自己统计的表格
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
