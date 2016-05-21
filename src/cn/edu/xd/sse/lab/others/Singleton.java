package cn.edu.xd.sse.lab.others;
//饿汉式模式，本身是线程安全的
/**
 * 
 * @author zhiyong wang
 * 注意几个地方：1.首先新建一个私有的构造器2.定义一个私有的，静态的，final的，Singleton对象，并完成初始化操作
 * 3.定义一个public的，静态的方法，返回类型为Singleton的方法，直接返回实例对象即可
 *
 */
public class Singleton {

	private static final Singleton instance = new Singleton();

	private Singleton() {
	}

	public static Singleton getInstance(){
		return instance;
	}
}
