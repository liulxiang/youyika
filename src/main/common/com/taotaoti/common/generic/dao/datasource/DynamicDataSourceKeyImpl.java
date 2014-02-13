package com.taotaoti.common.generic.dao.datasource;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * 数据源key的存储控制器
 * 
 * @author liulxiang
 */
public class DynamicDataSourceKeyImpl implements DynamicDataSourceKey {
	private static final Logger log = LoggerFactory.getLogger(DynamicDataSourceKeyImpl.class);
	/**
	 * 数据源key的存储
	 */
	private static final ThreadLocal<String> DB_KEY = new ThreadLocal<String>();
	/**
	 * 读(从)库
	 */
	private Map<String, String> readDateSourceMap = new HashMap<String, String>();

	/**
	 * 写(主)库
	 */
	public String writeKey;
	/**
	 * 读(从)库对应的key
	 */
	private String[] keys;
	private final Random random = new Random();

	public void setReadDateSourceMap(Map<String, String> readDateSourceMap) {
		this.readDateSourceMap = readDateSourceMap;
		keys = readDateSourceMap.keySet().toArray(new String[] {});
	}

	public String getKey(String key) {
		return readDateSourceMap.get(key);
	}

	public String getWriteKey() {
		return writeKey;
	}

	public void setWriteKey(String writeKey) {
		this.writeKey = writeKey;
	}

	public void setWriteKey() {
		DB_KEY.set(writeKey);
		log.debug("set data source writeKey[" + DB_KEY.get() + "]");
		log.info("set data source writeKey[" + DB_KEY.get() + "]");
	}

	public void setReadKey() {
		DB_KEY.set(readDateSourceMap.get(getRandomKey()));
		log.debug("set data source readKey[" + DB_KEY.get() + "]");
	}

	public void setKey(String key) {
		DB_KEY.set(readDateSourceMap.get(key));
		log.debug("set data source key[" + DB_KEY.get() + "]");
	}

	public String getKey() {
		if (DB_KEY.get() == null) {
			setWriteKey();
		}
		String key = DB_KEY.get();
		log.debug("get data source Key[" + DB_KEY.get() + "]");
		return key;
	}

	private String getRandomKey() {
		return keys[random.nextInt(keys.length)];
	}

	public void clearKey() {
		DB_KEY.remove();
	}
}
