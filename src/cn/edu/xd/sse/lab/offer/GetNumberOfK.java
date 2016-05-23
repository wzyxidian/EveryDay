package com.edu.xd.sse.lab.offer;

/**
 * @author zhiyong wang
 * 题目：数字在排序数组中出现的次数
 * 题目描述：统计一个数字在排序数组中出现的次数
 */
public class GetNumberOfK {
	
	/**
	 * 要求时间复杂度小于O(n)
	 * 这里可以采用二分法求得所求k的起始位置下标和
	 * @param array
	 * @param k
	 * @return
	 */
	 public int getNumberOfK(int [] array , int k) {
	       if(array == null || array.length == 0)
	           return 0;
	        int low = 0;
	        int high = array.length - 1;
	        int start = startPositionOfK(array, low, high, k);
	        if(start == -1)
	        	return 0;
	        low = start;
	        int end = endPositionOfK(array, low, high, k);
	        System.out.println(end - start + 1);
	        return end - start + 1;
	    }
    
    private int startPositionOfK(int[] array, int low, int high, int k){   
        if(low <= high){
            int mid = (low + high) / 2;
            if(array[mid] < k)
                low = mid + 1;
            else if(array[mid] > k)
                high = mid - 1;
             else{
                 if(mid == 0 || array[mid - 1] != k)
                    return mid;
                else{
                    high = mid - 1;
                }
            }
            return startPositionOfK(array, low, high, k);
        }
        return -1;
    }
	    
      private int endPositionOfK(int[] array, int low, int high, int k){   
        if(low <= high){
            int mid = (low + high) / 2;
            if(array[mid] < k)
                low = mid + 1;
            else if(array[mid] > k)
                high = mid - 1;
             else{
                 if(mid == array.length - 1 || array[mid + 1] != k)
                    return mid;
                else{
                    low = mid + 1;
                }
            }
            return endPositionOfK(array, low, high, k);
        }
        return -1;
    }
      public static void main(String[] args) {
		GetNumberOfK g = new GetNumberOfK();
//		g.GetNumberOfK(new int[]{1,2,3,3,3,3,4,5}, 3);
	}
}
