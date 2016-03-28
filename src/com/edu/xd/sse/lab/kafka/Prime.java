package com.edu.xd.sse.lab.kafka;

import java.util.BitSet;

/**
 * @author zhiyong wang
 *
 */
public class Prime {
	final static int allNum = 50000;
	final static int length = 32;
	
	public static void countPrime(){
//		long temp = (long) (Math.sqrt(500000)  * 100);
		int[] arr = new int[allNum / length + 1];
		int i = 3;
		while(i<allNum){
			setOne(arr,i);
			i += 2;
		}
		i = 3;
		while(i <= Math.sqrt(allNum)){
			if(getBit(arr,i) == 1){
				for(int j= 2*i;j<allNum;j += i){
					setZero(arr,j);
				}
			}
			i += 2;
		}
		
		int sum = 1;
		for(i=3;i<allNum;i+=2){
			if(getBit(arr,i) == 1){
				sum++;
				System.out.println(i);
			}
				
		}
		
	}
	
	public static void setZero(int[] arr, int position){
		arr[position / 32] &= ~(1 << position % 32); 
	}
	
	public static void setOne(int[] arr, int position){
		arr[position / 32] |= 1 << position % 32; 
	}
	
	public static int getBit(int[] arr, int position){
		int temp = arr[position / 32] & (1 << position % 32);
		
			return temp == 0 ? 0 : 1;
	}
	
	public static void main(String[] args) {
		countPrime();
	}
	
}
