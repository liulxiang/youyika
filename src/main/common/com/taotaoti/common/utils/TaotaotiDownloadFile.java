package com.taotaoti.common.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import org.springframework.dao.support.DaoSupport;

public class TaotaotiDownloadFile {
	
	public static  File saveToFiles(String destUrl,String path) throws IOException {
        final int BUFFER_SIZE = 4096;
        System.out.println("file download url is "+destUrl+" path is"+path+"--------------");
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        HttpURLConnection httpconn = null;
        URL url = null;
        byte[] buf = new byte[BUFFER_SIZE];
        int size = 0;  
        File storeFile = new File(path,System.currentTimeMillis()+".tmp");
        System.out.println("file download url is "+destUrl+"path is "+path+"---------------");

        // connection
        url = new URL(destUrl);
        httpconn = (HttpURLConnection) url.openConnection();
        httpconn.setRequestProperty("Host", "analigesto.com");
        httpconn.setRequestProperty("User-Agent", "Mozilla/5.0 (X11; U; Linux i686; zh-CN; rv:1.9.0.18) Gecko/2010021501 Ubuntu/9.04 (jaunty) Firefox/3.0.18");
        httpconn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8"); 
        httpconn.setRequestProperty("Accept-Language", "zh-cn,zh;q=0.5");
        httpconn.setRequestProperty("Accept-Encoding", "gzip,deflate");
        httpconn.setRequestProperty("Accept-Charset", "gb2312,utf-8;q=0.7,*;q=0.7");
        httpconn.setRequestProperty("Keep-Alive", "300");
        httpconn.setRequestProperty("Connection", "Keep-Alive");
        httpconn.setRequestProperty("Cookie", "PHPSESSID=1d888d20bba26e676811ebf7f0cd109b");
        try{
            httpconn.setReadTimeout(40000); // 设置读取文件超时时间
            httpconn.connect();
            String type = httpconn.getContentType();
            int statuscode = httpconn.getResponseCode(); // 建立链接后先查询url的状态码
            if(statuscode == 200&&type.contains("application/")){ //链接正常。并得到了返回信息
                bis = new BufferedInputStream(httpconn.getInputStream()); // 建立管道，准备读取数据流
                fos = new FileOutputStream(storeFile);
                System.out.println("it is to receive link[" + destUrl + "]content/n be save file is:[" + storeFile
                        + "]");
                
                while ((size = bis.read(buf)) != -1){ // 保存文件到本地磁盘
                    fos.write(buf, 0, size);
                }
                System.out.println("file download url is "+destUrl+"  path is"+path+"  "+new Date());
                fos.close();
                bis.close();
                httpconn.disconnect();
                System.out.println("saveToFiles file is "+storeFile.getName()+" size is "+storeFile.length());
            }else{
                return null;
            }
        }catch(Exception e){
            System.out.println(destUrl+" this url connection timeout ");
            System.out.println(e.toString());
            return null;
        }
        return storeFile;
    }
	
	public static void main(String[] args) throws IOException {
		TaotaotiDownloadFile.saveToFiles("http://cq01-testing-ecom6314.cq01.baidu.com:8088/apiaccountfile/20130503-040801-275e2610fe23c66c142b0b86702cde08.zip", "d://");
	}

}
