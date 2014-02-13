/**
 * 
 */
package com.taotaoti.common.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author zengyunfeng
 * @version 1.2.0
 * 
 */
public class TaskLogUtils {

	/**
	 * 获得测试日志实例
	 * 
	 * @return
	 */
	private static Log getTaskLogger() {
		return LogFactory.getLog("task");
	}

	/**
	 * 以info模式打印出任务日志
	 * 
	 * @param info
	 */
	public static void info(String info) {
		Log log = getTaskLogger();
		log.info(info);
	}
	

	/**
	 * 以debug模式打印出任务日志
	 * 
	 * @param info
	 */
	public static void debug(String info) {
		Log log = getTaskLogger();
		log.debug(info);
	}



}
