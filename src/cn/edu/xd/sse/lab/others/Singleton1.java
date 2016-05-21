package cn.edu.xd.sse.lab.others;

//懒汉式模式，本身不是线程安全的，需要进行操作
public class Singleton1 {

	private Singleton1(){}

	public static final Singleton1 getInstance(){
		return LazyHolder.instance;
	}

	private static class LazyHolder {
		private static final Singleton1 instance = new Singleton1();
	}
}
