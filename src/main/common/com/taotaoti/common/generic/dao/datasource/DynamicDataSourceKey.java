package com.taotaoti.common.generic.dao.datasource;

import java.util.Map;

/**
 * 数据源key的存储控制器接口
 * 
 * @author liulxiang 
 */
public interface DynamicDataSourceKey {
	/**
	 * 设置读(从)库数据源对应关系
	 * 
	 * @param readDateSourceMap
	 */
	public abstract void setReadDateSourceMap(
			Map<String, String> readDateSourceMap);

	/**
	 * 获得读(从)库数据源key
	 * 
	 * @param key
	 * @return
	 */
	public abstract String getKey(String key);

	/**
	 * 获得写(主)库数据源key
	 * 
	 * @return
	 */
	public abstract String getWriteKey();

	/**
	 * 设置写(主)库的key
	 * 
	 * @param writeKey
	 */
	public abstract void setWriteKey(String writeKey);

	/**
	 * 设置方法调用时使用写(主)库的key
	 */
	public abstract void setWriteKey();

	/**
	 * 设置方法调用时使用读(从)库的key,随机
	 */
	public abstract void setReadKey();

	/**
	 * 设置方法调用时使用读(从)库的key,指定
	 */
	public abstract void setKey(String key);

	/**
	 * 读取方法调用时使用的key
	 */
	public abstract String getKey();

	/**
	 * 清除设置的key
	 */
	public abstract void clearKey();

}