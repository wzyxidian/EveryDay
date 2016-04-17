package com.edu.xd.sse.lab.offer;

/**
 * @author zhiyong wang
 * 题目：二叉树的镜像
 * 内容：操作给定的二叉树，将其变换为源二叉树的镜像。 
 * 二叉树的镜像定义：源二叉树 
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *    	 / \  / \
 *     	11 9 7  5
 */
public class Mirror {

	private class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	/**
	 * 通过先序遍历，将左右子树分别递归交换
	 * @param root
	 */
	public void mirror(TreeNode root){
		if(root == null)
			return ;
		TreeNode left = root.left;
		root.left = root.right;
		root.right = left;
		
		mirror(root.left);
		mirror(root.right);
	}
}
