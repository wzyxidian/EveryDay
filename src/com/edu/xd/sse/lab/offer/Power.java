package com.edu.xd.sse.lab.offer;

/**
 * @author zhiyong wang
 *
 *
 * 题目描述
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 
 */
public class Power {

	/**
	 * 这个题注意几个地方：（1）base<0,exponent==0的情况要单独进行考虑，否则会报异常
	 * （2）exponent是否是小于0的情况，如果小于0，则先求值，求完之后在取反
	 * （3）double比较相等的时候，不能用==,而用相减小于给定值，才算相等
	 * （4）求指数的时候，可以用递归来进行就平方操作，如是基数，再乘以一个底数
	 * @param base
	 * @param exponent
	 * @return
	 */
	public double power(double base, int exponent){
		if(equal(base,0.0) && exponent < 0)
			return 0;
		int absExponent = exponent;
		if(exponent < 0)
			absExponent = -exponent;
		double result = pow(base, absExponent);
		if(exponent < 0)
			result = 1.0 / result;
		return result;
	}
	
	/**
	 * 判断两个double值是否相等
	 * @param d1
	 * @param d2
	 * @return
	 */
	private boolean equal(double d1, double d2){
		if(d1 - d2 >= -0.0000001 && d1 - d2 <= 0.0000001)
			return true;
		else
			return false;
	}
	
	/**
	 * 递归求指数运算
	 * @param base
	 * @param exponent
	 * @return
	 */
	private double pow(double base, int exponent){
		if(exponent == 0)
			return 1;
		if(exponent == 1)
			return base;
		double result = pow(base, exponent >> 1);
		result *= result;
		if((exponent & 1) == 1)
			result *= base;
		return result;
	}
	
	public static void main(String[] args) {
		Power p = new Power();
		System.out.println(p.power(3, -2));;
//		System.out.println(Math.pow(3, -2));
	}
}
