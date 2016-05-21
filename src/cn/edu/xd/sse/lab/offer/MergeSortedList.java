package cn.edu.xd.sse.lab.offer;

/**
 * @author zhiyong wang
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。 
 */
public class MergeSortedList {

	/**
	 * 通过递归的方式来合并两个排序的链表
	 * @param list1
	 * @param list2
	 * @return
	 */
	public ListNode merge(ListNode list1, ListNode list2){
		if(list1 == null)
			return list2;
		if(list2 == null)
			return list1;
		ListNode head;
		if(list1.val < list2.val){
			head = list1;
			head.next = merge(list1.next, list2);
		}else{
			head = list2;
			head.next = merge(list1,list2.next);
		}
		return head;
	}

	private class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
}
