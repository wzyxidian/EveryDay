package com.edu.xd.sse.lab.others;

import java.util.*;

/*
 * @desc ArrayList
 *
 * @author skywang
  */
 public class ArrayListRandomAccessTest {
 
     public static void main(String[] args) {
    	 String s = "ssdf";
    	 s.replace("","d");
    	 int[][] arr = new int[3][4];
    	 System.out.println(arr.length);
    	 System.out.println(arr[0].length);
    	 
         List list = new ArrayList();
         for (int i=0; i<10000000; i++)
             list.add(i);
         //isRandomAccessSupported(list);
         iteratorThroughRandomAccess(list) ;
         iteratorThroughIterator(list) ;
         iteratorThroughFor2(list) ;
     
     }
 
     private static void isRandomAccessSupported(List list) {
         if (list instanceof RandomAccess) {
             System.out.println("RandomAccess implemented!");
         } else {
             System.out.println("RandomAccess not implemented!");
         }
 
     }
 
     public static void iteratorThroughRandomAccess(List list) {
 
         long startTime;
         long endTime;
         startTime = System.currentTimeMillis();
         for (int i=0; i<list.size(); i++) {
             list.get(i);
         }
         endTime = System.currentTimeMillis();
         long interval = endTime - startTime;
        
     }
 
     public static void iteratorThroughIterator(List list) {
 
         long startTime;
         long endTime;
         startTime = System.currentTimeMillis();
         for(Iterator iter = list.iterator(); iter.hasNext(); ) {
             iter.next();
         }
         endTime = System.currentTimeMillis();
         long interval = endTime - startTime;

     }
 
 
     public static void iteratorThroughFor2(List list) {
 
         long startTime;
         long endTime;
         startTime = System.currentTimeMillis();
         for(Object obj:list)
             ;
         endTime = System.currentTimeMillis();
         long interval = endTime - startTime;
         List list1 ;
         
         HashMap a;
     }
 }