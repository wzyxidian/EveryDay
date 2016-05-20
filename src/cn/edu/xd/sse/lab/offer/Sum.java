package cn.edu.xd.sse.lab.offer;

/**
 * Created by zhiyongwang on 2016/5/20.
 * 题目：求1+2+3+...+n
 * 题目描述：求1+2+3+...+n，
 * 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Sum {

    int res = 0;

    /**
     * 方法一：原来的求和公式是（n^2 + n）/ 2;
     * 思路；可以把公式分解开来进行求解，n^2 采用Math.pow(n,2);
     * /2操作可以使用移位操作来完成
     *
     * @param n
     * @return
     */
    public int sum_Solution(int n) {
        int res = (int) Math.pow(n, 2) + n;
        res = res >> 1;
        return res;
    }

    /**
     * 方法二：用递归来实现循环，用 boolean 来实现判断条件
     *
     * @param n
     * @return
     */
    public int sum_Solution1(int n) {
        check(n);
        return res;
    }

    private boolean check(int n) {
        res += n;
        return n != 0 && check(n - 1);
    }
}
