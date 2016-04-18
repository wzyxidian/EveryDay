package com.edu.xd.sse.lab.offer;

import java.util.Stack;

/**
 * @author zhiyong wang
 * 题目：包含min函数的栈
 * 题目描述：
 * 	定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。 
 */
public class MinStack {
		
		Stack stack = new Stack();     //定义用来存储数据的栈
	    Stack minStack = new Stack();  //定义用来存储最小数据的栈
	    
	    /**
	     * 添加数据，首先是往stack栈中添加
	     * 如果最小栈minStack为空，或者栈顶的元素比新添加的元素要大，则将新元素也要添加的辅助栈中
	     * @param node
	     */
	    public void push(int node) {
	        stack.push(node);
	        if(minStack.isEmpty() || ((int)minStack.peek()) >= node){
	        	minStack.push(node);
	        }
	    }
	    
	    /**
	     * 如果stack空，直接返回
	     * 如果stack不为空，得到栈顶元素，同时将栈顶元素弹出
	     * 如果最小栈的栈顶元素与stack弹出的元素相等，那么最小栈也要将其弹出
	     */
	    public void pop() {
	        if(stack.isEmpty())
	            return;
	        int node = (int)stack.peek();
	        stack.pop();
	        if((int)minStack.peek() == node){
	            minStack.pop();
	        }
	    }
	    
	    /**
	     * 查看栈顶元素
	     * @return
	     */
	    public int top() {
	        return (int)stack.peek();
	    }
	    
	    /**
	     * 查看栈的最小元素
	     * @return
	     */
	    public int min() {
	        return (int)minStack.peek();
	    }
}
