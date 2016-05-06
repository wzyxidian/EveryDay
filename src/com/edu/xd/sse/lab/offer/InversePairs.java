package com.edu.xd.sse.lab.offer;

/**
 * @author zhiyong wang
 * 题目：数组中的逆序对
 * 题目描述：在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数。 
 */
public class InversePairs {

	/**
	 * 为了可以在O(nlgn)时间复杂度内完成统计，可以使用归并排序的思想，一边排序，一边统计
	 * @param array
	 * @return
	 */
	public int inversePairs(int[] array){
		if(array == null || array.length == 0)
			return 0;
		int len = array.length - 1;
		return mergeSort(array, 0, len);
	}
	
	/**
	 * 归并排序的思想，先求中间下标，然后分别继续对两边数组递归，left左边求得的逆序对个数，right右边求得的逆序对个数
	 * 再加上合并左右后求得逆序对个数，最为这一部分逆序对个数的和
	 * @param array   数组
	 * @param l       待比较数组的最左边值下标
	 * @param r       待比较数组的最右边值下标
	 * @return
	 */
	private int mergeSort(int[] array, int l, int r){
		if(l >= r)
			return 0;
		int mid = (l + r) / 2;
		int left = mergeSort(array, l, mid);
		int right = mergeSort(array, mid + 1, r);
		
		return left + right + merge(array, l, mid, r);
	}
	
	/**
	 * 这里开辟了r-l+1个大小的临时空间，用于存放排序后的结果，不过最后都要复制到原来的数组
	 * 比较的是左右两个部分，左边开始的下标是左边数组的最后一位，右边开始的下标是右边数组的最后一位
	 * 如果左边当前位start的值大于右边当前位end的数值时，逆序对增加的个数为 end - mid，因为既然start位置大于右边的最大值，
	 * 那么他肯定大于mid+1 到end之间的所有数值，因为他们都是已经递归排好序的，所以增加个数为end-mid,
	 * 如果左边当前位start的值小于右边当前位end的数值时，count值无变化，只是把end对应的值复制给临时空间的当前位
	 * 第一个循环结束之后，说明左边或者右边的数组都给排完了，第二个循环是在左边数组没有排完的情况下进行
	 * 第三个循环是在右边数组没有排完的情况下进行，这两个循环都没有比较，所有逆序对个数不用增加
	 * 最后将临时空间的值赋值给原数组
	 * @param array
	 * @param l
	 * @param mid
	 * @param r
	 * @return
	 */
	private int merge(int[] array, int l, int mid, int r){
		int start = mid; //从左数组最后一位开始往前遍历
		int end = r;     //从右数组最后一位开始往前遍历
		int count = 0;   //逆序对初始化为0个
		int[] temp = new int[r - l + 1];  //开辟的临时空间，用于存放排序后的结果
		int index = r - l;                //临时空间从后往前进行插入数值
		while(start >= l && end > mid){
			if(array[start] > array[end]){
				count += end - mid;
				temp[index--] = array[start--];
			}else{
				temp[index--] = array[end--];
			}
			
		}
		while(start >= l){
			temp[index--] = array[start--];
		}
		while(end > mid){
			temp[index--] = array[end--];
		}
		System.arraycopy(temp, 0, array, l, r - l + 1);
		return count;
	}
	
}
