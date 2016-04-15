package com.edu.xd.sse.lab.offer;

/**
 * @author zhiyong wang
 *
 * 题目描述
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 
 */
public class RectCover {

	/**
	 * 用递归实现f(n) = f(n-1) +　f(n-2)
	 * @param target
	 * @return
	 */
	public int rectCover(int target){
		if(target == 0)
			return 1;
		if(target == 1)
			return 1;
		return rectCover(target - 1) + rectCover(target - 2);
	}
	
	/**
	 * 用循环方式实现
	 * @param target
	 * @return
	 */
	public int rectCovers(int target){
		int small = 1;
		int big = 1;
		int result = 0;
		if(target < 2)
			return 1;
		for(int i = 2; i <= target; i++){
				result = small + big;
				small = big;
				big = result;
		}
		return result;
	}
}
