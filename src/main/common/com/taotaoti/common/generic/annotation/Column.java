package com.taotaoti.common.generic.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 标记其对应的数据库字段信息的annotation
 * 
 */
@Retention(RetentionPolicy.RUNTIME) 
public @interface Column {

	/**
	 * 字段名
	 * @return
	 */
	String value();

	/**
	 * 是否需要update
	 * @return
	 */
	boolean maybeModified() default true;
}
