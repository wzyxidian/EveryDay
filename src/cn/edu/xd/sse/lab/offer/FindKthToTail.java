package cn.edu.xd.sse.lab.offer;

/**
 * @author zhiyong wang
 *
 */
public class FindKthToTail {
	/**
	 * 定义两个指针，使两个指针之间的距离为k-1，这样前面的指针到最后一个位置的时候，后面的指针刚好走到倒数第k个位置
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode findKthToTail(ListNode head, int k){
		if(head == null || k <= 0)
			return null;
		ListNode first = head;
		ListNode second = head;
		for(int i = 0;i < k - 1;i++){//注意这个地方是小于k-1，这样两个指针的差距才刚好是k-1
			if(first == null)
				return null;
			first = first.next;
		}
		if(first == null) return null;//注意这一行要判断第k个点是否为空，然后才能判断他的下一个点
		while(first.next != null){//注意这个地方要判断的是下一个点，不能会多走一步
			first = first.next;
			second = second.next;
		}
		return second;
	}

	class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
}

