package cn.edu.xd.sse.lab.offer;

import java.util.*;

/**
 * @author zhiyong wang
 *
 */
public class FindNumbersAppearOnce {

	/**
	 * 第一种方法：
	 * 使用额外的空间来进行存储，HashMap来进行存储，key存储的数值，value存储的数值出现的次数
	 * 遍历两遍：第一遍遍历数组记录每个数值及出现的次数；第二遍遍历hashMap，找到只出现一次key值
	 *
	 * @param array
	 * @param num1
	 * @param num2
	 */
	public void findNumberAppearOnce(int [] array, int num1[], int num2[]) {
		if (array == null || array.length < 2)
			return ;
	        Map map = new HashMap();
	        int i = 0;
	        int len = array.length;
	        while(i < len){
	            if(map.containsKey(array[i]))
	                map.put(array[i], (int)map.get(array[i]) + 1);
	            else
					map.put(array[i], 1);
				++i;						//注意这个地方不要忘记，总是忘记递增
			}
	        List list = new ArrayList<Integer>();
	        Iterator it = map.keySet().iterator();
		while (it.hasNext()) {
			int key = (Integer) it.next();   //这个地方注意是通过it.next()获取他的值，也就是key值
			if ((int) map.get(key) == 1) {
				list.add(key);            //这里add的是key值不是it.next
			}
	        }
	        num1[0] = (int) list.get(0);
	        num2[0] = (int) list.get(1);
	}

	/**
	 * 第二种方法：
	 * 思路：第一步：把所有的值进行异或操作，因为有两个值只出现了一此，所以结果中肯定存在1
	 * 第二步：对刚才求的结果从右向左进行判断是否是1，找到1出现的位置
	 * 第三步：根据1出现的位置，对整个数组进行遍历，并对每个值向右移动第二步中求得的位数，然后与1相与，将所有相与后为1的数据进行异或操作，
	 * 将所有相与后为0的进行异或操作就可以分别把两个值就出来
	 *
	 * @param array
	 * @param num1
	 * @param num2
	 */
	public void findNumberAppearOnce1(int[] array, int[] num1, int[] num2) {
		if (array == null || array.length < 2)
			return;
		num1[0] = 0;
		num2[0] = 0;
		int midResult = xor(array);
		int position = firstOneposition(midResult);
		if (position == -1)
			return;
		for (int i = 0; i < array.length; i++) {
			if (((array[i] >> position) & 1) == 1) {
				num1[0] ^= array[i];
			} else
				num2[0] ^= array[i];
		}
	}

	/**
	 * 异或操作
	 *
	 * @param array
	 * @return
	 */
	private int xor(int[] array) {
		int i = 0;
		int result = 0;
		int length = array.length;
		while (i < length) {
			result ^= array[i];
			++i;
		}
		return result;
	}

	/**
	 * 从右向左求得第一次出现1的位置
	 *
	 * @param midResult
	 * @return
	 */
	private int firstOneposition(int midResult) {
		int i = 0;
		while (i < 32) {
			if ((midResult & 1) == 1) {
				return i;
			}
			++i;
			midResult = midResult >> 1;
			}
			return -1;
		}
}
