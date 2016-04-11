package com.edu.xd.sse.lab.offer;

/**
 * @author zhiyong wang
 * 题目描述
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。 
 */
public class SearchNum {

	/**
	 * 
	 * @param array  待查找的二维数组
	 * @param target  查找数字
	 * 思路：从右上角或者左下角开始遍历
	 * @return
	 */
	public boolean Find(int[][] array, int target){
		if(array == null || array.length == 0 || array[0].length == 0)
			return false;
		int row = array.length;
		int column = array[0].length;
		//定义从左上角开始查找
		int i = 0;
		int j = column - 1;
		while(i < row && j >= 0){
			if(array[i][j] == target)
				return true;
			else if(array[i][j] > target){
				--j;
			}else
				++i;
		}
		return false;
	}
}
