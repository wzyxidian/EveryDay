package cn.edu.xd.sse.lab.others;

import java.util.LinkedList;
import java.util.Scanner;


/*
 * 约瑟夫环：已知n个人(以编号1，2，3...n分别表示)围坐在一张圆桌周围。从编号为k的人开始报数，数到m的那个人出列;
 * 他的下一个人又从1开始报数，数到m的那个人又出列;依此规律重复下去，直到圆桌周围的人全部出列。
 */
public class YueSeFu {

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("total Number:");
		int totalNum = scan.nextInt();
		System.out.println("out num");
		int outNum = scan.nextInt();
		yuesefu(totalNum, outNum);
	}
	
	private static void yuesefu(int totalNum, int outNum){
		LinkedList arr = new LinkedList<Integer>();
		//初始化人数
		int i=1;
		while(i <= totalNum){
			arr.add(i);
			i++;
		}
		//从第k个人开始计数
		int k = 0 ;
		while(arr.size() > 0){
			k = k + outNum;
			k = k % arr.size() - 1;
			if(k < 0){
				System.out.println(arr.get(arr.size() - 1));
				arr.remove(arr.size() - 1);
				k = 0;
			}else{
				System.out.println(arr.get(k));
				arr.remove(k);
			}
		}
	}
}
