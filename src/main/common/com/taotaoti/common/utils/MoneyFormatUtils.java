/**
 * 
 */
package com.taotaoti.common.utils;

import java.text.DecimalFormat;

/**
 * @author zengyunfeng
 * @version 1.0.0
 *
 */
public class MoneyFormatUtils {

	public final static String DEFAULT_MAONEY_FORMATTER  ="###,##0.00";
	
	public final static String DEFAULT_PERCENT_FORMATTER  ="#.00";


	/**
	 * 
	 * @author zengyunfeng
	 * @param formatter
	 * @param money
	 * @return
	 */
	public static String format(String formatter, double money){
		DecimalFormat format = (DecimalFormat)DecimalFormat.getInstance();
		format.setGroupingSize(3);
		format.setMaximumFractionDigits(2);
		return String.format(formatter, format.format(money));
	}
	
	public static String newformat(String formatter, double money){
		DecimalFormat newformat = (DecimalFormat)DecimalFormat.getInstance();
		newformat.setGroupingUsed(false);
		newformat.setMaximumFractionDigits(2);
		newformat.setMinimumFractionDigits(2);
		return String.format(formatter, newformat.format(money));
	}
	
	public static String percentformat(String formatter, double number){
		DecimalFormat nf = new DecimalFormat(formatter);
		return nf.format(number);
	}
}
