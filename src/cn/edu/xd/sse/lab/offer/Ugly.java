package cn.edu.xd.sse.lab.offer;

/**
 * @author zhiyong wang
 * 题目：丑数
 * 题目描述：把只包含因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含因子7。 
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。 
 */
public class Ugly {

	/**
	 * 从1开始遍历，判断每一个数是否是丑数，如果是则丑数个数加1，直到求得的是第index个丑数为止
	 * 没有空间复杂度，时间复杂度较高，因为不是丑数的那些数也都进行遍历了，
	 * 最后的结果是时间超时，没有提交程序成功
	 * @param index
	 * @return
	 */
	public int getUglyNumber(int index){
		if(index < 1)
			return 0;
		if(index == 1)
			return 1;
		int count = 1;
		int num = 2;
		while(count < index){
			++num;
			if(isUglyNumber(num))
				count++;
		}
		return num;
	}
	
	/**
	 * 判断是否是丑数的方法，对2,3,5分别多次取整，如果最后的结果是1，说明只包含2,3,5这三种因子，是丑数
	 * @param num
	 * @return
	 */
	public boolean isUglyNumber(int num){	
		while(num % 2 == 0)
			num  /= 2;
		while(num % 3 == 0)
			num /= 3;
		while(num % 5 == 0)
			num /= 5;
		return num == 1;
	}
	
	/**
	 * 这是比较好的解，用空间换取了时间的效率，新增加的空间为O(n);时间复杂度为O(n)
	 * 思路：大丑数的因子肯定都是丑数，所以大丑数是由小丑数组成的，
	 * 		最小的丑数是1，然后是分别乘以2，或者3，或者5，之后的三个丑数里面的最小丑数作为下一个丑数，
	 * 		这样的话就需要为2,3,5分别维持一个下标，这个下标指向丑数的结果数组，
	 * 		举例：如果2的当前下标指向的丑数乘以2，比3的当前下标指向的丑数乘以3，比5的当前下标指向的丑数乘以5都小，那么
	 * 			下一个丑数就是2的当前下标指向的丑数乘以2的结果，2的下标向前移动一位，其他的也是同理
	 * @param index
	 * @return
	 */
	public int getUglyNumber_Solution(int index){
		if(index < 1)
			return 0;
		if(index == 1)
			return 1;
		int[] result = new int[index];  //丑数的结果数组
		result[0] = 1;       //最小的丑数是1
		int position2 = 0;   //2的初始小标
		int position3 = 0;   //3的初始下标
		int position5 = 0;   //5的初始下标
		for(int i = 1; i< index; ++i){
			result[i] = min(result[position2] * 2, result[position3] * 3, result[position5] * 5);
			if(result[i] == result[position2] * 2)
				++position2;
			if(result[i] == result[position3] * 3)
				++position3;
			if(result[i] == result[position5] * 5)
				++position5;
		}
		return result[--index];
	}
	
	/**
	 * 求三个数值的最小值
	 * @param r2
	 * @param r3
	 * @param r5
	 * @return
	 */
	private int min(int r2, int r3, int r5){
		int min = r2 < r3 ? r2 : r3;
			min = min < r5 ? min : r5;
		return min;
	}
}
