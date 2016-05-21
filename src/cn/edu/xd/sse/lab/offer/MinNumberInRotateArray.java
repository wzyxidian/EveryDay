package cn.edu.xd.sse.lab.offer;

/**
 * @author zhiyong wang
 * 
 *题目描述
 *把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个非递减序列的一个旋转，输出旋转数组的最小元素。
 *例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 *
 *这个题最高效的做法是用二分查找的思想，一个指针指向第一个值，一个指针指向最后一个值，然后移动指针找到结果(注意一种特殊情况：所有值相等的情况)
 */
public class MinNumberInRotateArray {

	/**
	 * 二分查找方法
	 * @param array 要用来进行查找的数组
	 * @return
	 */
	public int minNumberInRotateArray(int[] array){
		if(array == null)
			return -1;
		if(array.length == 0)
			return 0;
		int index1 = 0;
		int index2 = array.length - 1;
		int midIndex = index1;
		//进入二分查找的循环
		while(index1 <= index2){
			midIndex = (index1 + index2) / 2;
			//二分查找的结束条件，是第二个指针与第一个指针的差值为1
			if(index2 - index1 == 1){
				midIndex = index2;
				break;
			}
			//二分查找的特殊情况，指针所指向的值都相等，这个时候只能用最小查找法
			if(array[index1] == array[index2] && array[index1] == array[midIndex]){
				midIndex = selectMinIndex(array,index1,index2);
				break;
			}
			if(array[index1] < array[midIndex])
				index1 = midIndex;
			else if(array[index2] > array[midIndex])
				index2 = midIndex;
		}
		return array[midIndex];
	}
	
	/**
	 * 用选择法
	 * @param array   用来查找的数组
	 * @param index1    数组的第一个指针
	 * @param index2    数组的第二个指针
	 * @return
	 */
	private int selectMinIndex(int[] array, int index1, int index2){
		int min = index1;
		for(int i = index1 + 1; i <= index2; ++i){
			if(array[min] > array[i]){
				min = i;
			}
		}
		return min;
	}
	
	/**
	 * 用时间复杂度为O(n)的方法实现
	 * @param array  
	 * @return
	 */
	public int minNum(int[] array){
		if(array == null)
			return -1;
		if(array.length == 0)
			return 0;
		if(array.length == 1)
			return array[0];
		int len = array.length;
		for(int i = 0;i < len - 1;i++){
			if(array[i] > array[i + 1])
				return array[i + 1];
		}
		return array[0];
	}
	
}
