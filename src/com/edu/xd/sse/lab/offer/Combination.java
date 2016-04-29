package com.edu.xd.sse.lab.offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhiyong wang
 * 题目：组合
 * 题目描述：
 * 		如果不是求字符的所有排列，而是求字符的所有组合，应该怎么办？输入三个字符a,b,c，则他们的组合有a，b,c,ab,ac,bc,abc。
 * 		当交换字符串中的两个字符时，虽然能得到两个不同的排列，但是却是同一个组合。比如ab和ba是不同排列，但只算是一个组合。
 */
public class Combination {

	/**
	 * 思路：既然是组合，可以从第一个位置开始遍历，每个字符都分成两条路来走，（1）包含第一个字符，（2）不包含第一个字符
	 * 		然后在上面的基础上（1）包含第二个字符，（2）不包含第二个字符。。。。依次类推，可以用二叉树的思想来解决
	 * 		第一反应用到递归的方法来实现。
	 * 递归的参数包括：原始字符串，下一个遍历的位置，字符串的总长度，当前的字符串组合，结果集
	 * @param s 
	 * @return
	 */
	public ArrayList<String> combination(String s){
		ArrayList<String> list = new ArrayList<String>();
		Set set = new HashSet();  //因为字符串中可能会有相同字符的情况，所以用set进行排重
		if(s == null || s.length() == 0)
			return list;
		int len = s.length();
		String sb = "";
		recursive(s,0,len,sb,set);
		list.addAll(set);
		return list;
	}
	
	/**
	 * 
	 * 返回的判断条件是下一个要判断的字符位置是不是到字符串的最后一位的下一位，
	 * 同时还要注意组合中包含一种所有字符都没有的情况，这种情况要排除
	 * 然后递归分两种情况：包含当前字符，与不包含当前字符
	 * @param s        原始字符串
	 * @param index    下一个要遍历的字符串位置
	 * @param len      原始字符串长度
	 * @param sb       当前的字符串组合
	 * @param set      结果集
	 */
	private void recursive(String s, int index, int len, String sb, Set set) {
		// TODO Auto-generated method stub
		if(index == len){
			if(!sb.equals(""))//有一种情况存在就是所有的字符都没有选择，一直往下递归
				set.add(sb.toString());
			return ;
		}
		int startIndex1 = index + 1;
		recursive(s,startIndex1,len,sb,set);
		sb = sb + s.charAt(index);
		recursive(s,startIndex1,len,sb, set);
		
	}

}
