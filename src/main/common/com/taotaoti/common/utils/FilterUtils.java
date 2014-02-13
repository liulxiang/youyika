/**
 * 
 */
package com.taotaoti.common.utils;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

/**
 * 设置过滤条件使用的类，提供向一个参数列表设置参数，和向过滤查询语句增加where条件
 * 
 * @author zengyunfeng
 * @version 1.0.0
 * 
 */
public class FilterUtils {

	/**
	 * 根据parameter是否大于等于0，判断是否存放过滤参数列表
	 * 
	 * @param list
	 *            返回的过滤参数列表
	 * @param parameter
	 *            参数值
	 * @return 是否需要存入过滤参数列表
	 */
	public static boolean addIntParameter(List<Object> list, int parameter) {
		if (parameter < 0) {
			return false;
		}
		list.add(Integer.valueOf(parameter));
		return true;
	}

	/**
	 * 根据parameter是否为空字符串，判断是否存放过滤参数列表
	 * 
	 * @param list
	 *            返回的过滤参数列表
	 * @param parameter
	 *            参数值
	 * @return 是否需要存入过滤参数列表
	 */
	public static boolean addStringEqualParameter(List<Object> list,
			String parameter) {
		if (StringUtils.isEmpty(parameter)) {
			return false;
		}
		list.add(parameter);
		return true;
	}

	/**
	 * 根据parameter是否为空字符串，判断是否存放过滤参数列表，该类参数为模糊，在参数前后加入%
	 * 
	 * @param list
	 *            返回的过滤参数列表
	 * @param parameter
	 *            参数值
	 * @return 是否需要存入过滤参数列表
	 */
	public static boolean addStringLikeParameter(List<Object> list,
			String parameter) {
		if (StringUtils.isEmpty(parameter)) {
			return false;
		}
		list.add("%" + transferSpecialInSql(parameter) + "%");
		return true;
	}

	public static String transferSpecialInSql(final String input) {
		if (input == null) {
			return null;
		}
		// 特殊字符进行字符转义
		String param = input.replace("\\", "\\\\");
		// 注意不可以调换顺序
		param = param.replace("%", "\\%");
		param = param.replace("_", "\\_");
		return param;
	}

	/**
	 * 根据参数是否大于等于0，判断是否加入过滤条件
	 * 
	 * @param condition
	 *            返回的过滤条件字符串
	 * @param condPre
	 *            加入的条件
	 * @param parameter
	 * @return
	 */
	public static boolean addIntCondition(StringBuilder condition,
			String condPre, int parameter) {
		if (parameter < 0) {
			return false;
		}
		condition.append(" AND ").append(condPre);
		return true;
	}

	/**
	 * 根据参数是否为空，判断是否加入过滤条件
	 * 
	 * @param condition
	 *            返回的过滤条件字符串
	 * @param condPre
	 *            加入的条件
	 * @param parameter
	 * @return
	 */
	public static boolean addStringCondition(StringBuilder condition,
			String condPre, String parameter) {
		if (StringUtils.isEmpty(parameter)) {
			return false;
		}
		condition.append(" AND ").append(condPre);
		return true;
	}

	/**
	 * 根据parameter是否大于等于0，判断是否存放过滤参数列表
	 * 
	 * @param list
	 *            返回的过滤参数列表
	 * @param parameter
	 *            参数值
	 * @return 是否需要存入过滤参数列表
	 */
	public static boolean addIntParameter(List<Object> list, int index,
			int parameter) {
		if (parameter < 0) {
			return false;
		}
		list.add(index, Integer.valueOf(parameter));
		return true;
	}

	/**
	 * 根据parameter是否为空字符串，判断是否存放过滤参数列表
	 * 
	 * @param list
	 *            返回的过滤参数列表
	 * @param parameter
	 *            参数值
	 * @return 是否需要存入过滤参数列表
	 */
	public static boolean addStringEqualParameter(List<Object> list, int index,
			String parameter) {
		if (StringUtils.isEmpty(parameter)) {
			return false;
		}
		list.add(index, parameter);
		return true;
	}

