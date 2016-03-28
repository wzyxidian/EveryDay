import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/*
 * @desc ArrayList
 *
 * @author skywang
  */
 public class ArrayListRandomAccessTest {
 
     public static void main(String[] args) {
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