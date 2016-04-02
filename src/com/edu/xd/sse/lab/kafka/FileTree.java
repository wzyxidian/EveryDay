package com.edu.xd.sse.lab.kafka;

import java.io.File;

/**  
 * @author wenyanqi 
 * 
 */
class TreeNode {
	File file;
	TreeNode left;
	TreeNode right;
	public TreeNode(File file){
		this.file = file;
	}
	public TreeNode(){
		this.file = null;
	}
}
public class FileTree {
	
	
	public static TreeNode buildTree(String filepath) {
		File file = new File(filepath);
		TreeNode root = new TreeNode();
		TreeNode p = root;
		if(file.isDirectory()) {
			File filelist[] = file.listFiles();

			for(File subfile : filelist) {
				if(subfile.isDirectory()) {
					TreeNode filenode = new TreeNode(subfile);
					p.left = filenode;
					p = filenode;
					TreeNode rightNode = buildTree(subfile.getAbsolutePath());
					p.right = rightNode;
				}
			}
			root = root.left;
		}
		return root;
	}
	
	public static void printTree(TreeNode root) {
		if(root==null) return;
		System.out.println(root.file.getAbsolutePath());
		printTree(root.left);
		printTree(root.right);
	}

	public static void main(String[] args) {
		String filepath = "F:\\ACM";
		
		TreeNode root = buildTree(filepath);
		printTree(root);
		
	}
}
