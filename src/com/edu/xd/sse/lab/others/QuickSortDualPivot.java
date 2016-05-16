package com.edu.xd.sse.lab.others;

public class QuickSortDualPivot {
 
	public static void main(String[] args) {
		int[] a = {3,2,4,1,4,5,1,6,7};
		QuickSortDualPivot q = new QuickSortDualPivot();
		q.quickSort(a);
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}
	
	//交换两个数
	private void swap(int[] arr, int i,int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
  public void quickSort (int[] input){
      //input=shuffle(input);
	  quickSort2 (input, 0, input.length-1);
  }
 
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
}