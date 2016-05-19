package com.edu.xd.sse.lab.offer;

import java.util.ArrayList;

/**
 * @author zhiyong wang
 *         题目：国际象棋摆放
 *         题目描述：在8 x 8 的国际象棋上摆放8个皇后，使其不能相互攻击，即任意两个皇后不得处在同一行、同一列或者同一对角线上
 *         共有多少种不同的摆放方法。
 */
public class Queen {

    /**
     * 这个用一个数组来表示，数组的下标表示的是行，a[0],0就表示第0行，a[1]，1就表示第一行
     * 里面的值表示第几列，a[0] = 4;表示皇后放在第0行第4列
     * 然后用排序的方式来进行求解
     *
     * @param arr 要进行排列的皇后
     * @return
     */
    public ArrayList<int[]> numberOfQueue(int[] arr) {
        ArrayList<int[]> result = new ArrayList<int[]>();
        if (arr == null || arr.length == 0)
            return result;
        int len = arr.length;
        sort(arr, 0, len, result);
        return result;
    }

    /**
     * 用递归的方式进行排序，因为用数组已经排序了同一行，同一列的问题，之用判断是否是对角线问题就可以了
     *
     * @param arr    要排序的皇后
     * @param index  排序到的位置
     * @param len    皇后的个数
     * @param result 最后的结果
     */
    private void sort(int[] arr, int index, int len, ArrayList<int[]> result) {
        if (index == len && opposite(arr)) {
            int[] tempResult = new int[len];
            System.arraycopy(arr, 0, tempResult, 0, len);
            result.add(tempResult);
        } else {
            int temp;
            for (int i = index; i < len; i++) {
                temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;

                sort(arr, index + 1, len, result);

                temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
            }
        }
    }

    /**
     * 判断是否是在对角线上
     *
     * @param arr
     * @return
     */
    private boolean opposite(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (j - i == Math.abs(arr[j] - arr[i]))
                    return false;
            }
        }
        return true;
    }
}
