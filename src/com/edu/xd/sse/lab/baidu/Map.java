package com.edu.xd.sse.lab.baidu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;



/**
 * @author zhiyong wang
 *
 */
public class Map {

	public static void main(String[] args) {
		Integer[] arr = new Integer[3];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		ArrayList<Number> array = new ArrayList<Number>();
		Collections.addAll(array, arr);
		 
		List<Integer> arrays = Arrays.asList(arr);
		arrays.add(4);
		for(int i=0;i<arrays.size();i++){
			System.out.println((arrays.get(i)));
		}
	}
	
}
