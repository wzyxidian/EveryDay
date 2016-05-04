package com.edu.xd.sse.lab.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author zhiyong wang
 * 题目：把数组排成最小的数
 * 题目描述：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。 
 */
public class PrintMinNumber {

	/**
	 *这里的排序使用了集合类的排序方法，不过重写了原来的排序规则，
	 *使之满足现在的排序规则
	 * @param numbers
	 * @return
	 */
	public String printMinNumber(int[] numbers){
		if(numbers == null || numbers.length == 0)
			return null;
		int len = numbers.length;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < len; ++i)
			list.add(numbers[i]);
		//重写排序规则
		Collections.sort(list,new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				String s1 = o1 + "" + o2;
				String s2 = o2 + "" + o1;				
				return s1.compareTo(s2);
			}			
		});
		String s = "";
		for(int j = 0; j < len; ++j)
			s += list.get(j);
		return s;
	}
}
