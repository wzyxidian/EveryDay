import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TestArrays {

	public static void output(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int[] arr = new int[5];
		//填空数组，将数组中的每个元素都赋值为5
		Arrays.fill(arr, 5);
		TestArrays.output(arr);
		
		//将数组中从第二个元素到第四个元素，（包括第二，不包括第四）都赋值为2
		Arrays.fill(arr, 2, 4, 2);//包前，不包后
		TestArrays.output(arr);
		
		int[] arr1 = {5,2,3,5,4,6,1,0};
		
		//将数组的从第0个元素到第四个元素（包括第0个元素，不包括第四个元素），进行从小到大排序
		Arrays.sort(arr1, 0, 4);//包前，不包后
		TestArrays.output(arr1);
		
		//将整个数组从小到大进行排序
		Arrays.sort(arr1);
		TestArrays.output(arr1);
		
		//新建一个list并返回
		ArrayList alist = null;
		List larr = Arrays.asList(alist);
		
		//使用二分查找指定位置的元素
		System.out.println(Arrays.binarySearch(arr1, 4));
		
		//新建一个长度为12（这个长度要比原有的数组长度大）的数组，然后将arr1数组中的数据都复制到新数组中，然后将新数组的首地址返回
		arr1 = Arrays.copyOf(arr1, 12);
		TestArrays.output(arr1);
		
		//将数组中的元素转换为String类型
		System.out.println(Arrays.toString(arr1));
		
		//将数组中的部分数据复制到新建的数组中
		int[] arr2 = Arrays.copyOfRange(arr1, 3, 16);
		TestArrays.output(arr2);
		
		//判断两个数组是否相等
		System.out.println(Arrays.equals(arr1, arr2));
		arr2 = arr1.clone();
		System.out.println(Arrays.equals(arr1, arr2));
		
		
	}
}
