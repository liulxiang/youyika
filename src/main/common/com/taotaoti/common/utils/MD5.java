/*
 * Copyright (c) 1999-2010, baidu.com All Rights Reserved.
 */

package com.taotaoti.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * ClassName:MD5 : md5 Function: TODO ADD FUNCTION
 * 
 * @author <a href="mailto:zengyunfeng@baidu.com">曾云峰</a>
 * @version
 * @since TODO
 * @Date 2010 2010-5-25 下午07:57:58
 * 
 * @see
 */

public class MD5 {
	
	private static final Log log = LogFactory.getLog(MD5.class);

	public static void main(String[] args) {
		String dbPassword=MD5.getMd5("chengjie");
		System.out.println(dbPassword);
	}
	
	public static String getMd5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			char str[];
			byte strTemp[] = s.getBytes();
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte md[] = mdTemp.digest();
			int j = md.length;
			str = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}

			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 获取字符串的MD5值，分成两个64位的数表示，第一个数为前64位，第二个数为后64位。采用LITTLE_ENDIAN
	 * @since 1.3.0 zengyunfeng
	 * @param s
	 * @return
	 */
	public static BigInteger[] getMd5Decimal(String s){
		String md5 = getMd5(s);
		if(md5 == null){
			return null;
		}
		if(md5.length()<16){
			return null;
		}
		BigInteger [] result = new BigInteger[2];
		result[0] = new BigInteger(md5.substring(0, 16), 16);
		result[1] = new BigInteger(md5.substring(16), 16);
		return result;
	}
	
	/**
	 * 
	 * 获取文件的MD5值
	 * @param file
	 */
    public static String getFileMD5(File file) throws Exception{
        FileInputStream fis = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            fis = new FileInputStream(file);
            byte[] buffer = new byte[8192];
            int length = -1;
            while ((length = fis.read(buffer)) != -1) {
                md.update(buffer, 0, length);
            }
            return bytesToString(md.digest());
        } catch (Exception e) {
        	log.error("Error occurred when making MD5 for file " + file.getAbsolutePath(), e);
            throw e;
        } 
    }
    
    public static String bytesToString(byte[] data) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
                'e', 'f'};
        char[] temp = new char[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            byte b = data[i];
            temp[i * 2] = hexDigits[b >>> 4 & 0x0f];
            temp[i * 2 + 1] = hexDigits[b & 0x0f];
        }
        return new String(temp);

    }

}
