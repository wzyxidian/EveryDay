package com.edu.xd.sse.lab.others;

import java.util.Stack;


/**
 * @author zhiyong wang
 *
 */
public class Minus {

	public static void main(String[] args) {
		Minus minus = new Minus();
		int[] arrA = {3, 5, 6, 7};
		int[] arrB = {1, 2, 3, 4};
		Node a = minus.new Node((char) (arrA[0] + '0'));
		Node b = minus.new Node((char) (arrB[0] + '0'));
		Node current1 = a;
		Node current2 = b;
		int i = 1;

		while (i < arrA.length) {
			current1.next = minus.new Node((char) (arrA[i] + '0'));
			current1 = current1.next;
			i++;
		}
		i = 1;
		while (i < arrB.length) {
			current2.next = minus.new Node((char) (arrB[i] + '0'));
			current2 = current2.next;
			i++;
		}
		minus.minus(a, b);
	}
	
	Node minus(Node a, Node b){
		/**
		 * 因为是高位在前，地位在后，而减法是先低位后高位，所以先将两个链表的值分别存放到两个栈中
		 * 新建一个栈用来存放最后的结果
		 */
		Stack stack1 = new Stack();
		Stack stack2 = new Stack();
		Stack stack = new Stack();
		
		Node currentA = a;
		Node currentB = b;
		while(currentA != null){
			stack1.push(currentA.data);
			currentA = currentA.next;
		}
		while(currentB != null){
			stack2.push(currentB.data);
			currentB = currentB.next;
		}
		
		/**
		 * 分别得到减数与被减数的长度
		 */
		int len1 = stack1.size();
		int len2 = stack2.size();
		
		/**
		 * 如果被减数长度大于减数长度时
		 */
		if(len1 > len2){
			stack = getResult(stack1,stack2,stack);	
		}else if(len1 == len2){//被减数长度等于减数长度
			if(a.data >= b.data)
				stack = getResult(stack1,stack2,stack);
			else {
				stack = getResult(stack2,stack1,stack);	
				stack.push(-1);
			}
				
		}else{//被减数长度小于减数长度
			stack = getResult(stack2,stack1,stack);
			stack.push(-1);
		}
		//根据stack来构造返回结果的链表
		Node head = null;
		Node current = null;
		while((int)stack.peek() == 0){
			stack.pop();
		}
		if((int)stack.peek() == -1){
			stack.pop();
			head = new Node('-'); 
			current = head;
		}else{
			char data = (char)((int)stack.pop() + '0');
			head = new Node(data);
			current = head;
		}
		while(!stack.isEmpty()){
			char data = (char)((int)stack.pop() + '0');
			current.next = new Node(data);
			current = current.next;
		}
		return head;	
	}
	
	private Stack getResult(Stack stack1, Stack stack2, Stack stack){
		int i = 0;
		int flag = 0;
		int mid = 0;
		//先计算相同长度部分
		while(!stack2.isEmpty()){
			int minu = (char)stack1.pop() - '0';
			int sub = (char) stack2.pop() - '0';
			if(minu + flag >= sub){
				mid = minu + flag - sub;
				flag = 0;
				stack.push(mid);
			}else{
				mid = minu + flag + 10 - sub;
				flag = -1;
				stack.push(mid);
			}
		}
		//计算多出来的部分			
		if(flag == 0){
			while(!stack1.isEmpty())
				stack.push((char) stack1.pop() - '0');
		}else{
			while(!stack1.isEmpty()){
				if((char)stack1.pop()-'0' + flag == -1){
					stack.push((char) stack1.pop() - '0' + 10);
					flag = -1;
				}else{
					stack.push((char) stack1.pop() + flag - '0');
					flag = 0;
				}
			}
			
		}
		return stack;
	}

	//根节点
	class Node {
		char data;
		Node next;

		Node(char data) {
			this.data = data;
		}
	}
	
	
}
