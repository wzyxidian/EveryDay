package cn.edu.xd.sse.lab.offer;

import java.util.Stack;

/**
 * @author zhiyong wang
 * 
 * 题目描述
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * 思路：用栈1负责来添加操作，用栈2来实现弹出操作；如果栈2里面有元素，直接弹出，没有元素，判断栈1，栈1没有元素，返回错误；栈1有元素，
 * 		则将栈1里面的元素都弹到栈2，然后从栈2中弹出元素
 */
public class StackToRealizeQueue {
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();
	/**
	 * 每次添加都往栈1里面添加
	 * @param node 待插入队列中元素
	 */
	public void push(int node){
		stack1.push(node);
	}
	
	/**
	 * 每次弹出都从栈2里面弹出
	 * @return
	 */
	public int pop(){
		if(!stack2.isEmpty())
			return stack2.pop();
		if(stack1.isEmpty())
			return -1;
		else{
			while(!stack1.isEmpty())
				stack2.push(stack1.pop());
			return stack2.pop();
		}
	}
}
