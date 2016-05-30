package cn.edu.xd.sse.lab.offer;

/**
 * Created by zhiyongwang on 2016/5/21.
 * 题目：构建乘积数组
 * 题目描述：给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class Multiply {

    final static int[] sizeTable = {9, 99, 9999, Integer.MAX_VALUE};

    public static void main(String[] args) {
        String s;
        StringBuffer sbu;
        StringBuilder sbd;
        String.valueOf(true);
        System.out.println(stringSize1(123));

    }

    static int stringSize(int x) {
        for (int i = 0; ; i++) {
            if (x <= sizeTable[i])
                return i + 1;
        }
    }

    static int compareTo(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int lim = Math.min(len1, len2);
        char[] charS1 = s1.toCharArray();
        char[] charS2 = s2.toCharArray();
        int k = 0;
        while (k < lim) {
            char c1 = charS1[k];
            char c2 = charS2[k];
            if (c1 != c2)
                return c1 - c2;
            k++;
        }
        return len1 - len2;
    }

    static int stringSize1(int x) {
        int count = 0;
        while (x > 0) {
            count++;
            x /= 10;
        }
        return count;
    }

    public int[] multiply(int[] A) {
        return new int[4];

    }
}
