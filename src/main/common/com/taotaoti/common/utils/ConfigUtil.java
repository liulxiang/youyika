package com.taotaoti.common.utils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**  
* 读取properties文件  
*/
public class ConfigUtil
{ 
    /**
     * 
     * @param filePath
     * @return
     * @throws IOException
     */
    public static Properties getPropertiesAsConfigFile(String filePath){
    	Properties propertie = new Properties();
        InputStream input = null;
		input = Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath);
        try {
			propertie.load(input);
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        return propertie;
    }
    
    public static  String getKeyValueAsConfigFile(String filePath,String key){
    	Properties propertie = new Properties();
        InputStream input = null;
        String value;
		input = Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath);
        try {
			propertie.load(input);
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		if(propertie.containsKey(key)){
             value = propertie.getProperty(key);//
            return value;
        }
        else {
            return "";
        }
    }
} 