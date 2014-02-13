package com.taotaoti.common.utils;

import java.io.IOException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * 
 * @author zengyunfeng
 * 
 */

public class DES {

	// Crypt Key

	private byte[] desKey;
	
	private static final String charset = "UTF-8";

	public DES(String desKey) {

		this.desKey = desKey.getBytes();

	}

	/**
	 * 
	 * DES Encoder
	 * 
	 * @param plainText
	 * 
	 * @return
	 * 
	 * @throws Exception
	 * 
	 */

	public byte[] desEncrypt(byte[] plainText) throws Exception {

		SecureRandom sr = new SecureRandom();

		byte rawKeyData[] = desKey;

		DESKeySpec dks = new DESKeySpec(rawKeyData);

		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");

		SecretKey key = keyFactory.generateSecret(dks);

		Cipher cipher = Cipher.getInstance("DES");

		cipher.init(Cipher.ENCRYPT_MODE, key, sr);

		byte data[] = plainText;

		byte encryptedData[] = cipher.doFinal(data);

		return encryptedData;

	}

	/**
	 * 
	 * DES Decoder
	 * 
	 * @param encryptText
	 * 
	 * @return
	 * 
	 * @throws Exception
	 * 
	 */

	public byte[] desDecrypt(byte[] encryptText) throws Exception {

		SecureRandom sr = new SecureRandom();

		byte rawKeyData[] = desKey;

		DESKeySpec dks = new DESKeySpec(rawKeyData);

		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");

		SecretKey key = keyFactory.generateSecret(dks);

		Cipher cipher = Cipher.getInstance("DES");

		cipher.init(Cipher.DECRYPT_MODE, key, sr);

		byte encryptedData[] = encryptText;

		byte decryptedData[] = cipher.doFinal(encryptedData);

		return decryptedData;

	}

	/**
	 * 
	 * Cookie Encoder
	 * 
	 * @param input
	 * 
	 * @return
	 * 
	 * @throws Exception
	 * 
	 */

	public String encrypt(String input) throws Exception {

		return base64Encode(desEncrypt(input.getBytes(charset)));

	}

	/**
	 * 
	 * Cookie Decoder
	 * 
	 * @param input
	 * 
	 * @return
	 * 
	 * @throws Exception
	 * 
	 */

	public String decrypt(String input) throws Exception {

		byte[] result = base64Decode(input);

		return new String(desDecrypt(result),charset);

	}

	/**
	 * 
	 * Base64 Encode
	 * 
	 * @param s
	 * 
	 * @return
	 * 
	 */

	public static String base64Encode(byte[] s) {

		if (s == null)
			return null;

//		BASE64Encoder b = new sun.misc.BASE64Encoder();
//
//		return b.encode(s);
		return String.valueOf(Base64Coder.encode(s));

	}

	/**
	 * 
	 * Base64 Decode
	 * 
	 * @param s
	 * 
	 * @return
	 * 
	 * @throws IOException
	 * 
	 */

	public static byte[] base64Decode(String s) throws IOException {

		if (s == null)
			return null;

//		BASE64Decoder decoder = new BASE64Decoder();
//
//		byte[] b = decoder.decodeBuffer(s);
//
//		return b;
		return Base64Coder.decode(s);

	}

	public static void main(String[] args) throws Exception {

		String key = "crypt";

		String input = "1|ut中文tar@utstar.com|11000000000000|";

		DES crypt = new DES(key);

		System.out.println("Encode:" + crypt.encrypt(input));

		System.out.println("Decode:" + crypt.decrypt(crypt.encrypt(input)));

	}

}
