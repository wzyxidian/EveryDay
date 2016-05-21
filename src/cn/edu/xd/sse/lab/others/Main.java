package cn.edu.xd.sse.lab.others;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.*;

/**
 * @author zhiyong wang
 *
 */
public class Main {
	
	Executor e;
	ExecutorService es;
	AbstractExecutorService aes;
	ThreadPoolExecutor tpe;
	ScheduledExecutorService ses;
	StringBuffer sb;
	StringBuilder sbd;
	Thread t;
	ReadWriteLock rwLock;
	AbstractOwnableSynchronizer aws;
	AtomicBoolean ai;
	ThreadLocal tl;
	AbstractQueuedSynchronizer aqs;
	ReentrantReadWriteLock rrwl;
	ConcurrentHashMap chm;
	ConcurrentSkipListMap cslm;
	HashMap hm;
	ConcurrentLinkedQueue clq;
	Hashtable ht;
	AtomicInteger al;
	Stack stack;
	CopyOnWriteArrayList cowal;
	CopyOnWriteArraySet cowas;
	Lock lock;
	Object obj;
	ClassLoader cl;
	Condition cd;
	String s;
	TreeMap map;
	Callable ca;
	BigInteger big;
	ConcurrentSkipListSet csls;
	ArrayBlockingQueue abq;
	public static void main(String[] args) {
		
		System.out.println(System.currentTimeMillis());
		System.out.println(Math.random());
		System.out.println((new Random(1000)).nextInt(100));
		Scanner scan = new Scanner(System.in);
//		//输入测试组数量
		int allNum = scan.nextInt();
		String s = "abac" ;
		String ss = s.substring(0, 1);
		System.out.println(ss);
		//输入所有的测试用例
		if(allNum <= 100){
			for(int i = 0; i < allNum; i++){
				int cppNum = scan.nextInt();
				if(cppNum <=1000){
					Map map = new HashMap();
					Map map0 = new HashMap();
					Map map1 = new TreeMap();
					List list = new ArrayList();
					for(int j = 0; j < cppNum; j++){
						String cppName = scan.next();
						String[] pre = cppName.split(" ");
						
						int preNum = Integer.valueOf(pre[1]);
						if(preNum >= cppNum){
							System.out.println("ERROR"); 
							return;
						}
						map1.put(j, pre[0]);//存储所有的编译文件 及下标
						if(preNum == 0){
							map0.put(pre[0], pre[0].length());//存储不依赖文件的下标	
							list.add(pre[0].length());
						}
					}
					//对不依赖文件进行排序
					Collections.sort(list);
					
					//将具有依赖文件插入，同时排除互相依赖及依赖自己的问题
					
				}else{
					System.out.println("ERROR");
					return;
				}
			
			}
			//
		}else{
			System.out.println("ERROR");
			return ;
		}
	}
}
