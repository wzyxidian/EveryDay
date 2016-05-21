package cn.edu.xd.sse.lab.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiyong wang
 * 题目：数组中出现次数超过一半的数字
 * 题目描述：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 		      例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 		      由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * 下面给出了三种不同的解题思路，第二种没有通过最后的提交，时间超时了，其它两种用空间换取了时间
 */
public class MoreThanHalfNum {

	public static void main(String[] args) {
		MoreThanHalfNum more = new MoreThanHalfNum();
		System.out.println(more.moreThanHalfNum_Solution1(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
	}

	/**
	 * 第一种方法：时间复杂度为O(n)，空间复杂度为O(n);
	 * 			用一个hashMap来存放每个数字及数字出现的次数，如果次数大于一半则返回，否则，返回0
	 * 缺点：需要占用空间
	 * @param array
	 * @return
	 */
	public int moreThanHalfNum_Solution(int[] array){
		if(array == null || array.length == 0)
			return 0;
		if(array.length == 1)
			return array[0];
		Map map = new HashMap();
		int length = array.length;
		int halfLength = length / 2;
		for(int i = 0; i < length; i++){
			if(map.containsKey(array[i])){
				int count = (int)map.get(array[i]) + 1;
				if(count > halfLength){
					return array[i];
				}else{
					map.put(array[i],count);
				}
			}else{
				map.put(array[i], 1);
			}
		}
		return 0;
	}

	/**
	 * 第二种方法，时间复杂度为O(n),不需要额外的空间
	 * 			因为这个数的个数大于一半的数字，所以中位数上的数字一定是这个数
	 * 			利用快排的思想，从中选择一个数，大于他的放右边，小于他的放左边，然后判断这个数的位置是否是中位数
	 * 			如果不是，继续排，直到找到中位数位置
	 * 缺点是：再遍历一遍数组，判断个数是否真大于一半，修改了原来的数组
	 * 这个地方一定要定义好partition的start 与 end，然后不断变换这两个值
	 * @param array
	 * @return
	 */
	public int moreThanHalfNum_Solution1(int[] array){
		if(array == null || array.length == 0)
			return 0;
		if(array.length == 1)
			return array[0];
		int length = array.length;
		int halfLength = length / 2;
		int start = 0;
		int end = length - 1;
		int index = partition(array, start, end);
		while(index != halfLength){
			if(index > halfLength){
				end = index - 1;
				index = partition(array, start, end);
			}else if(index < halfLength){
				start = index + 1;
				index = partition(array, start, end);
			}

		}
		boolean flag = checkMoreThanHalf(array, index);
		if(flag)
			return array[index];
		return 0;
	}
	
	/**
	 * 选择最后一位作为要排序的数组，小于他的放他的左边，大于他的放他的右边，最后求的这个数的下标
	 * 注意内部循环不要忘记了low < high的条件
	 * @param array   要排序数组
	 * @param low     数组的低位
	 * @param high    数组的高位
	 * @return
	 */
	private int partition(int[] array, int low, int high){
		int compare = array[high];
		while(low < high){
			while(array[low] < compare && low < high)
				low++;
			swap(array, low, high);
			while(array[high] >= compare && low < high)
				high--;
			swap(array, low, high);
		}
		return low;
	}
	
	/**
	 *  交换数组的两个位置的数字
	 * @param array
	 * @param x
	 * @param y
	 */
	private void swap(int[] array, int x, int y){
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}

	/**
	 * 记得求出中位数之后一定要判断这个数字的个数是否超过总数的一半,while循环一定要进行计数加操作
	 * @param array
	 * @param index
	 * @return
	 */
	private boolean checkMoreThanHalf(int[] array, int index){
		int count = 0;
		int position = index;
		int value = array[index];
		while(position >= 0){
			if(array[position] == value)
				count++;
			else
				break;
			position--;
		}
		position = index + 1;
		while(position < array.length){
			if(array[position] == value)
				count++;
			else
				break;
			position++;
		}
		return count > array.length / 2;
	}

	/**
	 * 第三种方法：时间复杂度为O(n), 空间复杂度为O(1)
	 * 			因为一个数字的个数大于一半，所有可以利用一个结果result和一个次数time来进行遍历
	 * 			如果当前数字和上一个相同，则time加1，如果不同则time减1，如果遇到time是0，则将当前遍历值赋给result，time加1
	 * 			得到的最后的结果就是出现次数最多的，time这里只用作判断比较之用，不记录最后出现的最多个数
	 * 缺点是：再遍历一遍数组，判断个数是否真大于一半
	 * @param array
	 * @return
	 */
	public int moreThanHalfNum_Solutions2(int[] array){
		if(array == null || array.length == 0)
			return 0;
		if(array.length == 1)
			return array[0];
		int length = array.length;
		int halfLength = length / 2;
		int result = 0;
		int time = 0;
		for(int i = 0; i < length; i++){
			if(time == 0){
				result = array[i];
				time = 1;
			}else{
				if(array[i] == result)
					time++;
				else
					time--;
			}
		}

		if(checkMoreThanHalf1(array, result))
			return result;
		return 0;
	}

	/**
	 * 同上一个方法，判断个数是否大于一半
	 * @param array
	 * @param result
	 * @return
	 */
	private boolean checkMoreThanHalf1(int[] array, int result){
		int count = 0;
		for(int i = 0; i < array.length; i++){
			if(array[i] == result)
				count++;
		}
		return count * 2 > array.length;
	}

	/**
	 * 同上一个方法，判断个数是否大于一半
	 *
	 * @param array
	 * @param result
	 * @return
	 */
	private boolean checkMoreThanHalf1(int[] array, int result) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == result)
				count++;
		}
		return count * 2 > array.length;
	}
}
