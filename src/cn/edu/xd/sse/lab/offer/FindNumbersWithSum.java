package cn.edu.xd.sse.lab.offer;

import java.util.ArrayList;

/**
 * Created by zhiyongwang on 2016/5/19.
 * 题目：和为S的两个数字
 * 题目描述；输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 输出描述：对应每个测试案例，输出两个数，小的先输出。
 */
public class FindNumbersWithSum {

    /**
     * 思路：
     * 设置两个指针，初始化时small指向第一个位置，big指向最后一个位置；设置两个索引，初始化都指向第一个位置；
     * 设置一个乘积的最大值max，初始化为int的最大值
     * <p>
     * 然后开始遍历小的与大的指向的值相加和是否与sum相等
     * 如果相等，判断他们的乘积是否比max小，如果小，用当前的乘积取代原来的max，用索引记录下small 与 big的值；
     * 如果大于，则将big指向往前移动；
     * 如果小于，则将small往后移动；
     * 循环结束的条件是small与big执行同一个数字
     * <p>
     * 最后输出判断max是否比int的最大值小，如果小，说明存在满足条件的数据，根据其索引添加到结果容器中
     *
     * @param array 要进行查找的数组
     * @param sum   要满足的和
     * @return 返回一个ArrayList，较小值在前，较大值在后
     */
    public ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (array == null || array.length == 0)
            return result;
        int length = array.length;
        int small = 0;         //指向遍历的较小数的指针
        int big = length - 1;  //这项遍历的较大数的指针
        int index0 = 0;       //满足结果的较小数的索引
        int index1 = 0;       //满足交过的较大数的索引
        int max = Integer.MAX_VALUE;   //用来记录满足结果的两个数的成绩
        while (small < big) {
            if (array[small] + array[big] == sum) {
                if (array[small] * array[big] < max) {
                    max = array[small] * array[big];
                    index0 = small;
                    index1 = big;
                }
                ++small;
            } else if (array[small] + array[big] > sum) {
                --big;
            } else {
                ++small;
            }
        }
        if (max < Integer.MAX_VALUE) {
            result.add(array[index0]);
            result.add(array[index1]);
        }
        return result;
    }

}
