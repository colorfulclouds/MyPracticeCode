package com.hehe.Classic;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 孪生素数
 */
public class ClosePrimeNum {
    public static void main(String[] args) {
        System.out.println(closePrime(10));

    }


    /**
     * 1-n之间的孪生素数个数
     * @param n
     * @return
     */
    public static int closePrime(int n) {
        /**
         * 素数筛选器
         */
        boolean[] b = new boolean[n + 1];  //false代表不删的数字（是素数的数字）
        for (int i = 2; i < b.length; i++) {
            if (!b[i]) { //b[i]是素数
                for (int j = 2; j * i < b.length; j++) {  //j 为 i 的倍数 从2倍开始删除不是素数的数字
                    b[i * j] = true;
                }
            }
        }
        List<Integer> list = new ArrayList<>(); //1-n 的全部素数
        for (int i = 2; i < b.length; i++) {
            if (!b[i]) //
                list.add(i);
        }

        //计算孪生素数的个数
        int count = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i + 1) - list.get(i) == 2)
                count++;
        }
        return count;
    }
}
