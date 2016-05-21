package cn.edu.xd.sse.lab.kafka;

import java.io.File;

/**
 * @author zhiyong wang
 *
 */
public class Tree {

	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.buildTree("F:\\ACM");
	}
	
	public void buildTree(String s){
		Node root = null;
		if(s == null || s.length() == 0)
			return ;
		File file = new File(s);
		//首先判读输入的是否是一个目录
		if(file.isDirectory()){
			File[] fileList = file.listFiles();
			File[] fileList1 = new File[fileList.length];
			int k = 0;
			//求出子目录的个数
			for (int i = 0; i < fileList.length; i++) {
				if(fileList[i].isDirectory())
					fileList1[k++] = fileList[i];
			}
			//当前目录只有一个目录的时候，只用递归求右孩子就可以
			if(k == 1){
				root = new Node(fileList1[0]);
				fileList = fileList1[0].listFiles();
				recursive(fileList,false, root);
			}else if(k > 1){
				//当前目录不止有一个目录的时候，首先拿第一个目录递归求右孩子，然后拿其他孩子递归的求左孩子
				root = new Node(fileList1[0]);
				fileList = fileList1[0].listFiles();
				recursive(fileList,false, root);
				File[] fileLists = new File[fileList1.length - 1];
				System.arraycopy(fileList1, 1, fileLists, 0, fileLists.length);
				recursive(fileLists,true, root);
			}
			print(root);
		}
	}
	
	//打印目录
	public void print(Node node){
		if(node == null)
			return ;
		System.out.println(node.f.getName());
		if(node.left != null)
			print(node.left);
		if(node.right != null)
			print(node.right);
	}

	//递归建树，flag为true表示求的是左孩子，false是右孩子
	public void recursive(File[] fileList, boolean flag, Node node){
		if(fileList.length == 0 || node == null)
			return ;
		int j = 0;
		while(j < fileList.length && !fileList[j].isDirectory()){
			j++;
		}
		if(j == fileList.length)
			return;
		if (flag) {
			node.left = new Node(fileList[j]);
			recursive(fileList[j].listFiles(),false, node.left);
			if(j < fileList.length - 1){
				File[] fileLists = new File[fileList.length - j - 1];
				System.arraycopy(fileList, j + 1, fileLists, 0, fileLists.length);
				recursive(fileLists, true, node.left);
			}
		}else{
			node.right = new Node(fileList[j]);
			recursive(fileList[j].listFiles(),false,node.right);
			if(j < fileList.length - 1){
				File[] fileLists = new File[fileList.length - j - 1];
				System.arraycopy(fileList, j + 1, fileLists, 0, fileLists.length);
				recursive(fileLists, true, node.right);
			}
		}
	}

	//建立节点
	class Node{
		File f;
		Node left;
		Node right;
		Node(File f){
			this.f = f;
		}

	}
}
