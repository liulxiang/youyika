package com.taotaoti.common.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
/**
 * 
 * @author liuliangxiang01
 *
 */
public class BTools {
	
	public static void localPrint(File file) throws PrintException, IOException{
        //构建打印请求属性集  
        HashPrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();  
        //设置打印格式，因为未确定类型，所以选择autosense  
        DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;  
        //查找所有的可用的打印服务  
        PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);  
        //定位默认的打印服务  
        PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
        DocPrintJob job = defaultService.createPrintJob(); //创建打印作业  
        FileInputStream fis = new FileInputStream(file); //构造待打印的文件流  
        DocAttributeSet das = new HashDocAttributeSet();  
        Doc doc = new SimpleDoc(fis, flavor, das);  
        job.print(doc, pras);  
        fis.close();
       
	}
	
	public static  byte[] getImageDataAsImagePath(String fileAndPath){
		// set data
		byte[] data=null;
		FileInputStream input = null;
		File tmpFile = new File(fileAndPath);
		
		try {
			long fileSize = tmpFile.length();
			data = new byte[(int) fileSize];
			input = new FileInputStream(tmpFile);
			input.read(data);
			input.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	
	/**
	 * 
	 * @param date
	 * @return yyyy-MM-dd
	 */
	public static String getStringFromDate(Date date){
		String dateString = null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		dateString=sdf.format(date);
		return dateString;
	}
	/**
	 * 
	 * @param date
	 * @return yyyy-MM-dd hh:mm 
	 */
	public static String getStringTimeFromDate(Date date){
		String dateString = null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm");
		dateString=sdf.format(date);
		return dateString;
	}
	
	
	/**
	 * 
	 * @param date
	 * @return yyyy-MM-dd hh:mm:ss 
	 */
	public static String getStringTimessFromDate(Date date){
		String dateString = null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		dateString=sdf.format(date);
		return dateString;
	}
	/**
	 * 
	 * @param yyyy-MM-dd hh:mm
	 * @return date
	 */
	public static Date getDateTimeFromString(String dateString){
		Date date = null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm");
		try {
			date=sdf.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	/**
	 * 
	 * @param yyyy-MM-dd hh:mm:ss
	 * @return date
	 */
	public static Date getDateTimeSSFromString(String dateString){
		Date date = null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			date=sdf.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 
	 * @param yyyy-MM-dd
	 * @return date
	 */
	public static Date getDateFromString(String dateString){
		Date date = null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			date=sdf.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 
	 * @param yyyy-MM-dd
	 * @return date
	 */
	public static Date getRandomDateTimeFromString(String startDate,String endDate){
		Date date = null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		long startTime;
		long endTime;
		long okTime;
		try {
			date=sdf.parse(startDate);
			startTime=date.getTime();
			date=sdf.parse(endDate);
			endTime=date.getTime();
			okTime=getRandom(startTime,endTime);
			date=new Date(okTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	public static long getRandom(){
		long result = 0;
		Random random=new Random();
		result=Math.abs(random.nextLong());
		return result;
	}
	public static long getRandom(long max){
		long result = 0;
		Random random=new Random();
		result=Math.abs(random.nextLong())%(max+1);
		return result;
	}
	public static long getRandom(long start,long end){
		long result = 0;
		Random random=new Random();
		result=Math.abs(random.nextLong())%(end-start+1)+start;
		return result;
	}
	 /**
	 * 
	 * @param fileName
	 */
	public static List readFileByLines(String fileName) {
		List<String> list=new ArrayList<String>();
		File file = new File(fileName);
		System.out.println(file.getName());
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			int line = 1;
			while ((tempString = reader.readLine()) != null) {
				line++;
				list.add(tempString);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
		
		return list;
	}
	
	
	public static List readFileByLinesAsInputStream(InputStream in,String charset) {
		List<String> list=new ArrayList<String>();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(in,charset));
			String tempString = null;
			int line = 1;
			while ((tempString = reader.readLine()) != null) {
				System.out.println("line " + line + ": " + tempString);
				line++;
				list.add(tempString);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
		
		return list;
	}
	public static List readFileByLinesAsInputStream(String fileName) {
		List<String> list=new ArrayList<String>();
		BufferedReader reader = null;
		 InputStream in = BTools.class.getClassLoader().getResourceAsStream(fileName); 
		try {
			reader = new BufferedReader(new InputStreamReader(in,"UTF-8"));
			
			String tempString = null;
			int line = 1;
			while ((tempString = reader.readLine()) != null) {
				//System.out.println("line " + line + ": " + tempString);
				line++;
				list.add(tempString);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
		
		return list;
	}
	 public static InputStream getInputStreamAsFilePath(String fileName) { 
         InputStream in = BTools.class.getClassLoader().getResourceAsStream(fileName); 
         return in; 
    } 
	 public static File  getFileAsFilePath(String fileName) { 
         File file=new File(getConfigImagePath()+"/"+fileName);
         return file; 
    } 
	 
	 public static String getConfigImagePath(){
		 URL url=null;
		 url=BTools.class.getClassLoader().getResource("");
		 String path=url.getPath();
		 return path;
	 }
	 
	 public static String getDateStr(Date date) {
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
					"yyyyMMdd");
			return sdf.format(date);
		}
	  public static void main(String[] args) throws PrintException, IOException {
		File file=new File("C:\\apache-tomcat-6.0.35\\soutupiandian.jpg");
		BTools.localPrint(file);
	}
}
