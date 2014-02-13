/*package com.taotaoti.common.httpclient;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;


public class DownloadOpenflightsDataByHttpClient {
	DefaultHttpClient httpclient;
	public static String[] month=new String[]{"January","February","March","April","May","June","July","August","September","October","November","December"};
	public DownloadOpenflightsDataByHttpClient() {
		 httpclient= new DefaultHttpClient();
	}
	public static void main(String[] args) throws Exception {
		String url = "http://apps.bts.gov/xml/ontimesummarystatistics/src/dstat/OntimeSummaryDepaturesDataCSV.xml";
		DownloadOpenflightsDataByHttpClient dataByHttpClient=new DownloadOpenflightsDataByHttpClient();
		if(args!=null&&args.length==5){
			try{
				dataByHttpClient.downloadforSabrinaFromOpenfights(url,args[0],Integer.valueOf(args[1]), Integer.valueOf(args[2]),args[3],args[4] );
			}catch(Exception e){
				System.out.println("参数格式：sabrina-data-MQ-JFK,2013, 2,MQ,JFK");
			}
		}else
		   dataByHttpClient.downloadforSabrinaFromOpenfights(url,"sabrina-data-MQ-JFK",2013, 2,"MQ","JFK" );
	}
	public void downloadforSabrinaFromOpenfights(String url,String fileName,int year,int month,String airline,String airport) throws IOException{
		getDownloadOpenflightsDataForSabrina(url, downloadDataParamforSabrinaFromOpenfights(year,month,airline,airport), fileName);;
	}
	public void getDownloadOpenflightsDataForSabrina(String url,List<NameValuePair> params,String fileName) throws IOException {
		try {
			 httpclient= new DefaultHttpClient();
			HttpPost httpost = new HttpPost(url);
			// 设置表单提交编码为UTF-8
			//httpost.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
			httpost.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
			HttpResponse response = httpclient.execute(httpost);
			HttpEntity entity = response.getEntity();
			StatusLine statusLine = response.getStatusLine();
			if (statusLine.getStatusCode() == 200) {

				File csv = new File("d:/sabrina/" + fileName + ".csv");
				FileOutputStream outputStream = new FileOutputStream(csv);
				InputStream inputStream = response.getEntity().getContent();
				System.out.println(response.getEntity().getContent());
				byte b[] = new byte[1024];
				int j = 0;
				while ((j = inputStream.read(b)) != -1) {
					outputStream.write(b, 0, j);
				}
				outputStream.flush();
				outputStream.close();
				System.out.println("data: " + fileName);
			}
			EntityUtils.consume(entity);
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
	}
	
	public List<NameValuePair> downloadDataParamforSabrinaFromOpenfights(int year,int month,String airline,String airport){
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(getAirlineParam(airline));
		params.add(getAllstatsParam());
		params.add(getAirPortParam(airport));
		params.add(getDayParam());
		params.add(getMonthParam(month));
		params.add(getYearParam(year));
		for(int i=1;i<31;i++){
			params.add(new BasicNameValuePair("Day"+i, ""+i));
		}
		params.add(new BasicNameValuePair("sdtime", "Scheduled+departure+time"));
		params.add(new BasicNameValuePair("adtime", "Actual+departure+time"));
		params.add(new BasicNameValuePair("setime", "Scheduled+elapsed+time"));
		params.add(new BasicNameValuePair("aetime", "Actual+elapsed+time"));
		params.add(new BasicNameValuePair("ddtime", "Departure+delay"));
		params.add(new BasicNameValuePair("wotime", "Wheels-off+time"));
		params.add(new BasicNameValuePair("totime", "Taxi-out+time"));
		params.add(new BasicNameValuePair("delay", "Cause+of+Delay"));
		//sdtime=Scheduled+departure+time&adtime=Actual+departure+time&setime=Scheduled+elapsed+time&aetime=Actual+elapsed+time&ddtime=Departure+delay&wotime=Wheels-off+time&totime=Taxi-out+time&delay=Cause+of+Delay&airport1=JFK&airline=MQ
		
		
		return params;
	}
	public BasicNameValuePair getAirlineParam(String AQ){
		return new BasicNameValuePair("airline",AQ);
	}
	public BasicNameValuePair getAllstatsParam(){
		return new BasicNameValuePair("allstats", "allstats");
	}
	public BasicNameValuePair getAirPortParam(String airPort){
		return new BasicNameValuePair("airport1", airPort);
	}
	public BasicNameValuePair getDayParam(){
		return new BasicNameValuePair("alldays", "alldays");
	}
	public BasicNameValuePair getYearParam(int yearNo){
		int tempYear=yearNo-1994;
		BasicNameValuePair basicNameValuePair =new BasicNameValuePair("year"+tempYear, ""+yearNo);;
		return basicNameValuePair;
	}
	public BasicNameValuePair getMonthParam(int monthNo){
		BasicNameValuePair basicNameValuePair = null;
		for(int i=1;i<13;i++){
			if(monthNo==i){
				basicNameValuePair=new BasicNameValuePair("month"+i, ""+month[i-1]);
			}else{
			}
		}
		return basicNameValuePair;
	}
}
*/