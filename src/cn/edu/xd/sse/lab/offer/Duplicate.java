package cn.edu.xd.sse.lab.offer;

import java.util.HashSet;

/**
 * Created by zhiyongwang on 2016/5/21.
 * 题目：数组中重复的数字
 * 题目描述：在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，
 * 那么对应的输出是重复的数字2或者3。
 */
public class Duplicate {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        HashSet<Integer> set = new HashSet<Integer>();
        boolean flag = false;
        if (numbers == null || length == 0 || length == 1)
            return false;
        if (length == 2 && numbers[0] != numbers[1])
            return false;
        for (int i = 0; i < length; i++) {
            if (!set.add(numbers[i])) {
                duplication[0] = numbers[i];
                flag = true;
                break;
            }
        }
        return flag;
    }
}
