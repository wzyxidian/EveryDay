package cn.edu.xd.sse.lab.others;

/**
 * @author zhiyong wang
 *
 */
public class SynAddRunalbes {

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			new Thread(new SynAddrunalbe(1, 2)).start();
			new Thread(new SynAddrunalbe(2, 1)).start();
		}
	}
	
	static class SynAddrunalbe implements Runnable{
		int a,b;
		public SynAddrunalbe(int a,int b){
			this.a = a;
			this.b = b;
		}
		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			// TODO Auto-generated method stub
			synchronized(Integer.valueOf(a)){
				synchronized (Integer.valueOf(b)) {
					System.out.println(a+b);
				}
			}
		}
	}
}
