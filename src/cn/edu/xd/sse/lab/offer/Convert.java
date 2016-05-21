package cn.edu.xd.sse.lab.offer;

import java.util.Stack;

/**
 * @author zhiyong wang
 * 题目：二叉搜索树与双向链表
 * 题目描述：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。 
 */
public class Convert {

	public static void main(String[] args) {
		Convert c = new Convert();
		cn.edu.xd.sse.lab.tree.TreeNode root = new cn.edu.xd.sse.lab.tree.TreeNode(10);
		root.left = new cn.edu.xd.sse.lab.tree.TreeNode(6);
		root.right = new cn.edu.xd.sse.lab.tree.TreeNode(14);
		root.left.left = new cn.edu.xd.sse.lab.tree.TreeNode(4);
		root.left.right = new cn.edu.xd.sse.lab.tree.TreeNode(8);
		root.right.left = new cn.edu.xd.sse.lab.tree.TreeNode(12);
		root.right.right = new cn.edu.xd.sse.lab.tree.TreeNode(16);
		cn.edu.xd.sse.lab.tree.TreeNode pHead = c.convert(root);
		while (pHead != null) {
			System.out.println(pHead.val);
			pHead = pHead.right;
		}

	}

	/**
  * 用递归的方式来求解
  * @param pRootOfTree   链表的头结点
  * @return              排好序的链表的头结点
  */
	public cn.edu.xd.sse.lab.tree.TreeNode convert(cn.edu.xd.sse.lab.tree.TreeNode pRootOfTree) {
		if (pRootOfTree == null)
			return null;
		cn.edu.xd.sse.lab.tree.TreeNode lastNode = convertNode(pRootOfTree, null);
		cn.edu.xd.sse.lab.tree.TreeNode pHead = lastNode;
		while (pHead != null && pHead.left != null)
			pHead = pHead.left;
        return pHead;
    }
    
  /**
   * 通过递归的方式得到遍历得到整条链
	   * @param node        当前正在访问的节点
	   * @param lastNode    上一个排好序的最后一个节点
	   * @return            当前排好序的最后一个节点
	   */
  private cn.edu.xd.sse.lab.tree.TreeNode convertNode(cn.edu.xd.sse.lab.tree.TreeNode node, cn.edu.xd.sse.lab.tree.TreeNode lastNode) {
	  if (node == null)
		  return null;
        if(node.left != null)
        	lastNode = convertNode(node.left, lastNode);

        //交换得到最后一个位置的节点
        node.left = lastNode;
        if(lastNode != null)
            lastNode.right = node;
        lastNode = node;

        if(node.right != null)
        	lastNode = convertNode(node.right, lastNode);
        return lastNode;
    }

	/**
	 * 用非递归的方式实现排序
     * @param pRootOfTree   链表的头结点
     * @return				返回排好序的链表的头结点
     */
	public cn.edu.xd.sse.lab.tree.TreeNode converts(cn.edu.xd.sse.lab.tree.TreeNode pRootOfTree) {
		if (pRootOfTree == null)
			return null;
    	Stack stack = new Stack();
		cn.edu.xd.sse.lab.tree.TreeNode p = pRootOfTree;
		boolean isFirst = true;
		cn.edu.xd.sse.lab.tree.TreeNode pre = null;
		while (p != null || !stack.isEmpty()) {
			while(p != null){
    			stack.push(p);
    			p = p.left;
    		}
			p = (cn.edu.xd.sse.lab.tree.TreeNode) stack.pop();
			//核心实现部分
			if(isFirst){
    			pRootOfTree = p;
    			pre = pRootOfTree;
    			isFirst = false;
    		}else{
    			pre.right = p;
    			p.left = pre;
    			pre = p;
    		}
    		p = p.right;
    	}
    	return pRootOfTree;
    }
}
