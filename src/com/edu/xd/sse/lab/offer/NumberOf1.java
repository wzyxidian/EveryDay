package com.edu.xd.sse.lab.offer;

/**
 * @author zhiyong wang
 *
 * 题目描述
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * 
 */
public class NumberOf1 {

	/**
	 * 这个题注意一点：循环条件是n！＝0, 因为n可能是负数，不能用n<0来进行判断
	 * @param n
	 * @return
	 */
	public int numberOf1(int n){
		int count = 0;
		while(n != 0){
			++count;
			n = n & (n - 1);
		}
		return count;
	}
}
