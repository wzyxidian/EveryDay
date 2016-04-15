package com.edu.xd.sse.lab.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhiyong wang
 *
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 
 */
public class ReOrderArrayNoChange {
		Queue queue = new LinkedList();
		
		/**
		 * 这里为了使时间复杂度为O(n)引入了一个队列，用队列来存放偶数
		 * 过程是这样子的：遇到偶数就存放到队列中，并统计当前遇到的偶数的个数j
		 * 			       遇到奇数，就将其向前移动j个单位然后进行赋值
		 * 这样借助队列，空间复杂度增加为O(n)，但是只有赋值的过程，减少了交换的过程，用空间来换取时间
		 * @param array
		 */
		public void reOrderArray(int[] array){
			if(array == null || array.length == 0 || array.length == 1)
				return ;
			int i = 0;
			int j = 0;
			int len = array.length;
			while(i < len){
				if((array[i] & 1) == 0){
					queue.add(array[i]);
					++j;
				}					
				else{
					array[i -  j] = array[i];
				}
				i++;
				
			}
			i = len - j;
			while(!queue.isEmpty()){
				array[i++] = (int) queue.poll();
			}
		}
}
