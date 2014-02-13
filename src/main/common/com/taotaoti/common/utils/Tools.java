package com.taotaoti.common.utils;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/** 工具类 */
public class Tools {
	private static SimpleDateFormat dfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	//创建日期格式
	private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	//创建时间格式
	private static SimpleDateFormat dfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	//创建中国的货币格式
	private static NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.CHINA);	

	/** FCKeditor内置的分页字符串 */
	private static String fck_separator="<div style=\"PAGE-BREAK-AFTER: always\"><span style=\"DISPLAY: none\">&nbsp;</span></div>";
	/****格式化日期********/
	public static Timestamp getTimestamp(){
		String time = df.format(new Date());
		Timestamp ts = Timestamp.valueOf(time);
		return ts;
	}
	/** 取得指定图片的宽度与高度 */
	public static Map getPicWidthHeight(String filename){
		Map map = new HashMap();
		try {
			BufferedImage sourceImg = javax.imageio.ImageIO.read(new FileInputStream(filename));
			map.put("width", sourceImg.getWidth());
			map.put("height", sourceImg.getHeight());
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
	}
	
	/** 是否没有指定的操作权限 *//* 
	public static boolean isDisable(Admin admin, int option) {
		if(admin==null){
			return true;
		}else{
			if (admin.getPrivileges().substring(0, 1).equals("1"))
				return false;
			else {
				if (admin.getPrivileges().substring(option - 1, option).equals("1"))
					return false;
				else
					return true;
			}			
		}
	}
	*/
/*	*//** 是否拥有指定的操作权限 *//* 
	public static boolean isEnable(Admin admin, int option) {
		if(admin==null){
			return false;
		}else{
			if (admin.getPrivileges().substring(0, 1).equals("1"))
				return true;
			else {
				if (admin.getPrivileges().substring(option - 1, option).equals("1"))
					return true;
				else
					return false;
			}			
		}
	}*/
	
	/** 取得随机主文件名 */
	public synchronized static String getRndFilename(){
		return String.valueOf(System.currentTimeMillis());
	}
	
	/** 取得指定文件的文件扩展名 */
	public synchronized static String getFileExtName(String filename){
		int p = filename.indexOf(".");
		return filename.substring(p);
	}
	
	/** 验证上传文件的类型是否合法 fileType:1-图片 2-视频*/
	public synchronized static boolean isEnableUploadType(int fileType,String filename){
		String enableExtNames = null;
		int p = filename.indexOf(".");
		String fileExtName = filename.substring(p).toLowerCase();
		if (fileType==1){//图片文件类型
			enableExtNames = ".jpg,.gif,.png";
		}else if (fileType==2){//视频文件类型
			enableExtNames = ".flv";
		}
		if (enableExtNames!=null){
			if (enableExtNames.indexOf(fileExtName)!=-1)return true;
			else return false;			
		}else{
			return true;
		}

	}	
	
	/** HTML代码的Escape处理方法 */
	public static String  escape(String src){
		int i;
		char j;
		StringBuffer tmp = new StringBuffer();
		tmp.ensureCapacity(src.length()*6);
		for (i=0;i<src.length();i++){
			j = src.charAt(i);
			if (Character.isDigit(j) || Character.isLowerCase(j) || Character.isUpperCase(j)) 
				tmp.append(j);
			else if(j<256){
				tmp.append( "%" );
				if (j<16)tmp.append("0");
				tmp.append( Integer.toString(j,16));
			}else{
				tmp.append("%u");
				tmp.append(Integer.toString(j,16));
			}
		}
		return tmp.toString();
	}
	
	/** HTML代码的UnEscape处理方法 */
	public static String  unescape(String src){
		StringBuffer tmp = new StringBuffer();
		tmp.ensureCapacity(src.length());
		int lastPos=0,pos=0;
		char ch;
		while(lastPos<src.length()){
			pos = src.indexOf("%",lastPos);
			if (pos == lastPos){
				if (src.charAt(pos+1)=='u'){
					ch = (char)Integer.parseInt(src.substring(pos+2,pos+6),16);
					tmp.append(ch);
					lastPos = pos+6;
				}else{
					ch = (char)Integer.parseInt(src.substring(pos+1,pos+3),16);
					tmp.append(ch);
					lastPos = pos+3;
				}
			}else{
				if (pos == -1){
					tmp.append(src.substring(lastPos));
					lastPos=src.length();
				}else{
					tmp.append(src.substring(lastPos,pos));
					lastPos=pos;
				}
			}
		}
		return tmp.toString();
	}
	
	/** 为以逗号分隔的字符串的每个单元加入引号,如:aa,bb-->'aa','bb' */
	public static String formatString(String src){
		StringBuffer result = new StringBuffer();
		result.append("");
		if (src!=null){
			String[] tmp = src.split(",");
			result.append("'"+tmp[0]+"'");
			for(int i=1;i<tmp.length;i++){
				result.append(",'"+tmp[i]+"'");
			}
		}		
		return result.toString();
	}	
	
    /** 截取指定字节数的字符串,且确保汉字不被拆分 */
	public static String cutString(String text, int textMaxChar){   
        int size,index;   
        String result = null;  
        if(textMaxChar<=0){   
        	result= text;   
        }else{   
            for(size=0,index=0;index<text.length()&&size<textMaxChar;index++){   
                size += text.substring(index,index+1).getBytes().length;   
            }   
            result = text.substring(0,index);   
        }  
        return result;   
    }
	
    /** 按yyyy-MM-dd格式格式化日期 */
	public static String formatDate(Date date){   
		if (date==null){
			return "";
		}else{
			return df.format(date);
		}
    }
	/**将String 转化为日期yyyy-mm-dd 格式
	 * @throws ParseException **/
	public static Date dateFormat(String str) throws ParseException{
		if(str==null){
			return new Date();
		}else{
			return dfDate.parse(str);
		}
	}
	  /** 按yyyy-MM-dd mm:hh:ss格式格式化日期 */
	public static String formatDateTime(Date date){   
		if (date==null){
			return "";
		}else{
			return dfTime.format(date);
		}
    }
	
	public static String stringformatdateString(String str) throws ParseException{
		if(str==null){
			return dfTime.format(new Date());
		}else{
            Date d=dfDate.parse(str);
			
	     	return dfTime.format(d);
		}
	}
	
	
    /** 对未escape的HTML内容进行FCK分页处理,返回String[] */
	public static String[] splitContent(String unEscapedHtml){ 
		if (unEscapedHtml==null){
			return null;
		}else{
			return unescape(unEscapedHtml).split(fck_separator);
		}
	}
	
	/** 取得格式化后的中国货币字符串 */
	public static String formatCcurrency(double money){
		return currencyFormat.format(money);   		

		
	}

	
	
	
	public static LinkedHashMap sortHashMap(HashMap<Integer, Integer> hm) {
		LinkedHashMap<Integer, Integer> linkedHM = new LinkedHashMap<Integer, Integer>();
		int index = 0;
		Collection<Integer> DateColl = hm.values();
		Object[] dates = DateColl.toArray();
		Arrays.sort(dates);
		System.out.println("dates after sorted");
		Set set = hm.entrySet();
		for (int j = 0; j < dates.length; j++) {
			Iterator it = set.iterator();
			while (it.hasNext()) {
				Map.Entry<Integer, Integer> me = (Map.Entry<Integer, Integer>) it.next();
				if (dates[j].equals(me.getValue())) {
					linkedHM.put(me.getKey(), me.getValue());
				}
			}
		}
		return linkedHM;
	}
	public static LinkedHashMap sortHashMapString(HashMap<String, Integer> hm) {
		LinkedHashMap<String, Integer> linkedHM = new LinkedHashMap<String, Integer>();
		int index = 0;
		Collection<Integer> DateColl = hm.values();
		Object[] dates = DateColl.toArray();
		Arrays.sort(dates);
		System.out.println("dates after sorted");
		Set set = hm.entrySet();
		for (int j = 0; j < dates.length; j++) {
			Iterator it = set.iterator();
			while (it.hasNext()) {
				Map.Entry<String, Integer> me = (Map.Entry<String, Integer>) it.next();
				if (dates[j].equals(me.getValue())) {
					linkedHM.put(me.getKey(), me.getValue());
				}
			}
		}
		return linkedHM;
	}
	
	public static void main(String[] args) throws ParseException{
		System.out.println(escape(""));
		Date d=dateFormat("2010-12-5 20:02:41");
		String sdeta=formatDateTime(d);
		System.out.println(System.currentTimeMillis());
		System.out.println(Timestamp.valueOf(sdeta));
		
		System.out.println(stringformatdateString("2010-12-05 20:02:41.23"));
		
	}
	
}
