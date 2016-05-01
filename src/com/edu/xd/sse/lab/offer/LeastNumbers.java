package com.edu.xd.sse.lab.offer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * @author zhiyong wang
 * 题目：最小的K个数
 * 题目描述：输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。 
 * 
 * 思路：用快排的求partition的思想，要么用大顶堆实现
 */
public class LeastNumbers {

	/**
	 * 方法一：利用partition的方法，求得第k个数，那么k前面的数都是小于k的数字
	 * 注意partition方法里面start 与 end的定义，全程用这两个变量
	 * 注意判断条件：一定要对k进行判断：是否小于等于0，是否个数超过了数组的长度
	 * @param input
	 * @param k
	 * @return
	 */
	public ArrayList<Integer> getLeastNumbers_Solution(int[] input, int k){
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(input == null || input.length == 0 || k <= 0 || k > input.length)
			return list;
		int start = 0;
		int end = input.length - 1;
		int index = partition(input, start, end);
		while(index != k-1){
			if(index < k-1){
				start = index + 1;
				index = partition(input,start, end);
			}else if(index > k -1){
				end = index - 1;
				index = partition(input, start, end);				
			}				
		}
		for(int i = 0; i < k; i++){
			list.add(input[i]);
		}
		return list;
	}
	
	/**
	 * 快排里面的partition方法，注意内部循环加上start < end 判断条件
	 * @param input
	 * @param start
	 * @param end
	 * @return
	 */
	private int partition(int[] input, int start , int end){
		int compare = input[end];
		while(start < end){
			while(input[start] <= compare && start < end)
				start++;
			swap(input, start, end);
			while(input[end] > compare && start < end)
				end--;
			swap(input, start, end);
		}
		return start;
	}
	
	/**
	 * 数组内的两个数进行交换
	 * @param input
	 * @param start
	 * @param end
	 */
	private void swap(int[] input, int start, int end){
		int temp = input[start];
		input[start] = input[end];
		input[end] = temp;
	}
	
}
