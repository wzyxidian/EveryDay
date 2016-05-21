package cn.edu.xd.sse.lab.offer;

import java.util.ArrayList;

/**
 * @author zhiyong wang
 * 题目：二叉树中和为某一值的路径
 * 题目描述：输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 		      路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class FindPath {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(12);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(7);

		FindPath f = new FindPath();
		f.findPaths(root, 22);
	}
  
	/**
	 * 首先判断root是否为null，如果为null，则返回空，然后开始进行递归求值
	 * 这个地方递归参数为：要遍历的下一个节点root，目标值target，当前的计算值sum，最后存放的结果集result，用来存放路径的list
	 *
	 * @param root
	 * @param target
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> findPaths(TreeNode root,int target) {
	  ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
      if(root == null)
          return result;
      int sum = 0;
      ArrayList<Integer> list = new ArrayList<Integer>();
      findPath(root, target, sum, result, list);
      return result;
  }
  
	/**
	 * 利用先序遍历进行查找，如果匹配成功，则新建一个ArrayList<Integer>对象，然后将存放的结果放入，然后将这个对象添加到结果集result，
	 * 不能将路径直接添加到结果集里面，因为他只是一个引用，最后结果集所有的结果都指向这一引用了
	 * @param root
	 * @param target
	 * @param sum
	 * @param result
	 * @param list
	 */
  public void findPath(TreeNode root, int target, int sum, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list){
      sum += root.val;
      list.add(root.val);
      boolean flag = root.left == null && root.right == null;
      if(sum == target && flag){
    	  ArrayList<Integer> listResult = new ArrayList<Integer>();
    	  listResult.addAll(list);
          result.add(listResult);
      }
      if(root.left != null){
          findPath(root.left, target, sum, result, list);
      }
      if(root.right != null){
    	  findPath(root.right, target, sum, result, list);
      }
      list.remove(list.size() - 1);
  }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
        
    }

}