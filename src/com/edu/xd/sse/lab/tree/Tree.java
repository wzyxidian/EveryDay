package com.edu.xd.sse.lab.tree;

/**
 * @author zhiyong wang
 *
 */
public class Tree {

	/**
	 * 递归求二叉树的高度
	 */
	public int getHeightOfTree(TreeNode node){
		if(node == null)
			return 0;
		int leftHeight;
		int rightHeight;
		leftHeight = getHeightOfTree(node.left);
		rightHeight = getHeightOfTree(node.right);
		return (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;
	}
	
	public static void main(String[] args) {
		final StringBuffer s = new StringBuffer("dsaf");
		s.append("sd");
		System.out.println(s);
		Object obj;
		
	}
}
