
public class Sort {
	
	//交换两个数
	private void swap(int[] arr, int i,int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	//普通版冒泡排序,时间复杂度为O(n^2),稳定的排序算法
	public void bubbleSort(int[] arr){
		for(int i=0;i<arr.length-1;i++){
			for(int j=arr.length-2;j>=i;j--){
				if(arr[j] > arr[j+1])
					swap(arr, j, j+1);
			}
		}		
	}
	
	//改进版的冒泡排序
	public void bubble2Sort(int[] arr){
		boolean flag = true;
		for(int i=0;i<arr.length-1 && flag;i++){
			flag = false;
			for(int j=arr.length-2;j>=i;j--){
				if(arr[j] > arr[j+1]){
					swap(arr, j, j+1);
					flag = true;
				}
			}
		}
	}
	
	//简单选择排序,时间复杂度为O(n^2),稳定的排序算法，性能上优于冒泡，移动次数少，最多移动n-1次
	public void selectSort(int[] arr){
		int min;
		for(int i=0;i<arr.length-1;i++){
			min = i;
			for(int j=i+1;j<arr.length;j++){
				if(arr[min] > arr[j])
					min = j;
			}
			if(min != i)
				swap(arr,i,min);
		}
	}
	
	//直接插入排序，稳定的排序算法，比较、移动的时间复杂度为O(n^2)
	public void insertSort(int[] arr){
		for(int i=1;i<arr.length;i++){
			int temp = arr[i];
			int j;
			for(j=i-1;j>=0&&arr[j]>temp;j--)
				arr[j+1] = arr[j];
			arr[j+1] = temp;
		}
	}
	
	//双点直接插入排序，稳定的排序算法,不是从开始进行的排序
	public void insertSort2(int[] arr,int left, int right){
		for(int i=left;++left<=right;i=++left){
			int a1 = arr[i];
			int a2 = arr[left];
			if(a1<a2){
				a2 = a1;
				a1 = arr[left];
			}
			while(a1 < arr[--i]){
				arr[i+2] = arr[i];
			}
			arr[++i + 1] = a1;
			while(a2 < arr[--i]){
				arr[i+1] = arr[i];
			}
			arr[i+1] = a2;
		}
			int last = arr[right];
			while(last < arr[--right])
				arr[right+1] = arr[right];
			arr[right+1] = last;
	}
	
	//希尔排序，不是稳定的排序算法，是对插入排序的升级版，最好可以达到O(n^(3/2)),不好可以是O(n^2)
	public void shellSort(int[] arr){
		for(int gap=arr.length/2;gap>0;gap /= 2){
			for(int i=0;i<gap;i++){
				for(int j=i+gap;j<arr.length;j += gap){
					if(arr[j]<arr[j-gap]){
						int temp = arr[j];
						int k = j - gap;
						while(k>=0 && arr[k]>temp){
							arr[k+gap] = arr[k];
							k -= gap;
						}
						arr[k+gap] = temp;
					}
				}
			}
		}
	}
	
	//堆排序，时间复杂度为O(nlogn)，不适合待排列个数较少的情况
	public void heapSortAsc(int[] arr){
		for(int i=arr.length/2-1;i>=0;i--){
			heapAdjust(arr,i,arr.length-1);
		}
		for(int i=arr.length-1;i>0;i--){
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapAdjust(arr,0,i-1);
		}
	}
	
	//建堆与调整堆的过程
	private void heapAdjust(int[] arr, int start, int end){
		int c = start;
		int lChild = 2 * c + 1;
		int temp = arr[c];
		for(; lChild <= end; c = lChild, lChild = 2 * lChild + 1){
			if(lChild < end && arr[lChild] < arr[lChild + 1])
				lChild++;
			if(arr[lChild] < temp){
				break;
			}	
			else{
				arr[c] = arr[lChild];
				arr[lChild] = temp;
			}
		}
	}
	
	//归并排序，稳定的排序方法，比较占内存，时间复杂度为O(nlogn)
	//归并排序分为两个部分，分解与合并，从上往下的排序
	public void mergeSortUp2Down(int[] arr, int start, int end){
		if(arr == null || start >= end)
			return;
		int mid = (start + end) / 2;
		mergeSortUp2Down(arr,start,mid);
		mergeSortUp2Down(arr, mid+1, end);
		
		merge(arr,start,mid,end);
	}
	//归并排序的合并部分
	public void merge(int[] arr, int start, int mid, int end){
		int i = start;
		int j = mid + 1;
		int k = 0;
		int[] temp = new int[end-start+1];
		while(i<=mid && j <= end){
			if(arr[i] <= arr[j])
				temp[k++] = arr[i++];
			else
				temp[k++] = arr[j++];
		}
		while(i <= mid)
			temp[k++] = arr[i++];
		while(j <= end)
			temp[k++] = arr[j++];
		for(i=0;i<k;i++){
			arr[start+i] = temp[i];
		}
		
	}
	
	//从下往上的排序，
	public void mergeSortDown2Up(int[] arr){
		if(arr == null)
			return;
		for(int i=1;i<arr.length;i *= 2)
			mergeGroups(arr, arr.length,i);
	}
	
	//对数组进行若干次排序
	public void mergeGroups(int[] arr, int len, int gap){
		int i;
		for(i=0;i+2*gap-1<len;i = i+2*gap){
			merge(arr,i,i+gap-1,i+2*gap-1);
		}
		if(i+gap-1<len-1)
			merge(arr,i,i+gap-1,len-1);
	}
	
	//快速排序，不稳定的排序算法，时间复杂度为O(nlogn),可以充分利用这个位置k,还可以用来查找第k大的数据，最小的k个数，出现次数超过一半的数字
	public void quickSort(int[] arr, int low, int high){
		int pivot;
		if(low < high){
			pivot = partition(arr,low,high);
			quickSort(arr,low,pivot-1);
			quickSort(arr,pivot+1,high);
		}
	}
	
	//快速排序，进行位置交换
	private int partition(int[] arr, int low, int high){
		int pivot = arr[low];
		while(low < high){
			while(low < high && arr[high] >= pivot)
				high--;
			swap(arr,low,high);
			while(low < high && arr[low] < pivot)
				low++;	
			swap(arr,low,high);
		}
		return low;	
	}
	
	//双基准的快速排序算法	 
    private void quickSort2(int[] arr, int lowIndex, int highIndex) {
      if(lowIndex >= highIndex) return;
      int pivot1 = arr[lowIndex];
      int pivot2 = arr[highIndex];
      if(pivot1 > pivot2){
    	  arr[lowIndex] = pivot2;
    	  arr[highIndex] = pivot1;
    	  pivot1 = arr[lowIndex];
    	  pivot2 = arr[highIndex];
      }else if(pivot1 == pivot2){
    	  while(pivot1 == pivot2 && lowIndex <= highIndex){
    		  pivot1 = arr[++lowIndex];
    	  }
      }
      int i = lowIndex + 1;
      int lt = lowIndex + 1;
      int gt = highIndex - 1;
      while(i<=gt){
    	  if(pivot1 > arr[i]){
    		  swap(arr,lt++,i++);
    	  }else if(pivot2 < arr[i]){
    		  swap(arr,i,gt--);
    	  }else{
    		  i++;
    	  }
      }
      swap(arr,lowIndex,--lt);
      swap(arr,highIndex,++gt);
      quickSort2(arr,lowIndex,lt-1);
      quickSort2(arr,lt+1,gt-1);
      quickSort2(arr,gt+1,highIndex);
  }
	
    //桶排序,时间复杂度为O(n),需要额外的常数空间
    public void bucketSort(int[] arr, int max){
    	if(arr == null || max < 1) return ;
    	int[] buckets = new int[max];
    	for(int i=0;i<arr.length;i++)
    		buckets[arr[i]]++;
    	for(int i=0, j=0;i<max;i++)
    		while((buckets[i]--)>0)
    			arr[j++] = i;
    }
    
    //计数排序，稳定的排序算法，桶排序另一种，时间复杂度为O(n)
    public void countSort(int[] arr, int max){
    	int[] result = new int[arr.length];
    	int[] temp = new int[max];
    	for(int i=0;i<arr.length;i++){
    		temp[arr[i]]++;
    	}
    	for(int i=1;i<temp.length;i++){
    		temp[i] += temp[i-1];
    	}
    	for(int i=0;i<temp.length;i++)
    		temp[i] -= 1;
    	for(int i=arr.length-1;i>=0;i--){
    		result[temp[arr[i]]--] = arr[i];
    	}
    	System.arraycopy(result, 0, arr, 0, arr.length);   	
    }
    //基数排序，桶排序的升级版，利用计数排序来做
    public void radixSort(int[] arr, int max){
    	for(int exp=1;max/exp>0;exp *= 10){
    		countSort1(arr,exp);
    	}
    }
	//基数排序调用计数排序
    public void countSort1(int[] arr, int exp){
    	int[] temp = new int[10];
    	int[] result = new int[arr.length];
    	for(int i=0;i<arr.length;i++)
    		temp[(arr[i]/exp)%10]++;
    	for(int i=1;i<10;i++)
    		temp[i] += temp[i-1];
    	for(int i=0;i<10;i++)
    		temp[i]--;
    	for(int i=arr.length-1;i>=0;i--)
    		result[temp[((arr[i]/exp)%10)]--] = arr[i];
    	System.arraycopy(result, 0, arr, 0, arr.length);
    }
   
    
	public static void main(String[] args) {
		Sort sort = new Sort();
		int[] arr = {3,2,4,1,4,5,1,6,7};
		sort.quickSort2(arr,0,7);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i] + " ");
		}
	}
}
