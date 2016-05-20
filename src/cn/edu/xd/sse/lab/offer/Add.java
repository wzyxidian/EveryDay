package cn.edu.xd.sse.lab.offer;

/**
 * Created by zhiyongwang on 2016/5/20.
 * 题目：不用加减乘除做加法
 * 题目描述：写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class Add {

    /**
     * 思路：可以把相加的过程分成两部分，第一部分只相加，不进位，第二部分，把进位的与之相加
     * 第一步：先得到异或的结果，此时的结果是没有进位的结果，
     * 第二步：得到相与的结果，然后左移一位就是进位的结果
     * 第三步：就是循环相加第一步第二步的和，直到进位为0为止
     *
     * @param num1
     * @param num2
     * @return
     */
    public int add(int num1, int num2) {
        int result = 0;
        int carry = 0;
        do {
            result = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = result;
            num2 = carry;

        } while (num2 != 0);
        return num1;
    }
}
