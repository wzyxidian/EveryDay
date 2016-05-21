package cn.edu.xd.sse.lab.offer;

/**
 * @author zhiyong wang
 *输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 *使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分
 */
public class ReOrderArray {
	
	/**
	 * 采用两个指针，font从前往后走，遇到偶数，然后last从后往前走，遇到基数，这时候把奇偶进行交换
	 * 继续进行上述步骤
	 * @param array
	 */
	public void reOrderArray(int[] array){
		if(array == null || array.length == 0 || array.length == 1)
			return ;
		int len = array.length;
		int font = 0;
		int last = len - 1;
		while(font < last){
			while(font < last && (array[font] & 1) == 1)
				++font;
			while(font < last && (array[last] & 1) == 0)
				--last;
			swap(array, font, last);
		}
	}
	
	/**
	 * 交换数据
	 * @param array
	 * @param font
	 * @param last
	 */
	public void swap(int[] array, int font, int last){
		int temp = array[font];
		array[font] = array[last];
		array[last] = temp;
	}
}
