/**
 * 2009-4-20 下午10:52:44
 */
package com.taotaoti.common.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectAccessUtil {

	public static Object readObject(byte[] result) throws IOException,
			 ClassNotFoundException {
		ByteArrayInputStream bos = new ByteArrayInputStream(result);
		ObjectInputStream oos = new ObjectInputStream(bos);
		Object obj = oos.readObject();
		bos.close();
		oos.close();
		return obj;
	}

	/**
	 * 获得对象的字节数组
	 * 
	 * @author zengyunfeng
	 * @param data
	 *            需要是Serializable对象
	 * @return
	 * @throws IOException
	 */
	public static byte[] getBytesFromObject(Serializable data) throws IOException {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		ObjectOutputStream objos = new ObjectOutputStream(os);
		objos.writeObject(data);
		objos.flush();
		byte[] result = os.toByteArray();
		os.close();
		objos.close();
		return result;
	}
}
