
//在java语言中，首先加载的main方法，但是静态块在类被加载的时候就会被调用，所以输出为a,c,b
public class TestStatic {

	static{
		System.out.println("a");
	}
	
	public static void main(String[] args){
		System.out.println("b");
	}
	
	static{
		System.out.println("c");
	}
}
