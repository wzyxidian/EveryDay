package com.edu.xd.sse.lab.offer;

import java.util.ArrayList;

/**
 * Created by zhiyongwang on 2016/5/18.
 * 题目：和为s的连续正数序列
 * 题目描述：小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列?
 * Good Luck!
 * 输出描述：
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class FindContinuousSequence {

    /**
     * 思路：设置两个指针，一个指向连续序列的第一个，一个指向最后一个
     * 最开始将small初始化为1，big初始化为2，如果序列值大于sum，那么去掉small，也就是small不断增大；
     * 如果序列值小于sum，那么增大big，遍历结束的条件是small增大到（sum / 2）为止。
     *
     * @param sum 为所要求得的和
     * @return
     */
    public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (sum < 1)
            return result;
        int small = 1;
        int big = 2;

        int midResult = small + big;
        int middle = sum / 2;
        while (small <= middle) {
            if (midResult == sum) {
                sum(result, small, big);
            }
            while (midResult > sum && small <= middle) {
                midResult -= small;
                ++small;
                if (midResult == sum) {
                    sum(result, small, big);
                }
            }
            ++big;
            midResult += big;
        }
        return result;
    }

    /**
     * 将结果存放到结果集中
     *
     * @param result
     * @param small
     * @param big
     */
    private void sum(ArrayList<ArrayList<Integer>> result, int small, int big) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = small; i <= big; i++) {
            list.add(i);
        }
        result.add(list);
    }
}
