package com.edu.xd.sse.lab.offer;

/**
 * Created by zhiyongwang on 2016/5/17.
 * judge that if the tree is balanced
 */
public class IsBalancedTree {
    private boolean flag = true;

    /**
     * 测试用例
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);

        IsBalancedTree ibt = new IsBalancedTree();
        boolean flag = ibt.isBalanced_Solution(root);
    }

    /**
     * 第一种方法：从根节点开始往下，分别判断他的左右节点的深度，然后根据平衡二叉树性质判断是否是平衡二叉树，
     * 然后再分别对满足平衡的左右节点再进行判断
     * 缺点：越靠近叶子节点的节点，会被重复遍历多次求深度，浪费时间
     *
     * @param root
     * @return
     */
    public boolean isBalanced_Solution(TreeNode root) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;
        int leftDepth = depthOfTheTree(root.left);
        int rightDepth = depthOfTheTree(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1)
            return false;
        return isBalanced_Solution(root.left) && isBalanced_Solution(root.right);
    }

    /**
     * 递归求二叉树的深度
     *
     * @param root
     * @return
     */
    private int depthOfTheTree(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        int left = depthOfTheTree(root.left);
        int right = depthOfTheTree(root.right);
        return left > right ? left + 1 : right + 1;
    }

    /**
     * 第二种方法，从下往上判断是否是平衡二叉树
     * 避免了节点的重复遍历，所有节点之用遍历一次就可以
     *
     * @param root
     * @return
     */
    public boolean isBalanced_Solutiion1(TreeNode root) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;
        depthOfTheTreeAndBalance(root);
        return flag;
    }

    /**
     * 采用的后续遍历的方式
     * 在原来求树的深度的基础上，增加了判断是否是平衡二叉树的功能
     * 这样就可以从叶节点往根节点方向判断是否是平衡二叉树，避免了重复遍历，用root.val来记录树的深度
     *
     * @param root
     * @return
     */
    private int depthOfTheTreeAndBalance(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null) {
            root.val = 1;
            return root.val;
        }
        int left = depthOfTheTreeAndBalance(root.left);
        int right = depthOfTheTreeAndBalance(root.right);
        if (Math.abs(left - right) > 1)
            flag = false;
        return root.val = (left > right ? left + 1 : right + 1);
    }
}
