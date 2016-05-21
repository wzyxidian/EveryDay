package cn.edu.xd.sse.lab.offer;

/**
 * @author zhiyong wang
 *
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 
 */
public class BuildBinaryTree {
	private class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int val){
			this.val = val;
		}
	/**
	 * 
	 * @param pre 前序数组
	 * @param in  后序数组
	 * 通过递归方式实现
	 * @return
	 */
	public TreeNode reConstructBinaryTree(int[] pre, int[] in){
		if(pre == null || in == null)
			return null;
		return contructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}


		/**
		 *
	 * @param pre       	前序数组
	 * @param preStart      前序数组的首地址
	 * @param preEnd        前序数组的尾地址
	 * @param in            中序数组
	 * @param inStart       中序数组的首地址
	 * @param inEnd         中序数组的尾地址
	 * @return
	 */
	private TreeNode contructBinaryTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd){
		if(preStart > preEnd || inStart > inEnd)
			return null;
		TreeNode root = new TreeNode(pre[preStart]);
		for(int i = inStart; i <= inEnd; i++){
			if(pre[preStart] == in[i]){
				root.left = contructBinaryTree(pre, preStart + 1, preStart + i - inStart, in, inStart, i - 1);
				root.right = contructBinaryTree(pre, preStart + i - inStart + 1, preEnd, in, i + 1, inEnd);
			}
		}
		return root;
	}
}


}