package com.edu.xd.sse.lab.offer;

import java.util.ArrayList;

/**
 * @author zhiyong wang
 * 题目：顺时针打印矩阵
 * 内容：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10. 
 */
public class PrintMatrix {

	public ArrayList<Integer> printMatrix(int[][] matrix){
		 if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
				return null;
			ArrayList<Integer> result = new ArrayList<Integer>();
			int rows = matrix.length;
			int columns = matrix[0].length;
			final int right = 1;
			final int down = 2;
			final int left = 3;
			final int up = 4;
			int totalNum = rows * columns;
			int i = 0;
			int j = 0;
			int k = 0;
			int dir = right;
			while( k < totalNum){
				switch(dir){			
					case right:
						if(i < rows && i >= 0 && j < columns && j>= 0 && matrix[i][j] != 0){
							result.add(matrix[i][j]);
							matrix[i][j] = 0;
	                        j++;
							k++;
							break;
						}else{					
							dir = down;
	                        i++;
							k++;
							break;
						}
					case down:
						if(i < rows && i >= 0 && j < columns && j>= 0 && matrix[i][j] != 0){
							result.add(matrix[i][j]);
							matrix[i][j] = 0;
	                        ++i;
							k++;
							break;
						}else{
							dir = left;
	                        j--;
							k++;
							break;
						}
					case left:
						if(i < rows && i >= 0 && j < columns && j>= 0 && matrix[i][j] != 0){
							result.add(matrix[i][j]);
							matrix[i][j] = 0;
	                        j--;
							k++;
							break;
						}else{
							dir = up;
	                        i--;
							k++;
							break;
						}
					case up:
						if(i < rows && i >= 0 && j < columns && j>= 0 && matrix[i][j] != 0){
							result.add(matrix[i][j]);
							matrix[i][j] = 0;
	                        i--;
							k++;
							break;
						}else{
							dir = right;
	                        j++;
							k++;
							break;
						}
				}	
			}
			return result;
	}
	
	public static void main(String[] args) {
		PrintMatrix pm = new PrintMatrix();
		pm.printMatrix(new int[][]{{1,2},{3,4}});
	}
}
