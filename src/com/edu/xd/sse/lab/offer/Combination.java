package com.edu.xd.sse.lab.offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhiyong wang
 * 
 */
public class Combination {

	public ArrayList<String> combination(String s){
		ArrayList<String> list = new ArrayList<String>();
		Set set = new HashSet();
		if(s == null || s.length() == 0)
			return list;
		int len = s.length();
		for(int i = 1; i < len; i++){
			recursiveCombination(s,i,set);
		}
		list.addAll(set);
		return list;
	}
	
	public void recursiveCombination(String s, int len, Set set){
		return ;
	}
}
