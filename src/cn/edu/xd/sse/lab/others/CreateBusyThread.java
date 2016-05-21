package cn.edu.xd.sse.lab.others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * @author zhiyong wang
 *
 */
public class CreateBusyThread {
	public static void createBusyThread(){
		Thread thread = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				while(true)
					;
					
			}
			
		},"testBusyThread");
		thread.start();
	}
	
	public static void createLockThread(final Object lock){
		Thread thread = new Thread(new Runnable(){

			String s = new String("UTF-8");

			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized (lock){
					try{
						lock.wait();
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		},"testLockThread");
		thread.start();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		createBusyThread();
		br.readLine();
		Object obj = new Object();
		createLockThread(obj);
	
	}
}
