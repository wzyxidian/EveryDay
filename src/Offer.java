import java.math.BigDecimal;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;


public class Offer{
	
	public BigDecimal bd;
	class Node{
		int a;
		Node next;
		public Node(int a, Node node){
			this.a = a;
			this.next = node;
		}
	}
	
	public List<Node> buildLinked(){
		return null;
	}
	//5.从尾向前打印链表
	//用栈实现
	public void stackPrint(LinkedList<Node> node){
		
	}
	
	//剑指offer 面试题第22题
	public boolean inPopOrder(int[] arr1, int[] arr2){
		if(arr1 == null || arr2 == null || arr1.length == 0 || arr2.length == 0 || arr1.length != arr2.length)
			return false;
		if(arr1.length == 1 && arr2.length == 1)
			return arr1[0] == arr2[0];
		 Stack<Integer> stack = new Stack<Integer>(); //这里需要用到辅助栈
		 
          for (int i = 0, j = 0; i < arr1.length; i++) {
              stack.push(arr1[i]);
 
              while (stack.size() > 0 && stack.peek() == arr2[j]) {
                  stack.pop();
                  j++;
              }
         }
         return stack.size() == 0;
	}
	
	
	public static void main(String[] args) {
//		int a = Integer.MAX_VALUE;
//		double d1 = 0.22222244;
//		double d2 = 0.222222440000000001;
//		if(d1 == d2) System.out.println("true");
//	    if(new BigDecimal(d1).compareTo(new BigDecimal(d2)) == 0) System.out.println("true");else System.out.println("false");
		int x = 1;
		int y = 2;
		int z = 3;
		System.out.println(y += z--/++x);
		StringTokenizer s1 = new StringTokenizer("ss ss ss ss aa ");
		while(s1.hasMoreTokens()){
			System.out.println(s1.nextToken());
		}
		String s2 = "ass";
		s2.length();
		int[] arr1 = {1,2,3,4,5};
		
		int[] arr2 = {4,5,3,2,1};
		Offer offer = new Offer();
		if(offer.inPopOrder(arr1, arr2)) System.out.println("true");
//		Deque d = new LinkedList();
//	
//		Stack<Integer> s = new Stack();
//		s.push(3);
//		s.push(2);
//		s.push(1);
//		for(int i : s){
//			System.out.print(i +" ");
//		}
//		HashMap map;
		
	}
	
}
