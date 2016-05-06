package com.edu.xd.sse.lab.offer;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author zhiyong wang
 * 题目：第一个只出现一次的字符位置
 * 题目描述：在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符的位置。
 * 若为空串，返回-1。位置索引从0开始 ，注意这个题要求返回的是字符下标
 */
public class FristNotRepeatingChar {

	/**
	 * 这里要求返回的是第一个出现一次的下标，所以要求是有序的，这里通过LinkedHashMap实现了有序，同时
	 * 也将每个字符及字符出现的次数存起来了
	 * 上面的过程是第一次遍历字符串
	 * 第二次是遍历map，找到第一个value为1的key，
	 * 第三次遍历字符串，找到这个key对应的下标并返回
	 * @param str
	 * @return
	 */
	public int firstNotRepeatingChar(String str){
		LinkedHashMap map = new LinkedHashMap();
		if(str == null || str.length() == 0)
			return -1;
		char[] chars = str.toCharArray();
		int len = chars.length;
		for(int i = 0; i < len; ++i){
			if(map.containsKey(chars[i]))
				map.put(chars[i], (int)map.get(chars[i]) + 1);
			else
				map.put(chars[i], 1);
		}
		
		char result = 0;
		Iterator iter = map.entrySet().iterator();
		while(iter.hasNext()){
			Map.Entry entry = (Entry) iter.next();			
			if((int)map.get((char) entry.getKey()) == 1){
				result = (char) entry.getKey();
				break;
			}
				
		}

		for(int i = 0; i < len; ++i)
			if(chars[i] == result)
				return i;
		return -1;
	}

}
