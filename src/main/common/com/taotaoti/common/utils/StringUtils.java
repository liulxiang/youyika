package com.taotaoti.common.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 字符串工具方法集
 */
public class StringUtils {

	public final static boolean isLegalUrl(String url) {
		return url
				.matches("^((https|http|ftp|rtsp|mms)?://)"
						+ "+(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?"
						+ "(([0-9]{1,3}\\.){3}[0-9]{1,3}" + "|"
						+ "([0-9a-z_!~*'()-]+\\.)*"
						+ "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\."
						+ "[a-z]{2,6})" + "(:[0-9]{1,4})?" + "((/?)|"
						+ "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$");
	}

	/**
	 * 判断字符串是否为空
	 * @param s
	 * @return
	 */
	public final static boolean isEmpty(String s) {
		return s == null || s.length() == 0;
	}

	/**
	 * 判断字符串是否逻辑为空，trim后的长度是否为0
	 * @param s
	 * @return
	 */
	public final static boolean isLogicEmpty(String s) {
		return s == null || s.trim().length() == 0;
	}

	/**
	 * 是否是合法的UC用户名
	 * @param s
	 * @return
	 */
	public final static boolean isLegalUserName(String s) {
		//TODO 逻辑未实现
		return false;
	}

	/**
	 * 是否是合法的ip地址
	 * @param ip
	 * @return
	 */
	public final static boolean isLegalIpAddress(String ip) {
		if (isEmpty(ip)) {
			return false;
		}
		return IP4PATTERN.matcher(ip).matches()
				|| IP6PATTERN.matcher(ip).matches();
	}

	/**
	 * IPV4的地址正则
	 */
	private static final Pattern IP4PATTERN = Pattern
			.compile(
					"^(([1-9][0-9]?)|(1[0-9]{2})|(2[0-4][0-9])|(25[0-5]))\\."
							+ "((0)|([1-9][0-9]?)|(1[0-9]{2})|(2[0-4][0-9])|(25[0-5]))\\."
							+ "((0)|([1-9][0-9]?)|(1[0-9]{2})|(2[0-4][0-9])|(25[0-5]))\\."
							+ "((0)|([1-9][0-9]?)|(1[0-9]{2})|(2[0-4][0-9])|(25[0-5]))$",
					Pattern.CASE_INSENSITIVE);

	/**
	 * IPV6的地址的正则
	 */
	private static final Pattern IP6PATTERN = Pattern
			.compile(
					"^(^::$)|(^([\\d|a-fA-F]{1,4}:){7}([\\d|a-fA-F]{1,4})$)"
							+ "|(^(::(([\\d|a-fA-F]{1,4}):){0,5}([\\d|a-fA-F]{1,4}))$)"
							+ "|(^(([\\d|a-fA-F]{1,4})(:|::)){0,6}([\\d|a-fA-F]{1,4})$)$",
					Pattern.CASE_INSENSITIVE);

	private static char md5Chars[] = { '0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
	private static MessageDigest messagedigest;

	/**
	 * 获取一个字符串的md5
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static String getStringMD5String(String str)
			throws Exception {
		messagedigest = MessageDigest.getInstance("MD5");
		messagedigest.update(str.getBytes());
		return bufferToHex(messagedigest.digest());
	}

	/**
	 * 验证一个字符串的MD5
	 * @param str
	 * @param md5
	 * @return
	 * @throws Exception
	 */
	public static boolean check(String str, String md5)
			throws Exception {
		if (getStringMD5String(str).equals(md5))
			return true;
		else
			return false;
	}

	private static String bufferToHex(byte bytes[]) {
		return bufferToHex(bytes, 0, bytes.length);
	}

	private static String bufferToHex(byte bytes[], int m, int n) {
		StringBuffer stringbuffer = new StringBuffer(2 * n);
		int k = m + n;
		for (int l = m; l < k; l++) {
			appendHexPair(bytes[l], stringbuffer);
		}
		return stringbuffer.toString();
	}

	private static void appendHexPair(byte bt,
			StringBuffer stringbuffer) {
		char c0 = md5Chars[(bt & 0xf0) >> 4];
		char c1 = md5Chars[bt & 0xf];
		stringbuffer.append(c0);
		stringbuffer.append(c1);
	}
	
	/**
	 * GBK验证
	 */
	public static boolean isGBK(String input) {
		try {
			if (input.equals(new String(input.getBytes("GBK"), "GBK"))) {
				return true;
			} else {
				return false;
			}
		} catch (UnsupportedEncodingException e) {
			return false;
		}
	}
	
	/**
	 * 将一个list组装成字符串，list各个元素之间以split分割
	 * 
	 * @param collection
	 * @param split 分隔符, 如果为null, 则返回长度为0的字符串
	 * @return
	 */
	public static String makeStrFromCollection(final Collection<? extends Object> collection,
			final String split) {

		if (collection == null || collection.isEmpty()) {
			return "";
		}
		if (split == null){
			return "";
		}

		StringBuilder builder = new StringBuilder();

		for(Object element : collection){
			builder.append(element).append(split);
		}
		builder.delete(builder.length()-split.length(), builder.length());

		return builder.toString();
	}
	
	/**
	 * 把以分割的字符串切割成字符串列表，每个字符串进行trim,列表中不包含空字符串
	 * 
	 * @param listString
	 * @param split 连接的字符串，正则表达式
	 * @return
	 */
	public static List<String> splitToList(final String listString, final String split) {
		List<String> result = new ArrayList<String>();
		if (listString == null) {
			return result;
		}
		if(split== null || split.length() == 0){
			return result;
		}
		String tmpListString = listString.trim();

		String[] array = tmpListString.split(split);
		for (String str : array) {
			str = str.trim();
			if (!"".equals(str)) {
				result.add(str);
			}
		}
		return result;
	}
	
}
