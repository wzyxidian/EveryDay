package cn.edu.xd.sse.lab.offer;

import cn.edu.xd.sse.lab.offer.FindKthToTail.ListNode;

/**
 * @author zhiyong wang
 * 题目：两个链表的第一个公共结点
 * 题目描述：输入两个链表，找出它们的第一个公共结点。
 */
public class FindFirstCommonNode {

	/**
	 * 先求出两个链表的长度差len，然后让长的链表先走len步，接下来判断是否有重合发生
	 * @param pHead1
	 * @param pHead2
	 * @return
	 */
	public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2){
		if(pHead1 == null || pHead2 == null)
			return null;
		int count1 = 0;
		int count2 = 0;
		ListNode first = pHead1;
		ListNode second = pHead2;
		while(first != null){
			++count1;
			first = first.next;
		}
		while(second != null){
			++count2;
			second = second.next;
		}
		
		int len = count1 - count2;
		
		if(len > 0){
			int i = 0;
			while(i < len){
				pHead1 = pHead1.next;
				i++;
			}
			while(pHead1 != pHead2){
				pHead1 = pHead1.next;
				pHead2 = pHead2.next;				
			}
			return pHead1;
		}else{
			len = Math.abs(len);
			int i = 0;
			while(i < len){
				pHead2 = pHead2.next;
				i++;
			}
			while(pHead1 != pHead2){
				pHead1 = pHead1.next;
				pHead2 = pHead2.next;				
			}
			return pHead1;
		}
	}
	
}
