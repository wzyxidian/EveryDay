package cn.edu.xd.sse.lab.offer;

/**
 * @author zhiyong wang
 *
 *
 * 题目描述
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 * 
 */
public class Fibonacci {

	/**
	 * 测试用例
	 * @param args
	 */
	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		System.out.println(f.fibonacci(6));
		System.out.println(f.fibonacci(7));
		System.out.println(f.fibonacci(0));
//		System.out.println(f.fibonacci(50));
		System.out.println(f.fibonacci1(6));
		System.out.println(f.fibonacci1(7));
		System.out.println(f.fibonacci1(0));
		System.out.println(f.fibonacci1(40));

	}

	/**
	 * 递归求解
	 * @param n 求第n个数的菲波那切数列
	 * @return
	 */
	public long fibonacci(int n){
		if(n < 2)
			return n == 0 ? 0 : 1;
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
	
	/**
	 * 用循环来求解，提高效率
	 * @param n
	 * @return
	 */
	public int fibonacci1(int n){
		int small = 0;
		int big = 1;
		int result = 0;
		if(n < 2)
			return n == 0 ? small : big;
		for(int i = 2;i <= n; ++i){
			result = small + big;
			small = big;
			big = result;
		}
		return result;
	}
}
