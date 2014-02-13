package com.taotaoti.common.generic.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 配置Sequence的annotation
 */
@Retention(RetentionPolicy.RUNTIME) 
public @interface Sequence {

	/**
	 * sequence的名字
	 * @return
	 */
	String name();
	
	/**
	 * 该Sequence每次缓存多少个ID
	 * @return
	 */
	int size() default 1000;
}
