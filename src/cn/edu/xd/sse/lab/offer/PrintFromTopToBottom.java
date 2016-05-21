package cn.edu.xd.sse.lab.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhiyong wang
 * 题目： 从上往下打印二叉树
 * 题目描述：从上往下打印出二叉树的每个节点，同层节点从左至右打印。 
 */
public class PrintFromTopToBottom {
	/**
	 * 通过广度优先遍历的方式来进行打印
	 * 用队列来存放访问过的点
	 * @param root
	 * @return
	 */
	 public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
	        ArrayList<Integer> list = new ArrayList<Integer>();
	        if(root == null)
	            return list;
	        Queue queue = new LinkedList();
	        queue.add(root);
	        while(!queue.isEmpty()){
	            TreeNode node = (TreeNode)queue.poll();
	            list.add(node.val);
	            if(node.left != null)
	                queue.add(node.left);
	            if(node.right != null)
	                queue.add(node.right);
	        }
	        return list;
	    }

	private class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}
	}
}
