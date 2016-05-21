package cn.edu.xd.sse.lab.offer;

/**
 * Created by zhiyongwang on 2016/5/21.
 * 题目：把字符串转换成整数
 * 题目描述：将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 */
public class StrToInt {

    boolean flag = true;             //定义正负数，true:正数，false：负数
    boolean validFlag = true;        //定义是否是有效的整数：true；有效，false：无效
    int result = 0;                  //初始化结果

    /**
     * 思路：这个题主要考察的是情况比较多，不能拉下了：（1）第一位是正负号，后面都是数字（2）第一位是正负号，后面没了
     * （3）第一位是正负号，后面包含非整数字符（4）不包含正负号的有效数字（5）不包含正负号的无效数字（6）大于int的最大值，或小于最小值
     *
     * @param str 要进行转换的字符串
     * @return 返回的整数结果，如果是无效数字，返回0
     */
    public int strToInt(String str) {
        if (str == null || str.length() == 0) {
            validFlag = false;
            return 0;
        }
        if (str.length() == 1 && (str.charAt(0) > '9' || str.charAt(0) < '0')) {
            validFlag = false;
            return 0;
        }
        if (str.charAt(0) == '+') {
            flag = true;
            result = stoi(str.substring(1), flag);
        } else if (str.charAt(0) == '-') {
            flag = false;
            result = stoi(str.substring(1), flag);
        } else {
            result = stoi(str, flag);
        }
        return result;
    }

    /**
     * 考虑正负，考虑是否包含非法字符，考虑是否在int范围内
     *
     * @param str
     * @param flag
     * @return
     */
    private int stoi(String str, boolean flag) {
        int result = 0;
        int length = str.length();
        int i = 0;
        int f = flag ? 1 : -1;
        while (i < length) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                result = result * 10 + f * (str.charAt(i) - '0');
                if ((flag && result > Integer.MAX_VALUE) || (!flag && result < Integer.MIN_VALUE)) {
                    validFlag = false;
                    break;
                }

            } else {
                validFlag = false;
                break;
            }
            ++i;
        }
        if (validFlag)
            return result;
        else
            return 0;
    }
}
