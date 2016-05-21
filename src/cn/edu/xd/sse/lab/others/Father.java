package cn.edu.xd.sse.lab.others;

/**
 * @author zhiyong wang
 *
 */
public class Father {

	static {
		System.out.println("parent static");
	}

	public static void main(String[] args) {
		Father f = new Father();
		Child c = f.new Child();
	}

	class Parent{
		Child1 c = new Child1();

		Parent(){
			System.out.println("father");
		}
	}

	class Child1{
		Child1(){
			System.out.println("child1");
		}
	}

	class Child extends Parent{
		Child1 c = new Child1();
		Child(){
			System.out.println("child");
		}
	}
}
