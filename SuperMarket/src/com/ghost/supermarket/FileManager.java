package com.ghost.supermarket;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileManager {
	private static String salesResultString="D:\\阎东鹏\\超市\\10祥隆泰销量for test.xls";
	private static String readChargeString="D:\\阎东鹏\\超市\\2015年10月for test.xls";
	public static FileInputStream readSalesResults(){
		String fileNameString=salesResultString;//从网站下载
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
		String fileNameString=readChargeString;//自己统计的表格
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
