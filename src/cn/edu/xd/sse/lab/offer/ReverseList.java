package cn.edu.xd.sse.lab.offer;

/**
 * @author zhiyong wang
 * 翻转链表 ，得到翻转链表的头结点
 */
public class ReverseList {

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
				nextNode = pre;
				pre = phead;
				phead = phead.next;
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
