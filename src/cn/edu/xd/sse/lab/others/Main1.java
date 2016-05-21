package cn.edu.xd.sse.lab.others;

import java.util.Arrays;
import java.util.HashMap;


/**
 * @author zhiyong wang
 *
 */
public class Main1 {
	HashMap<String,Integer> brother = new HashMap<String, Integer>();
	HashMap<String,HashMap<String,Integer>> all = new HashMap<String,HashMap<String,Integer>>();
	public void insert(String s,int position){
		char[] temp = s.toCharArray();
		Arrays.sort(temp);
		String key = String.valueOf(temp);
		if(all.containsKey(key)){
			HashMap hm = all.get(temp);
			hm.put(s, position);
		}else{
			HashMap hm = new HashMap<String,Integer>();
			hm.put(s, position);
			all.put(key, hm);
		}
	}
	
	public HashMap<String,Integer> searchBrother(String s){
		if(s == null || s.length() == 0) return null;
		char[] temp = s.toCharArray();
		Arrays.sort(temp);
		String key = String.valueOf(temp);
		if(all.containsKey(key)){
			HashMap hm = all.get(temp);
			return hm;
		}else{
			return null;
		}
	}
}