	/**
	 * 根据parameter是否为空字符串，判断是否存放过滤参数列表，该类参数为模糊，在参数前后加入%
	 * 
	 * @param list
	 *            返回的过滤参数列表
	 * @param parameter
	 *            参数值
	 * @return 是否需要存入过滤参数列表
	 */
	public static boolean addStringLikeParameter(List<Object> list, int index,
			String parameter) {
		if (StringUtils.isEmpty(parameter)) {
			return false;
		}
		list.add(index, "%" + transferSpecialInSql(parameter) + "%");
		return true;
	}

	/**
	 * 根据List内非空参数的个数，加入过滤条件
	 * 
	 * @author zengyunfeng
	 * @version 1.1.0
	 * @param condition
	 * @param condPre
	 * @param userShifenState
	 * @return
	 */
	public static <E> boolean addListANDCondition(StringBuilder condition,
			String condPre, List<E> parameter) {
		if (CollectionUtils.isEmpty(parameter)) {
			return false;
		}
		boolean result = false;
		for (E st : parameter) {
			if (st != null) {
				condition.append(" AND ").append(condPre);
				result = true;
			}
		}
		return result;
	}

	/**
	 * 根据parameter是否大于等于0，判断是否存放过滤参数列表
	 * 
	 * @param list
	 *            返回的过滤参数列表
	 * @param parameter
	 *            参数值
	 * @return 是否需要存入过滤参数列表
	 */
	public static <E> boolean addListParameter(List<Object> list,
			List<E> parameter) {
		if (CollectionUtils.isEmpty(parameter)) {
			return false;
		}
		boolean result = false;
		for (E param : parameter) {
			if (param != null) {
				list.add(param);
				result = true;
			}
		}
		return result;
	}

	/**
	 * 根据parameter是否大于等于0，判断是否存放过滤参数列表
	 * 
	 * @param list
	 *            返回的过滤参数列表
	 * @param parameter
	 *            参数值
	 * @return 是否需要存入过滤参数列表
	 */
	public static <E> boolean addListParameter(List<Object> list, int index,
			List<E> parameter) {
		if (CollectionUtils.isEmpty(parameter)) {
			return false;
		}
		boolean result = false;
		for (E param : parameter) {
			if (param != null) {
				list.add(index, param);
				index++;
				result = true;
			}
		}
		return result;
	}

	/**
	 * 根据参数是否为null，判断是否加入过滤条件
	 * 
	 * @param condition
	 *            返回的过滤条件字符串
	 * @param condPre
	 *            加入的条件
	 * @param data1
	 *            between条件的前一个值
	 * @param data2
	 *            between条件的后一个值
	 * @return
	 */
	public static boolean addBetweenCondition(StringBuilder condition,
			String condPre, Object data1, Object data2) {
		if (data1 == null || data2 == null) {
			return false;
		}
		condition.append(" AND ").append(condPre);
		return true;
	}

	/**
	 * 根据参数是否为null，判断是否加入过滤参数
	 * 
	 * @param list
	 *            返回的过滤参数列表
	 * @param data1
	 *            between条件的前一个值
	 * @param data2
	 *            between条件的后一个值
	 * @return
	 */
	public static boolean addBetweenParameter(List<Object> list, Object data1,
			Object data2) {
		if (data1 == null || data2 == null) {
			return false;
		}
		list.add(data1);
		list.add(data2);
		return true;
	}

	/**
	 * 根据参数是否为null，判断是否加入过滤参数
	 * 
	 * @param list
	 *            返回的过滤参数列表
	 * @param index
	 *            参数的序号
	 * @param data1
	 *            between条件的前一个值
	 * @param data2
	 *            between条件的后一个值
	 * @return
	 */
	public static boolean addBetweenParameter(List<Object> list, int index,
			Object data1, Object data2) {
		if (data1 == null || data2 == null) {
			return false;
		}
		list.add(index, data1);
		list.add(index + 1, data2);
		return true;
	}

	/**
	 * 根据parameter是否为空字符串，判断是否存放过滤参数列表
	 * 
	 * @param list
	 *            返回的过滤参数列表
	 * @param order
	 *            oder语句
	 * @param parameter
	 *            参数值
	 * @return 是否需要存入过滤参数列表
	 */
	public static boolean addOrderCondition(StringBuilder condition,
			String order, String paramter) {
		if (StringUtils.isEmpty(paramter)) {
			return false;
		}
		condition.append(" ORDER BY ").append(order);
		return true;
	}

