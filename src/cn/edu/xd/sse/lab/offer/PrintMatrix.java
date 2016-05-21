package cn.edu.xd.sse.lab.offer;

import java.util.ArrayList;

/**
 * @author zhiyong wang
 * 题目：顺时针打印矩阵
 * 内容：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10. 
 */
public class PrintMatrix {
	
	/**
	 * 采用递归的方式来进行打印，按照一圈一圈的打印方式来打印
	 * 递归参数要掌握好，跟先序、中序来见二叉树一样，
	 * 要将打印二维数组、要打印的起止行坐标、起止纵坐标、结果作为递归的参数
	 * 就要注意五种情况:分别是下面的if else 五种情况
	 * @param matrix
	 * @return
	 */
	 public ArrayList<Integer> printMatrix(int [][] matrix) {
	        ArrayList<Integer> result = new ArrayList<Integer>();
	     	if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
	            return null;
	        printMatrixCircle(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, result);
	        return result;
		}
	    	
	 /**
	  * 
	  * @param matrix        要打印的二维数组 
	  * @param startRow      数组的起始行
	  * @param startCol      数组的起始列
	  * @param endRow        数组的终止行
	  * @param endCol		  数组的终止列
	  * @param result        存放打印顺序结果的数组
	  */
	 public void printMatrixCircle(int[][] matrix, int startRow, int startCol, int endRow, int endCol, ArrayList<Integer> result){
	        if((startRow < endRow) && (startCol < endCol)){
	            for(int j = startCol; j <= endCol; j++){result.add(matrix[startRow][j]);}
	            for(int i = startRow + 1; i < endRow; i++){result.add(matrix[i][endCol]);}
	            for(int j = endCol; j >= startCol; j--){result.add(matrix[endRow][j]);}
	            for(int i = endRow - 1; i > startRow; i--){result.add(matrix[i][startCol]);}
	            printMatrixCircle(matrix, startRow + 1, startCol + 1, endRow - 1, endCol - 1, result);
	        }else if(startRow == endRow && startCol < endCol){
	            for(int j = startRow; j <= endCol; j++){result.add(matrix[startRow][j]);}
	        }else if(startRow < endRow && startCol == endCol){
	            for(int i = startRow; i <= endRow; i++){result.add(matrix[i][startCol]);}
	        }else if(startRow == endRow && startCol == endCol){
	        	 result.add(matrix[startRow][startCol]);
	        }else{
	        	return ;
	        }
	      
	    }
}
