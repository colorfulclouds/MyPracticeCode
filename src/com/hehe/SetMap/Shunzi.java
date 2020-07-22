package com.hehe.SetMap;

import java.util.Arrays;

/**
 * A看作1,J为11,Q为12,K为13,为了方便起见,你可以认为大小王是0,大小王可以看成任意数字，五张牌连续 即为顺子
 *
 *
 */
public class Shunzi {
    public static void main(String[] args) {

        System.out.println(IsShunzi(new int[]{1,3,4,2,5}));
        System.out.println(IsShunzi(new int[]{0,0,3,4,5}));
        System.out.println(IsShunzi(new int[]{}));

    }

    public static boolean IsShunzi(int[] numbers){
        if(numbers == null || numbers.length ==0)
            return false;
        Arrays.sort(numbers); //排序
        int count_0 = 0;
        int count_gap = 0;   //相邻数字之间的空缺数
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] == 0)
                count_0++;
        }
        int small = count_0;
        int big = small + 1;
        while(big < numbers.length){
            if(numbers[big] == numbers[small])
                return false;
            count_gap += numbers[big] - numbers[small] - 1;
            small = big;
            big++;
        }
        return count_0 >= count_gap ? true : false;  //空缺数大于0的个数 不是顺子
    }






}
