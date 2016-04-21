package com.edu.xd.sse.lab.offer;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * @author zhiyong wang
 *
 */
public class Permutation {

    /**
	 * 如果字符串中存在相同的字符串，采用如下办法，用递归方式
	 * 用TreeSet来保存可以去除重复字符串
	 * @param str  要排序的字符串
	 * @return     所有可能的结果
	 */
    public ArrayList<String> Permutations(String str) {
        ArrayList<String> result = new ArrayList<String>();
        TreeSet<String> set = new TreeSet<String>();
       if(str == null || str.length() == 0)
           return result;
        char[] chStr = str.toCharArray();
        int len = chStr.length;
        recursivePermutation(chStr, 0, len, set);
        result.addAll(set);
        return result;
    }
    /**
     * 如果字符串中存在相同的字符，采用以下办法，每次交换完，输出排序之后都要将交换的位置复原，以方便下一次交换
     * @param chStr  字符交换之后的字符串
     * @param begin  交换的位置
     * @param len    字符串的总长度
     * @param set 返回的结果
     */
    public void recursivePermutation(char[] chStr, int begin, int len, TreeSet<String> set){
        if(begin == len - 1){
            set.add(String.valueOf(chStr));
        }else{
            char temp;
            for(int i= begin; i < len ; i++){
                temp = chStr[i];
                chStr[i] = chStr[begin];
                chStr[begin] = temp;

                recursivePermutation(chStr, begin + 1, len, set);

                temp = chStr[i];
                chStr[i] = chStr[begin];
                chStr[begin] = temp;  
           } 
        }       
    }
}
