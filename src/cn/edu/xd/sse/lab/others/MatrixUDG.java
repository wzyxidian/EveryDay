package cn.edu.xd.sse.lab.others;

import java.io.IOException;
import java.util.Scanner;


//邻接矩阵的无向图的创建
public class MatrixUDG {

	private char[] mVexs;//顶点集合
	private int[][] mMatrix;//邻接矩阵
	
	//创建图，自己输入数据
	public MatrixUDG(){
		//输入顶点数和边数
		int vlen = readInt();
		int elen = readInt();
		if(vlen<1||elen<1||elen>(vlen*(vlen-1))){
			System.out.println("error");
			return ;
		}
		//初始化顶点
		mVexs = new char[vlen];
		for(int i=0;i<vlen;i++){
			mVexs[i] = readChar();
		}
		//初始化边
		mMatrix = new int[vlen][vlen];
		for(int i=0;i<elen;i++){
			//读取边的起始顶点和结束顶点
			char c1 = readChar();
			char c2 = readChar();
			int p1 =  getPosition(c1);
			int p2 = getPosition(c2);
			if(p1 == -1 || p2 == -1){
				System.out.println("error");
				return;
			}
			mMatrix[p1][p2] = 1;
			mMatrix[p2][p1] = 1;
		}
	}
	
	//创建图，用已提供的矩阵
	public MatrixUDG(char[] vexs, char[][] edges){
		//初始化顶点数和边数
		int vlen = vexs.length;
		int elen = edges.length;
		//初始化顶点
		mVexs = new char[vlen];
		for(int i=0;i<vlen;i++){
			mVexs[i] = vexs[i];
		}
		
		//初始化边数
		mMatrix = new int[vlen][vlen];
		for(int i=0;i<elen;i++){
			//得到边的起始顶点和结束顶点
			char c1 = edges[i][0];
			char c2 = edges[i][1];
			int p1 = getPosition(c1);
			int p2 = getPosition(c2);
			mMatrix[p1][p2] = 1;
			mMatrix[p2][p1] = 1;
		}
	}

	public static void main(String[] args) {
		char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
		char[][] edges = new char[][]{
				{'A', 'C'},
				{'A', 'D'},
				{'A', 'F'},
				{'B', 'C'},
				{'C', 'D'},
				{'E', 'G'},
				{'F', 'G'}};
		MatrixUDG pG;

		// 自定义"图"(输入矩阵队列)
		//pG = new MatrixUDG();
		// 采用已有的"图"
		pG = new MatrixUDG(vexs, edges);

		pG.print();   // 打印图
	}

	//从控制台读取一个整数
	private int readInt(){
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}

	//从控制台读取一个字符
	private char readChar(){
		char ch = '0';
		do{
			try {
				ch = (char) System.in.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while(!((ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z')));
		return ch;
	}

	//获取顶点ch的位置
	private int getPosition(char ch){
		for(int i=0;i<mVexs.length;i++){
			if(mVexs[i] == ch)
				return i;
		}
		return -1;
	}

	//打印矩阵队列
	private void print(){
		for(int i=0;i<mVexs.length;i++){
			for(int j=0;j<mVexs.length;j++){
				System.out.print(mMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
