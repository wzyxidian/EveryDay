package cn.edu.xd.sse.lab.offer;

/**
 * Created by zhiyongwang on 2016/5/19.
 * 题目：左旋转字符串
 * 题目描述：汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class LeftRotateString {

    /**
     * 思路：
     * 判断字符串的长度，如果长度为0，或者字符串为null，就返回空；如果字符串长度为1，或者字符串长度等于移动的位数
     * 那么直接返回字符串就可以
     * 接下里用移动位数n 对 字符串长度进行取模运算，就得到了最后移动的位数move
     * 然后把字符串[0,move],[move+1,length-1],[0,length-1]分别进行收尾交换操作
     *
     * @param str 要进行移动的字符串
     * @param n   要进行左移的位数
     * @return 移动之后的字符串结果
     */
    public String leftRotateString(String str, int n) {
        if (str == null || str.length() == 0 || n < 0)
            return "";
        if (str.length() == 1 || str.length() == n)
            return str;
        int length = str.length();
        int move = n % length;
        char[] ch = str.toCharArray();
        exchange(ch, 0, move - 1);
        exchange(ch, move, length - 1);
        exchange(ch, 0, length - 1);
        return String.valueOf(ch);
    }

    /**
     * 对字符串进行前后兑换
     *
     * @param ch    要进行转换的字符串
     * @param start 转换的起始位置
     * @param end   转换的结束位置
     */
    private void exchange(char[] ch, int start, int end) {
        for (int i = start, j = end; i <= j; ++i, --j) {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
        }
    }
}
