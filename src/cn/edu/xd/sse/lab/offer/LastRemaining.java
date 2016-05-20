package cn.edu.xd.sse.lab.offer;

import java.util.LinkedList;

/**
 * Created by zhiyongwang on 2016/5/20.
 * 题目：孩子们的游戏(圆圈中最后剩下的数)
 * 题目描述：
 * 每年六一儿童节,NowCoder都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
 * HF作为NowCoder的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:
 * 首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
 * 从他的下一个小朋友开始,继续0...m-1报数....这样下去....
 * 直到剩下最后一个小朋友,可以不用表演,并且拿到NowCoder名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
 * 请你试着想下,哪个小朋友会得到这份礼品呢？
 */
public class LastRemaining {

    /**
     * 思路：借鉴了约瑟夫环的解决方法
     * 第一步将所有的小朋友依次添加到LinkedList容器中，
     * 第二步初始化k,i,k表示每次要移走的数的下标，i用来结束循环用,循环结束的条件是移走了n-1个小朋友
     * 第三步遍历容器并移走数据，因为每次不再是报m的出去，而是一次递减m,m-1, m-2 ,m - 3...出去，所以
     * 每循环一次，k = m - 1;当然k都要对容器大小取余，如果是最后一位，说明余数为0，此时移走最后一位，k置0；
     * 如果不是最后一位，直接移走就ok了。
     *
     * @param n 总共有n个小朋友
     * @param m 随机指定的报m的小朋友唱歌
     * @return 圆环中最后一个小朋友
     */
    public int lastRemaining_Solution(int n, int m) {
        if (n <= 0)
            return -1;
        if (n == 1)
            return n;
        LinkedList<Integer> list = new LinkedList<Integer>();
        int i = 0;
        while (i < n) {
            list.add(i);
            ++i;
        }
        int k = 0;
        i = 0;
        while (i < (n - 1)) {
            k = k + m - 1;
            k = k % list.size();
            if (k < 0) {
                list.remove(list.size() - 1);
                k = 0;
            } else
                list.remove(k);
            ++i;
        }
        return list.get(0);
    }
}
