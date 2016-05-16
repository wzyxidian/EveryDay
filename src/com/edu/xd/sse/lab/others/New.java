package com.edu.xd.sse.lab.others;

/**
 * @author zhiyong wang
 *
 */
public class New {
	
	public static void main(String[] args){
//		int [] [] matrix = spiralMatrix(5);
//		for(int i = 0 ; i < matrix.length; ++i){
//			
//			for(int j = 0; j < matrix[i].length; ++j){
//				System.out.print(matrix[i][j]);
//			}
//			System.out.println();
//		}		
//		
//		lps("cabbeaf");
		Double i = new Double(1);
		Double a = new Double(1);
		StringBuilder s1 = new StringBuilder("a");
		StringBuilder s2 = new StringBuilder("a");
		StringBuffer s3 = new StringBuffer("a");
		StringBuffer s4 = new StringBuffer("a");
		System.out.println(i == a);
		System.out.println(i.equals(a));
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		System.out.println(s3 == s4);
		System.out.println(s3.equals(s4));
		
	}
	
	
	public static int[][] spiralMatrix(int n) {  
	     int circleMatrix[][] = new int[n][n];  
	     for (int num = 1, x = 0, y = 0, xDir = 1, yDir = 0; num <= n * n; num++) {  
	         circleMatrix[x][y] = num;  
	         if (x + xDir < 0 || y + yDir < 0 || x + xDir == n || y + yDir == n || circleMatrix[x + xDir][y + yDir] != 0) {//如果到边界了就换方向  
	             if (xDir != 0) {  
	                 yDir = xDir;  
	                 xDir = 0;  
	             } else {  
	                 xDir = -yDir;  
	                 yDir = 0;  
	             }  
	         }  
	         x += xDir;  
	         y += yDir;  
	     }  
	     return circleMatrix;  
	 }  
	
	
	public static void lps(String str) {
	    char[] cs = str.toCharArray();
	    StringBuilder sb = new StringBuilder(String.valueOf(cs[0]));
	    for (int i = 1; i < cs.length; i++) {
	        sb.append("*").append(cs[i]);
	    }
	    cs = sb.toString().toCharArray();
	    int middleIndex = 0; int stringRadix = 0;
	    for(int i = 1; i < cs.length - 1; i++) {
	        for(int j = 1; j < cs.length / 2 - 1; j++) {
	            if(i > j-1 && i < cs.length-j+1 && cs[i-j] == cs[i+j]) {
	                if(j > stringRadix) {
	                    middleIndex = i;
	                    stringRadix = j;
	                }
	            } else {
	                break;
	            }
	        }
	    }
	    System.out.println(String.valueOf(cs).substring(middleIndex - stringRadix, middleIndex + stringRadix + 1).replace("*", ""));
	}
	
	public static void fun(int n){
		
        int matrix[][] = new int[n][n];
         
        final int RIGHT = 1;
        final int DOWN = 2;
        final int LEFT = 3;
        final int UP = 4;
         
        int dir = RIGHT;
        int i=0, j=0;
        for(int count = 1; count<=n*n; ){
            matrix[i][j] = count++;
            switch (dir){
            case RIGHT:
                if(j+1>=n || matrix[i][j+1]!=0) {dir=DOWN; i++;}
                else {j++;}
                break;
            case DOWN:
                if(i+1>=n || matrix[i+1][j]!=0) {dir=LEFT;j--;}
                else {i++;}
                break;
            case LEFT:
                if(j-1<0 || matrix[i][j-1]!=0) {dir=UP;i--;}
                else {j--;}
                break;
            case UP:
                if(i-1<0 || matrix[i-1][j]!=0) {dir=RIGHT;j++;}
                else {i--;}
                break;
            default:
                continue;
            }
        }
         
         
        for (int ii = 0; ii < n; ii++) {
            for (int jj = 0; jj < n; jj++) {
                System.out.print(matrix[ii][jj]+"\t");
            }
            System.out.println();
        }
        
        
        
    
        
        
        
 
	}

}
