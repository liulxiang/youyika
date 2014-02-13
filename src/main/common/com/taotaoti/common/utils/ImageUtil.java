/*package com.taotaoti.common.utils;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.slf4j.Logger;

import sun.misc.BASE64Encoder;

import com.taotaoti.common.log.AopLogFactory;

*//**
 * 
 * 操作图片工具类
 *
 * @author <a href="mailto:zhangxu04@baidu.com">Zhang Xu</a>
 * @version 2013-5-4 上午11:00:56
 *//*
@SuppressWarnings("restriction")
public class ImageUtil {

	private static final Logger log = AopLogFactory.getLogger(ImageUtil.class);

	public static String GetImageStrInBase64(String imgFile) {
		InputStream in = null;
		byte[] data = null;
		try {
			in = new FileInputStream(imgFile);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);
	}

	public static byte[] GetImageByte(String imgFile) {
		InputStream in = null;
		byte[] data = null;
		try {
			in = new FileInputStream(imgFile);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
		return data;
	}

	public static byte[] getImageThruHTTPGet(String url) {
		GetMethod method = new GetMethod(url);
		try {
			HttpConnectionManagerParams connectionParams = new HttpConnectionManagerParams();
			connectionParams.setConnectionTimeout(5 * 1000);
			connectionParams.setSoTimeout(5 * 1000);
			HttpConnectionManager manager = new SimpleHttpConnectionManager();
			manager.setParams(connectionParams);
			HttpClient client = new HttpClient(manager);
			int state = client.executeMethod(method);
			if (state == HttpStatus.SC_OK) {
				byte[] imageData = method.getResponseBody();
				log.info("Get url=" + url + " successfully");
				return imageData;
			} else {
				log.warn("Failed to get image url=" + url);
				return null;
			}
		} catch (Exception e) {
			log.warn("Failed to get image from url=" + url);
			return null;
		} finally {
			if (method != null) {
				try {
					method.releaseConnection();
				} catch (Exception e) {
					log.warn("Failed to release connection. " + e.getMessage());
				}
			}
		}
	}

	public static void getImageThruHTTPGet(String url, String savePath) {
		GetMethod method = new GetMethod(url);
		try {
			HttpConnectionManagerParams connectionParams = new HttpConnectionManagerParams();
			connectionParams.setConnectionTimeout(5 * 1000);
			connectionParams.setSoTimeout(5 * 1000);
			HttpConnectionManager manager = new SimpleHttpConnectionManager();
			manager.setParams(connectionParams);
			HttpClient client = new HttpClient(manager);
			int state = client.executeMethod(method);
			if (state == HttpStatus.SC_OK) {
				byte[] imageData = method.getResponseBody();
				OutputStream ut = null;
				try {
					ut = new BufferedOutputStream(new FileOutputStream(savePath), 2048);
					ut.write(imageData);
				} catch (Exception e) {
					log.warn("Failed to save image url=" + url + " to path=" + savePath);
				} finally {
					if (null != ut) {
						ut.close();
					}
				}
			} else {
				log.warn("Failed to get image from url=" + url + ", HTTP status=" + state);
			}
		} catch (Exception e) {
			log.warn("Failed to get image from url:" + url, e);
		} finally {
			if (method != null) {
				try {
					method.releaseConnection();
				} catch (Exception e) {
					log.warn("Failed to release connection. " + e.getMessage(), e);
				}
			}
		}
	}

	public static BufferedImage getBufferedImageFromByteArray(byte[] binaryData) {
		ByteArrayInputStream input = null;
		BufferedImage img = null;
		try {
			input = new ByteArrayInputStream(binaryData);
			img = ImageIO.read(input);
			return img;
		} catch (Exception e) {
			log.error("ImageIO.read(file) failed, " + e.getMessage(), e);
			return null;
		} finally {
			try {
				input.close();
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
	}

	*//**
	 * 判断文件类型是否为jpg/gif/png
	 *//*
	public static boolean isPictureTypeValid(byte[] date) {
		if (date == null || date.length < 10) {
			return false;
		}
		if (date[0] == (byte) 'G' && date[1] == (byte) 'I' && date[2] == (byte) 'F') {
			// "GIF";
			return true;
		} else if (date[1] == (byte) 'P' && date[2] == (byte) 'N' && date[3] == (byte) 'G') {
			// "PNG";
			return true;
		} else if (date[6] == (byte) 'J' && date[7] == (byte) 'F' && date[8] == (byte) 'I' && date[9] == (byte) 'F') {
			// "JPG";
			return true;
		} else if (date[6] == (byte) 'E' && date[7] == (byte) 'x' && date[8] == (byte) 'i' && date[9] == (byte) 'f') {//解决bug:CS5生成的JPG图片
			// "JPG";
			return true;
		} else {
			// not sure: BMP: date[0] == 'B' && date[1]== 'M' &&  date[2] == 'P'
			return false;
		}
	}
	
	public static void main(String[] args) {
		byte[] test = ImageUtil.GetImageByte("e:\\trade-sprite.png");
		System.out.println(test.length);
		byte[] image = ImageUtil.getImageThruHTTPGet("http://10.81.31.95:8230/asset/css/img/trade-sprite.png");
		System.out.println(image.length);
		getImageThruHTTPGet("http://10.81.31.95:8230/asset/css/img/trade-sprite.png", "e:\\test.png");
	}

}
*/