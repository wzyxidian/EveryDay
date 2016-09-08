package cn.edu.xd.sse.lab.tree;

import java.util.LinkedList;
import java.util.Stack;

public class TreeTraverse {

	private final static int[] array = new int[]{1,2,3,4,5,6,7,8,9};
	public static LinkedList<TreeNode> nodeList;

    /**
     * 递归先序遍历
     *
     * @param node
     */
    public static void preOrderTraverse(TreeNode node){
		if(node == null){
			return ;
		}
		System.out.println(node.val + " ");
		preOrderTraverse(node.leftChild);
		preOrderTraverse(node.rightChild);
    }

    /**
     * 递归中序遍历
     * @param node
     */
    public static void inOrderTraverse(TreeNode node){
		if(node == null){
			return ;
		}
		inOrderTraverse(node.leftChild);
		System.out.println(node.val + " ");
		inOrderTraverse(node.rightChild);
    }

    /**
     * 递归后序遍历
     * @param node
     */
    public static void postOrderTraverse(TreeNode node){
		if(node == null){
			return ;
		}
		postOrderTraverse(node.leftChild);
		postOrderTraverse(node.rightChild);
		System.out.println(node.val + " ");
    }

    /**
     * 非递归先序遍历
     * @param node
     */
    public static void preOrderTraverse2(TreeNode node){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(node != null || !stack.empty()){
			while(node != null){
				System.out.println(node.val + " ");
				stack.push(node);
				node = node.leftChild;
			}
			if(!stack.empty()){
				node = stack.pop();
				node = node.rightChild;
			}
        }
    }

    /**
     * 非递归中序遍历
     * @param node
     */
    public static void inOrderTraverse2(TreeNode node){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(node != null || !stack.empty()){
			while(node != null){
				stack.push(node);
				node = node.leftChild;
			}
			if(!stack.empty()){
				node = stack.pop();
				System.out.println(node.val + " ");
				node = node.rightChild;
			}
        }
    }

    /**
     * 非递归后序遍历
     * @param node
     */
    public static void postOrderTraverse2(TreeNode node){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<Integer> stack1 = new Stack<Integer>();

		while(node != null || !stack.empty()){
			while(node != null){
				stack.push(node);
				stack1.push(0);
				node = node.leftChild;
			}
			while(!stack.empty() && stack1.peek() == 1){
				stack1.pop();
				System.out.println(stack.pop().val);

			}
			if(!stack.empty()){
				stack1.pop();
				stack1.push(1);
				node = stack.peek();
				node = node.rightChild;
			}
        }
    }

    /**
     * 二叉树的创建
     */
	public void createBinTree() {
		nodeList = new LinkedList<TreeNode>();
		int arrayLen = array.length;

		for (int i = 0; i < arrayLen; i++) {
			nodeList.add(new TreeNode(array[i]));
		}
		int MaxFatherIndex = arrayLen / 2 - 1;
		for (int parentIndex = 0; parentIndex < MaxFatherIndex; parentIndex++) {
			nodeList.get(parentIndex).leftChild = nodeList.get(parentIndex * 2 + 1);
			nodeList.get(parentIndex).rightChild = nodeList.get(parentIndex * 2 + 2);
		}

		nodeList.get(MaxFatherIndex).leftChild = nodeList.get(MaxFatherIndex * 2 + 1);
		if (arrayLen % 2 == 1) {
			nodeList.get(MaxFatherIndex).rightChild = nodeList.get(MaxFatherIndex * 2 + 2);
		}
	}

	private static class TreeNode {
		int val;
		TreeNode leftChild;
		TreeNode rightChild;

		TreeNode(int data) {
			leftChild = null;
			rightChild = null;
			val = data;
		}

	}
}
