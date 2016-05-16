package com.edu.xd.sse.lab.others;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * @author zhiyong wang
 *
 */
public class ElectricNum {
	static int[][] comp = {
			{1,0,1,1,0,1,1,1,1,1},
			{1,0,0,0,1,1,1,0,1,1},
			{1,1,1,1,1,0,0,1,1,1},
			{0,0,1,1,1,1,1,0,1,1},
			{1,0,1,0,0,0,1,0,1,0},
			{1,1,0,1,1,1,1,1,1,1},
			{1,0,1,1,0,1,1,0,1,1}			
	};
	
	public static void main(String[] args) {
		
		//第一步判断输入
		Scanner scan = new Scanner(System.in);
		int totalCount = scan.nextInt();//输入测试总个数
		if(totalCount <= 100){
			for(int i=0;i<totalCount;i++){
				//输入每一组的数据
				String firstLine = scan.next();
				String[] chai = firstLine.split(" ");
				int k = Integer.valueOf(chai[0]);
				int N = Integer.valueOf(chai[1]);
				if(k>=1 && k<=5 && N>=0 && N<= 109){
					for(int j=0;j<k;j++){
						String nums = scan.next();
						//具体对每一行数据进行处理
						int[] num = dealWith(nums);
						
					}
				}
			}
		}else{
			System.out.println("out of bounder");
			return ;
		}
	}
	//解析每行数据，并判断可能的数字
	private static int[] dealWith(String s){
		String[] temp = s.split(" ");
		int[] res = new int[7];
		int k = 0;
		for(int i=0;i<temp.length;i++){
			if(!temp[i].equals(" ")){
				res[k++] = Integer.valueOf(temp[i]);
			}
		}
		
		//获得亮的二极管之后，判断这个可能的数字是什么
		return getResu(res);
	}
	
	private static int[] getResu(int[] res){
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<res.length;i++){
			for(int j=0;j<10;j++){
				if(comp[res[i]][j] == 1){
					if(map.containsKey(j)){
						map.put(j, map.get(j) + 1);
					}else{
						map.put(j, 1);
					}
				}
			}
		}
		int[] result = new int[10];
		int k = 0;
		Iterator it = (Iterator) map.keySet();
		while(it.hasNext()){
			int temp = (Integer) it.next();
			if(it.next().toString().equals(res.length)){
				result[k++] = temp;
			}
		}
		return result;
	}
}
