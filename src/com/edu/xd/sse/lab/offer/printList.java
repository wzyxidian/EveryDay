package com.edu.xd.sse.lab.offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author zhiyong wang
 *题目描述
 *输入一个链表，从尾到头打印链表每个节点的值。
 */
public class printList {
	
	private class ListNode{
		int val;
		ListNode next = null;
		ListNode(int val){
			this.val = val;
		}
	}
	/**
	 * 用栈实现，非递归方式
	 * @param listNode
	 * @return
	 */
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
		Stack stack = new Stack();
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(listNode != null){
			stack.push(listNode);
			listNode = listNode.next;
		}
		while(!stack.isEmpty()){
			listNode = (ListNode) stack.pop();
			list.add(listNode.val);
		}
		return list;
	}
	
	/**
	 * 递归方式实现
	 * @param listNode
	 * @return
	 */
	public ArrayList<Integer> printListFromTailToHead1(ListNode listNode){
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(listNode != null){
			if(listNode.next != null){
				list.addAll(printListFromTailToHead(listNode.next));
			}
			list.add(listNode.val);
		}
		
		return list;
	}
}

