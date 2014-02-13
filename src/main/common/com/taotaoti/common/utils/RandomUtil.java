package com.taotaoti.common.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 
 * 随机数工具类
 *
 */
public class RandomUtil {
	
	public static List<Integer> randomSerial(int limit) {
		List<Integer> list = new ArrayList<Integer>(limit);
	    
	    for (int ix = 0; ix < limit; ++ix){
	        list.add(ix);
	    }
	    
	    Collections.shuffle(list, new Random());
		return list;
	}

	
	public static void main(String[] args) {
		List<Integer> a = RandomUtil.randomSerial(2);
		for (int i : a) {
			System.out.println(i);
		}
	}

}
