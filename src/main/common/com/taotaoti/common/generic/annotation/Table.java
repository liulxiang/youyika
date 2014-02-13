package com.taotaoti.common.generic.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 表示主键名的注释
 * 
 */
@Retention(RetentionPolicy.RUNTIME) 
public @interface Table {

	/**
	 * 在哪个DB中
	 * @return
	 */
	String db();
	
	/**
	 * 表名
	 * @return
	 */
	String name();
	
	/**
	 * 该表做了多少个切片拆分
	 * @return
	 */
	int shardCount() default 0;
	
	/**
	 * 主键字段的名字
	 * @return
	 */
	String keyColumn();
}
