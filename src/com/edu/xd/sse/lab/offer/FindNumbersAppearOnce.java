package com.edu.xd.sse.lab.offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author zhiyong wang
 *
 */
public class FindNumbersAppearOnce {

	public void findNumberAppearOnce(int [] array,int num1[] , int num2[]){
		 if(array == null || array.length == 0)
	            return ;
	        Map map = new HashMap();
	        int i = 0;
	        int len = array.length;
	        while(i < len){
	            if(map.containsKey(array[i]))
	                map.put(array[i], (int)map.get(array[i]) + 1);
	            else
	                map.put(array[i], 1);
	        }
	        List list = new ArrayList<Integer>();
	        Iterator it = map.keySet().iterator();
	        while(it.hasNext()){
	            if((int)map.get(it) == 1){
	                list.add(it);
	            }
	        }
	        num1[0] = (int) list.get(0);
	        num2[0] = (int) list.get(1);
	}
}
