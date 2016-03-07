//查找
public class Search {
	/*
	 * 有序查找：折半查找、插值查找、斐波那契查找
	 */
	//折半查找,必须是排好序的，时间复杂度为O(nlogn),旋转数组求最小数字也可以用二分法（注意三个值相等的情况，用顺序查找法）
	public int BinarySearch(int[] arr, int key){
		int low = 0;
		int high = arr.length-1;
		while(low <= high){
			int mid = (low + high) / 2;
			if(arr[mid] > key)
				high = mid - 1;
			else if(arr[mid] < key)
				low = mid + 1;
			else 
				return mid;
		}
		return -1;
	}
	//插值查找法，改进的折半查找，适合表长，关键字分布比较均匀，但是有四则运算的过程
	//改进的是求mid的值：mid = (high - low) * (key -arr[low])/(arr[high]-arr[low])
	//斐波那契搜索明显优点在于他只涉及到加减操作，没有涉及到除法运算
	public int fibonacciSearch(int[] arr, int key){
		int[] f = new int[10];
		for(int i=0;i<f.length;i++)
			f[i] = fibonacciBuild(i);
		int low = 0;
		int high = arr.length - 1;
		int mid;
		int k = 0;
		//问题一：这个查找high在斐波那契数列中的位置，为什么是F[k] - 1,而不是F[k]？  
		/*
		 * 首先要明确：如果一个有序表的元素个数为n,并且n正好是（某个斐波那契数 - 1），即n=F[k]-1时，才能用斐波那契查找法。 
		 * 如果有序表的元素个n不等于（某个斐波那契数 - 1），
		 * 即n≠F[k]-1，这时必须要将有序表的元素扩展到大于n的那个斐波那契数 - 1才行
		 */
		while(high > f[k]-1)
			k++;
		int distance = f[k]-1 - high;
		int[] b = new int[high + distance];
		System.arraycopy(arr, 0, b, 0, arr.length);
		for(int i=high;i<f[k]-1;i++)
			b[i] = b[high];
		 
	    //还有这个判断，当键值小于a[mid]时，就在[low, F[k - 1] - 1]范围内查找  
	    //当键值大于a[mid]时，就在[F[k - 2] - 1]范围内查找，这个依据是什么？ 
		/*
		 * 对于二分查找，分割是从mid= (low+high)/2开始；而对于斐波那契查找，分割是从mid = low + F[k-1] - 1开始的； 
		 * 通过上面知道了，数组a现在的元素个数为F[k]-1个，即数组长为F[k]-1，mid把数组分成了左右两部分， 
		 * 左边的长度为：F[k-1] - 1，
		 *  那么右边的长度就为（数组长-左边的长度-1），
		 *  即：（F[k]-1） - （F[k-1] - 1） = F[k] - F[k-1] - 1 = F[k-2] - 1。
		 */
		while(low <= high){
			mid = low + f[k-1] - 1;
			if(b[mid] > key){
				high = mid - 1;
				k = k - 1;
			}else if(b[mid] < key){
				low = mid + 1;
				k = k - 2;
			}else{
				if(mid <= arr.length-1)
					return mid;
				else 
					return arr.length - 1;
			}
		}
		return -1;
	}
	
	//构建斐波那契数列
	public int fibonacciBuild(int i){
		if(i<2)
			return i == 0 ? 0 : 1;
		return fibonacciBuild(i-1) + fibonacciBuild(i - 2);
	}
	
	
	
	public static void main(String[] args) {
		Search search = new Search();
		int[] arr = {1,2,4,5,6,7,8,9,10};
		int index = search.fibonacciSearch(arr, 8);
		System.out.println(index);
	}
}
