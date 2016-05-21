package cn.edu.xd.sse.lab.offer;

/**
 * @author zhiyong wang
 * 题目：连续子数组的最大和
 * 题目描述：HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,
 * 常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},
 * 连续子向量的最大和为8(从第0个开始,到第3个为止)。你会不会被他忽悠住？ 
 * 要求用O(n)的时间复杂度
 */
public class FindGreatestSumOfSubArray {

	/**
	 * 特殊情况：如果数组为null或者长度为0的时候，返回结果为0
	 * 思路：维持两个值，一个是最大值，一个是当前连续子数组的和，
	 * 		当连续子数组的和小于0的时候，直接丢弃就行了，因为小于0的值加上下一个值肯定下一个值，反之，则加上下一个值作为当前值
	 * 		然后判断最大值与当前值的大小，取大的为最大值 
	 * @param array
	 * @return
	 */
	public int findGreatestSumOfSubArray(int[] array){
		if(array == null || array.length == 0)
			return 0;
		int max = Integer.MIN_VALUE;
		int current = Integer.MIN_VALUE;
		for(int i = 0; i < array.length; i++){
			if(current < 0)
				current = array[i];
			else
				current += array[i];
			if(current > max)
				max = current;
		}
		return max;
	}
}
