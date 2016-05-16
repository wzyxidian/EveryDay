package com.edu.xd.sse.lab.others;

import java.io.IOException;
import java.util.Scanner;


//无向图的邻接表的创建
public class ListUDG {

	private VNode[] mVexs; //顶点数组
	//创建图，自己输入数据
	public ListUDG(){
		//输入顶点数和边数
		int vlen = readInt();
		int elen = readInt();
		if(vlen<1||elen<1||elen > (vlen*(vlen-1))){
			return ;
		}
		//初始化顶点
		mVexs = new VNode[vlen];
		for(int i=0;i<vlen;i++){
			mVexs[i] = new VNode();
			mVexs[i].data = readChar();
			mVexs[i].firstEdge = null;
		}
		//初始化边
		for(int i=0;i<elen;i++){
			char c1 = readChar();
			char c2 = readChar();
			int p1 = getPosition(c1);
			int p2 = getPosition(c2);
			if(p1 == -1 || p2 == -1) return;
			ENode node1 = new ENode();
			node1.ivex = p2;
			if(mVexs[p1].firstEdge == null){
				mVexs[p1].firstEdge = node1;
			}else{
				linkLast(mVexs[p1].firstEdge,node1);
			}

			ENode node2 = new ENode();
			node2.ivex = p1;
			if(mVexs[p2].firstEdge == null){
				mVexs[p2].firstEdge = node2;
			}else{
				linkLast(mVexs[p2].firstEdge,node2);
			}
		}
	}
	//创建图，用已有数据
	public ListUDG(char[] vexs, char[][] edges){
		//得到顶点数与边数
		int vlen = vexs.length;
		int elen = edges.length;
		if(vlen<1||elen<1||elen > (vlen*(vlen-1))){
			return ;
		}
		//初始化顶点表
		mVexs = new VNode[vlen];
		for(int i=0;i<vlen;i++){
			mVexs[i].data = vexs[i];
			mVexs[i].firstEdge = null;
		}
		//初始化边
		for(int i=0;i<elen;i++){
			char c1 = edges[i][0];
			char c2 = edges[i][1];
			int p1 = getPosition(c1);
			int p2 = getPosition(c2);
			ENode node1 = new ENode();
			node1.ivex = p2;
			if(mVexs[p1].firstEdge == null){
				mVexs[p1].firstEdge = node1;
			}else{
				linkLast(mVexs[p1].firstEdge,node1);
			}
			ENode node2 = new ENode();
			node2.ivex = p1;
			if(mVexs[p2].firstEdge == null){
				mVexs[p2].firstEdge = node2;
			}else{
				linkLast(mVexs[p2].firstEdge,node2);
			}
		}


	}

	//控制台获取数据
	private int readInt(){
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}

	//控制台获取字符
	private char readChar(){
		char ch = '0';
		do{
			try {
				ch = (char) System.in.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while(!(ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z'));
		return ch;
	}

	//获取字符在数组中的位置
	private int getPosition(char ch){
		for(int i=0;i<mVexs.length;i++){
			if(mVexs[i].data == ch)
				return i;
		}
		return -1;
	}

	//讲节点添加到队列的最后
	private void linkLast(ENode list, ENode node){
		ENode p = list;
		while(p.nextENode != null){
			p = p.nextENode;
		}
		p.nextENode = node;
	}

	//邻接表中表对应的链表的顶点
	private class ENode {
		int ivex; //该边所指向的顶点的位置
		ENode nextENode; //指向下一条弧的指针
	}

	//邻接表中表的顶点
	private class VNode {
		char data; //顶点信息
		ENode firstEdge; //指向第一条依附该顶点的弧
	}
}
