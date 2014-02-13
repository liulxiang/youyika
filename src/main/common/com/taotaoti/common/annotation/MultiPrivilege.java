package com.taotaoti.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target(value={ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MultiPrivilege {

	/**
	 * 鏉冮檺tag,鍙厤缃涓潈闄愶紝鐢ㄤ簬妯″潡澶嶇敤
	 * @return
	 */
	public String[] value();
}
