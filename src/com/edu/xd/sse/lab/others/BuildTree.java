package com.edu.xd.sse.lab.others;

import java.util.Scanner;


//根据先序遍历结果建树
public class BuildTree {

	private String[] preOrder = {"A","B","D","$","$","$","C","E","$","$","F","$","$"};
	private Scanner scan = new Scanner(System.in);

	//根据先序遍历顺序了来建一个树
	public void buildPreTree(Tree node){
		String s = scan.next();
		if(s.equals("$")){
			return ;
		}else{
			node = new Tree(s);
			buildPreTree(node.lChild);
			buildPreTree(node.rChild);
		}
	}

	//根据中序顺序建树
	public void buildInTree(Tree node){
		String s = scan.next();
		if(s.equals("$")){
			return ;
		}else{
			buildInTree(node.lChild);
			node = new Tree(s);
			buildInTree(node.rChild);
		}
	}

	//根据后续遍历建树
	public void buildPostTree(Tree node){
		String s = scan.next();
		if(s.equals("$")){
			return ;
		}else{
			buildPostTree(node.lChild);
			buildPostTree(node.rChild);
			node = new Tree(s);
		}
	}

	//定义一个树
	private class Tree {
		String value;
		Tree lChild;
		Tree rChild;

		Tree(String value) {
			this.value = value;
		}
	}
}