	/**
	 * 根据参数是否为null, 判断是否加入hql的位与运算 2009-7-9 add by zengyunfeng
	 * 
	 * @version 1.2.0
	 * @param condition
	 *            返回的过滤条件字符串
	 * @param compare
	 *            位与后的比较符， = != > < >= <=
	 * @param peroperty
	 *            位与的bo的属性名
	 * @param data1
	 *            位与的第二个参数，只能为数值，不能为属性名
	 * @param data2
	 *            比较符的后一个参数，只能为数值，不能为属性名
	 * @return
	 */
	public static boolean addBitAndCondition(StringBuilder condition,
			String compare, String peroperty, Object data1, Object data2) {
		if (data1 == null || data2 == null || compare == null) {
			return false;
		}
		condition.append(" AND bitwise_and(" + peroperty + ", ? ) ").append(
				compare).append(" ? ");
		return true;
	}

	/**
	 * 根据参数是否为null, 判断是否加入过滤参数 2009-7-9 add by zengyunfeng
	 * 
	 * @version 1.2.0
	 * @param list
	 *            返回的过滤参数列表
	 * @param data1
	 *            位与的第二个参数，只能为数值，不能为属性名
	 * @param data2
	 *            比较符的后一个参数，只能为数值，不能为属性名
	 * @return
	 */
	public static boolean addBitAndParameter(List<Object> list, Object data1,
			Object data2) {
		if (data1 == null || data2 == null) {
			return false;
		}
		list.add(data1);
		list.add(data2);
		return true;
	}

	/**
	 * 根据参数是否为null, 判断是否加入过滤参数 2009-7-9 add by zengyunfeng
	 * 
	 * @version 1.2.0
	 * @param list
	 *            返回的过滤参数列表
	 * @param index
	 *            参数的序号
	 * @param data1
	 *            位与的第二个参数，只能为数值，不能为属性名
	 * @param data2
	 *            比较符的后一个参数，只能为数值，不能为属性名
	 * @return
	 */
	public static boolean addBitAndParameter(List<Object> list, int index,
			Object data1, Object data2) {
		if (data1 == null || data2 == null) {
			return false;
		}
		list.add(index, data1);
		list.add(index + 1, data2);
		return true;
	}
	
	/**
	 * 根据params是否为空，判断是否加入过来条件
	 * @version 1.2.0
	 * @author zengyunfeng
	 * @param condition
	 * @param condPre 添加的条件
	 * @param params in的参数
	 * @return
	 */
	public static boolean addInCondition(StringBuilder condition, String condPre, Object[] params){
		if(params==null||params.length==0){
			return false;
		}
		condition.append(" AND ").append(condPre).append(" in (?");
		for(int index=1; index<params.length; index++){
			condition.append(",?");
		}
		condition.append(") ");
		return true;
	}
	
	/**
	 * 根据params是否为空，判断是否加入过滤参数
	 * 
	 * @param list
	 *            返回的过滤参数列表
	 * @param index
	 *            参数的序号
	 * @param params in参数值
	 * @return
	 */
	public static boolean addInParameter(List<Object> list, int index,Object[] params) {
		if(params==null||params.length==0){
			return false;
		}
		for(Object obj : params){
			list.add(index, obj);
			index++;
		}
		return true;
	}
	
	/**
	 * 根据params是否为空，判断是否加入过滤参数
	 * 
	 * @param list
	 *            返回的过滤参数列表
	 * @param params in参数值
	 * @return
	 */
	public static boolean addInParameter(List<Object> list, Object[] params) {
		if(params==null||params.length==0){
			return false;
		}
		for(Object obj : params){
			list.add(obj);
		}
		return true;
	}

	public static void main(String[] args) {
		String input = "\\";
		// 特殊字符进行字符转义
		String param = input.replace("\\", "\\\\");
		System.out.println("input:" + input);
		System.out.println("param:" + param);
		// 注意不可以调换顺序
		param = input.replace("%", "\\%");

		StringBuilder result = new StringBuilder();
//		addBitAndCondition(result, "=", "a.userid", 1, 2);
		addInCondition(result, "a.id", new Object[]{1,2});
		System.out.println(result.toString());
		
		

	}

}
