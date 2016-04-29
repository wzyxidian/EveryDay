package com.edu.xd.sse.lab.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhiyong wang
 * 题目：向对面和相等
 * 题目描述：输入一个含有8个数字的数组，判断有没有可能把这8个数字分别放在正方体的8个顶点上，
 * 		   使得正方体上三组相对的面上的四个顶点的和都相等。
 */
public class SumEqual {

	/**
	 * 思路：本质上是一个数组排序问题，将一个数组中所有的数字进行全排列，然后选出符合条件的数组
	 * @param s 输入最开始的数组
	 * @return
	 */
	public ArrayList<int[]> sumEquals(int[] s){
		ArrayList<int[]> list = new ArrayList<int[]>();
		Set set = new HashSet();
		if(s == null || s.length == 0)
			return list;
		int length = s.length;
		int[] result = new int[8];
		sort(s,0,length,set);
		list.addAll(set);
//		for(int i=0;i<list.size();i++){
//			System.out.println(list.get(i)[0] + " " + list.get(i)[1] + " " + list.get(i)[2] + " " + list.get(i)[3] + " " + list.get(i)[4] + " " + list.get(i)[5] + " " + list.get(i)[6] + " " + list.get(i)[7]);
//			
//		}
		return list;	
	}
	
	/**
	 * 思路：如果遍历到最后一位且满足条件，新建一个数组，将符合条件的数组赋值给新数组，然后存放到结果集
	 * 	   遍历的过程是：第一次遍历的一位固定，然后求后面的所有位的全排序；然后第一位和后面的每一位分别进行交换，并对后面的全排列
	 * @param s       原始数组
	 * @param index   下一个要遍历的下标
	 * @param length  数组的长度
	 * @param set     结果集
	 */
	public void sort(int[] s, int index, int length, Set set){
		if(index == length && satify(s)){
			int[] result = new int[8];
			System.arraycopy(s, 0, result, 0, length);
			set.add(result);
		}else{
			int temp;
			for(int i = index; i < length; i++){
				temp = s[index];
				s[index] = s[i];
				s[i] = temp;
				
				sort(s, index + 1, length, set);
				
				temp = s[index];
				s[index] = s[i];
				s[i] = temp;
			}
		}
		
	}
	
	public boolean satify(int[] result){
		if(result[0] + result[1] + result[2] + result[3] == result[4] + result[5] + result[6] + result[7])
			if(result[0] + result[2] + result[4] + result[6] == result[1] + result[3] + result[5] + result[7])
				if(result[0] + result[1] + result[4] + result[5] == result[2] + result[3] + result[6] + result[7])
					return true;
		return false;
	}
	
	public static void main(String[] args) {
		SumEqual s = new SumEqual();
		s.sumEquals(new int[]{1,2,3,4,5,6,7,8});
	}
}
