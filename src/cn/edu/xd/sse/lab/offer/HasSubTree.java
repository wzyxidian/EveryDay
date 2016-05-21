package cn.edu.xd.sse.lab.offer;

/**
 * @author zhiyong wang
 * 	题目：树的子结构
 *  内容：输入两颗二叉树A，B，判断B是不是A的子结构。 
 */
public class HasSubTree {

	/**
	 * 如果root2为null返回true
	 * 如果root2不为null，root1为null，返回false
	 * 如果root1与root2都不为null，首先判断两个值是否相等，如果相等继续向下判断；
	 * 如果不相等，则递归判断root1的左树中是否包含root2树
	 * 如果左树中不包含，则递归判断root1的右树中是否包含root2树
	 * @param root1
	 * @param root2
	 * @return
	 */
	public boolean hasSubTree(TreeNode root1, TreeNode root2){
		boolean result = false;
		if(root2 == null)
			return true;
		if(root1 == null & root2 != null)
			return false;
		if(root1 != null && root2 != null){
			if(root1.val == root2.val)
				result = judgeSubTree(root1, root2);
			if(!result)
				result = hasSubTree(root1.left, root2);
			if(!result)
				result = hasSubTree(root1.right, root2);
			}
		return result;
	}

	/**
	 * 递归判断是否为子树，root2为null，说明子树已经遍历完，在root1中，返回true
	 * 如果root1为null，而root2不为null，说明不在里面，返回false
	 * 然后判断是否相等，如果不相等返回false
	 * 如果相等，则判断左右孩子是否相等
	 *
	 * @param root1
	 * @param root2
	 * @return
	 */
	private boolean judgeSubTree(TreeNode root1, TreeNode root2){
		if(root2 == null)
			return true;
		if(root1 == null)
			return false;
		if(root1.val != root2.val)
			return false;
		return judgeSubTree(root1.left,root2.left) && judgeSubTree(root1.right, root2.right);

	}

	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}
}
