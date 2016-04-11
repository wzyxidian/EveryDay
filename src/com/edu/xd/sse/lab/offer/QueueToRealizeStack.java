package com.edu.xd.sse.lab.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhiyong wang
 * 用两个队列来实现一个栈
 */
public class QueueToRealizeStack {

	Queue queue1 = new LinkedList();
	Queue queue2 = new LinkedList();
	
	/**
	 * 添加元素的时候向不为空的队列中添加元素
	 * @param node
	 */
	public void push(int node){
		if(queue2.isEmpty())
			queue1.add(node);
		if(queue1.isEmpty())
			queue2.add(node);
	}
	
	/**
	 * 删除元素的时候先将不为空的队列的前n-1个元素添加到另外一个队列中，然后将第n个元素删除
	 * @return
	 */
	public int poll(){
		int temp = -1;
		if(!queue2.isEmpty()){
			while(!queue2.isEmpty()){
				temp = (int) queue2.poll();
				if(!queue2.isEmpty())
					queue1.add(temp);
			}
			return temp;
		}else if(!queue1.isEmpty()){
			while(!queue1.isEmpty()){
				temp = (int) queue1.poll();
				if(!queue1.isEmpty())
					queue2.add(temp);
			}
			return temp;
		}else
			return -1;
	}
	
	/**
	 * 测试用例
	 * @param args
	 */
	public static void main(String[] args) {
		QueueToRealizeStack qs = new QueueToRealizeStack();
//		qs.push(1);
//		qs.push(2);
//		qs.push(4);
		System.out.println(qs.poll());
		System.out.println(qs.poll());
		System.out.println(qs.poll());
	}
}
