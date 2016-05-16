package com.edu.xd.sse.lab.others;

import java.util.ArrayList;
import java.util.List;


/**
 * @author zhiyong wang
 *
 */
public class Wrong {
	public byte[] placeholder = new byte[64*1024];
	
	public static void fileHeap(int num) throws InterruptedException{
		List<Wrong> list = new ArrayList<Wrong>();
		for(int i=0;i<num;i++){
			Thread.sleep(1);
			list.add(new Wrong());
		}
	}
	
	public static void main(String[] args) throws InterruptedException{
		fileHeap(1000000000);
	}
}
