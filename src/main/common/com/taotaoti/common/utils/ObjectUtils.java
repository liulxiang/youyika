package com.taotaoti.common.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.taotaoti.common.commons.BaseObject;

/**
 * 对BaseObject的utils方法集合
 */
public class ObjectUtils {
	
	/**
	 * 提取实体集合的id作为一个列表,null值抛弃掉
	 * @param es
	 * @return
	 */
	public final static <K extends Serializable, E extends BaseObject<K>> List<K> extractIdList(Collection<E> es){
		if(isEmpty(es)){
			return new ArrayList<K>(0);
		}
		
		List<K> keys = new ArrayList<K>(es.size());
		for(E e : es){
			if(e == null || e.getId() == null){
				continue;
			}
			keys.add(e.getId());
		}
		return keys;
	}
	
	/**
	 * 提取实体集合的id作为一个列表,null值抛弃掉
	 * @param es
	 * @return
	 */
	public final static <K extends Serializable, E extends BaseObject<K>> Set<K> extractIdSet(Collection<E> es){
		if(isEmpty(es)){
			return new HashSet<K>(0);
		}
		
		HashSet<K> keys = new HashSet<K>(es.size());
		for(E e : es){
			if(e == null || e.getId() == null){
				continue;
			}
			keys.add(e.getId());
		}
		return keys;
	}
	
	
	/**
	 * 提取实体集合的集合转化成一个map。id为每个对象的key，value为对象本身。
	 * @param es
	 * @return
	 */
	public final static <K extends Serializable, E extends BaseObject<K>> Map<K, E> trans2Map(Collection<E> es){
		if(isEmpty(es)){
			return new HashMap<K, E>(0);
		}
		
		HashMap<K, E> map = new HashMap<K, E>(es.size() * 2);
		for(E e : es){
			if(e == null || e.getId() == null){
				continue;
			}
			map.put(e.getId(), e);
		}
		return map;
	}
	
	/**
	 * 判断一个集合是否为空
	 * @param coll
	 * @return
	 */
	public final static boolean isEmpty(Collection<?> coll){
		return coll == null || coll.size() == 0;
	}
}
