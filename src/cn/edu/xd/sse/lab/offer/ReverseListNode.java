package cn.edu.xd.sse.lab.offer;

import java.util.Stack;

/**
 * @author zhiyong wang
 * 翻转链表 ，得到翻转链表的头结点
 */
public class ReverseListNode {
	/**
	 * 用栈实现反向输出链表
	 * @param head
	 * @return
	 */
	public ListNode reverseNode(ListNode head){
		if(head == null || head.next == null)
			return head;
		Stack stack = new Stack();
		//用栈把所有的元素都按序存储
		while(head != null){
			stack.push(head);
			head = head.next;
		}
		//得到反向后的头结点
		ListNode reverseHead = (ListNode) stack.pop();
		//将头结点赋值给一个用来遍历的节点
		ListNode pnode = reverseHead;
		while(!stack.isEmpty()){
			pnode.next = (ListNode) stack.pop();
			pnode = pnode.next;
		}
		//遍历完节点之后，最后一个节点的下一个节点要进行赋值为null
		pnode.next = null;
		return reverseHead;
	}
	
	/**
	 * 用三个指针实现
	 * @param head
	 * @return
	 */
	public ListNode reverseList(ListNode head){
		if(head == null || head.next == null)
			return head;
		ListNode reverseHead = null;
		ListNode phead = head;
		ListNode pre = null;
		while(phead != null){
				ListNode nextNode = phead.next;
				if(nextNode == null)
					reverseHead = phead;
				phead.next = pre;
				pre = phead;
				phead = nextNode;
		}
			return reverseHead;
	}

	private class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
}
