package com.edu.xd.sse.lab.others;

/**
 * @author zhiyong wang
 * 
 */
public class HuffmanNode implements Comparable, Cloneable {

	int key; // 权值
	HuffmanNode left; // 左孩子
	HuffmanNode right; // 右孩子
	HuffmanNode parent; // 父结点
	HuffmanNode(int key, HuffmanNode left, HuffmanNode right, HuffmanNode parent) {
		this.key = key;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
