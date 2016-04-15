package com.edu.xd.sse.lab.baidu;

/**
 * @author zhiyong wang
 *	基本数据类型封装类的常量池
 *  Boolean, Byte, Character, Short, Integer, Long
 *  String 也实现了常量池
 */
public class BasicDataCache {

	public static void main(String[] args){
		Integer a1  = new Integer(123);
		Integer a2  = new Integer(123);		
		System.out.println(a1 == a2);
		
		a1  = 123;
		a2  = 123;
		System.out.println(a1 == a2);
		
		a1  = 234;
		a2  = 234;
		System.out.println(a1 == a2);
		
		int a3  = new Integer(123);
		int a4  = new Integer(123);
		System.out.println(a1 == a2);
		
		a3 = 123;
		a4 = 123;
		System.out.println(a3 == a4);
		
		a3 = 234;
		a4 = 234;
		System.out.println(a3 == a4);
		
		Integer a5 = new Integer(0);
		System.out.println(a1 == a2 + a5);
		
		
		//String常量池
		String s1 = "Hello";
		String s2 = "Hello";
		String s3 = "Hel" + "lo";
		String s4 = "Hel" + new String("lo");
		String s5 = new String("Hello");
		String s6 = s5.intern();
		String s7 = "H";
		String s8 = "ello";
		String s9 = s7 + s8;
		          
		System.out.println(s1 == s2);  // true
		System.out.println(s1 == s3);  // true
		System.out.println(s1 == s4);  // false
		System.out.println(s1 == s9);  // false
		System.out.println(s4 == s5);  // false
		System.out.println(s1 == s6);  // true
		
		
		Integer a  = 1;
		Integer b  = 2;
		Integer c =  3;
		Integer d = 3;
		Integer e = 321;
		Integer f = 321;
		Long g = 3L;
		System.out.println(c == d);
		System.out.println(e == f);
		System.out.println(c == (a+b));
		System.out.println(c.equals(a + b));
		System.out.println(g == (a + b));
		System.out.println(g.equals(a + b));
	}
}
