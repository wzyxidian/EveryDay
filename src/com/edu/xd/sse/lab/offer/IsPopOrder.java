package com.edu.xd.sse.lab.offer;

import java.util.Stack;

/**
 * @author zhiyong wang
 * 题目：栈的压入、弹出序列
 * 内容：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 	       假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 	       序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。 
 */
public class IsPopOrder {
	
	/**
	 * 首先将特殊情况，边界情况进行排除掉
	 * 然后定义一个循环，开始遍历第一个数组，将遍历的每个对象往stack里面添加，
	 * 如果遇到栈不为空且stack顶元素与第二个数组对应位置相等的情况，就弹栈，
	 * 同时第二个数组指针后移
	 * 最后判断栈是否为空
	 * @param pushA 入栈队列
	 * @param popA  出栈队列
	 * @return
	 */
	public boolean isPopOrder(int[] pushA, int[] popA){
		if(pushA == null || popA == null || pushA.length == 0 || popA.length == 0 || pushA.length != popA.length)
			return false;
		if(pushA.length == popA.length)
			return pushA[0] == popA[0];
		Stack stack = new Stack();
		int i = 0;
		int j = 0;
		int len = pushA.length;
		while(i < len && j < len){
			stack.push(pushA[i]);
			++i;
			while(!stack.isEmpty() && (int)stack.peek() == popA[j]) {
				stack.pop();
				++j;
			}
		}
		return stack.isEmpty();
	}
}
