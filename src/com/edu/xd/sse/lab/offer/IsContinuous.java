package com.edu.xd.sse.lab.offer;

import java.util.Arrays;

/**
 * Created by zhiyongwang on 2016/5/19.
 * 题目：扑克牌顺子
 * 题目描述：LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...他随机从中抽出了5张牌,
 * 想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....
 * LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),
 * “So Lucky!”。
 * LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何。为了方便起见,你可以认为大小王是0。
 */
public class IsContinuous {

    /**
     * 思路：
     * 整个过程分三步进行：（1）对整个数组进行排序（2）统计0的个数（3）统计连续非零数值间的间隔之和
     * 最后判断0的个数与非零的间隔之和的大小，0的个数大于等于非零的间隔之和，那么就满足连续条件，否则不满足
     * 注意几个问题：
     * （1）统计非零间隔之和的同时要判断两个数是否相等，如果相等，那么直接返回false
     * （2）连续两个非零数值之间的间隔为：后面的数值-前面的数值-1；不要忘记了减去1
     *
     * @param numbers 要进行判断的数组
     * @return 排序：true，  不排序：false
     */
    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return false;
        Arrays.sort(numbers);
        int zeroCount = 0;
        int unZeroCount = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == 0)
                zeroCount++;
            if (numbers[i] != 0 && numbers[i + 1] != 0)
                if (numbers[i] == numbers[i + 1])
                    return false;
                else
                    unZeroCount += numbers[i + 1] - numbers[i] - 1;
        }
        return zeroCount >= unZeroCount;
    }
}
