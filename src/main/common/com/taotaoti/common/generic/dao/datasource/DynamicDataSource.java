package com.taotaoti.common.generic.dao.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 取得数据源的KEY
 * 
 * @author liulxiang 
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
	private static final Logger log = LoggerFactory.getLogger(DynamicDataSource.class);
	/**
	 * 数据源key的存储控制器
	 */
	private DynamicDataSourceKey dataSourceKey;

	/**
	 * 获得数据源的key
	 */
	@Override
	protected Object determineCurrentLookupKey() {
		String key = "";
		try {
			key = dataSourceKey.getKey();
			log.info("dataSourcekey="+key);
		} catch (Throwable e) {
			log.error("get data source key fail,will use default data source");
		}
		return key;
	}

	public DynamicDataSourceKey getDataSourceKey() {
		return dataSourceKey;
	}

	public void setDataSourceKey(DynamicDataSourceKey dataSourceKey) {
		this.dataSourceKey = dataSourceKey;
	}
}
