package com.edu.xd.sse.lab.offer;


/**
 * @author zhiyong wang
 * 题目：复杂链表的复制
 * 题目描述：输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）。 
 */
public class CompexClone {
	public RandomListNode clone(RandomListNode pHead){
		if(pHead == null)
            return null;
        else{
            cloneNodes(pHead);
            connectSiblingNodes(pHead);
            return reConnectNodes(pHead);
        }
       
    }

	/**
	 * 复制每个节点，将新复制节点作为原来节点的下一个节点
	 * @param pHead
	 */
	 private void cloneNodes(RandomListNode pHead){
	        RandomListNode pNode = pHead;
	        while(pNode != null){
	            RandomListNode pCloneNode = new RandomListNode(pNode.label);
	            pCloneNode.next = pNode.next;
	            pCloneNode.random = null;
	            pNode = pCloneNode.next;
	        }
	    }
    
	 /**
	  * 为每个新节点的random来进行设置
	  * @param pHead
	  */
    private void connectSiblingNodes(RandomListNode pHead){
    	 RandomListNode pNode = pHead;
         while(pNode != null){
             RandomListNode pCloneNode = pNode.next;
             if(pNode.random != null){
                 pCloneNode.random = pNode.random.next;
                 pNode = pCloneNode.next;
             }
         }
    }
    
    /**
     * 将链表拆分成两个链表
     * @param pHead
     * @return
     */
    private RandomListNode reConnectNodes(RandomListNode pHead){
    	 RandomListNode pNode = pHead;
         RandomListNode pCloneHead = pNode.next;
         RandomListNode pCloneNode = pCloneHead;
         pNode.next = pCloneNode.next;
         pNode = pNode.next;
         while(pNode != null){
             pCloneNode.next = pNode.next;
             pCloneNode = pCloneNode.next;
             pNode.next = pCloneNode.next;
             pNode = pNode.next;
         }
         return pCloneHead;
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}