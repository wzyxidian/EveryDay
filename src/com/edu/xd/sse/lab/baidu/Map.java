package com.edu.xd.sse.lab.baidu;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * @author zhiyong wang
 *
 */
public class Map {

	public static void main(String[] args) {
		long time1 = System.currentTimeMillis();
		System.out.println(time1);
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>(100);
		long time2 = System.currentTimeMillis();
		System.out.println(time2);
		System.out.println(time2 - time1);
		time1 = System.currentTimeMillis();
		HashMap<Integer,Integer> amap = new HashMap<Integer,Integer>(128);
		time2 = System.currentTimeMillis();
		System.out.println(time2 - time1);
		System.out.println();
		ArrayList al;
	}
}
