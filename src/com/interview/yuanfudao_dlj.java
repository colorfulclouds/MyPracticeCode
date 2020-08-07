package com.interview;

import java.util.HashMap;
import java.util.Scanner;

/**最大区间重叠个数
 * 最多可以一心几用？同一个时间段看两门课程就是一心二用
 * 输入：
 * 4    //4门课程
 * 1 2   //1 2时间段的课程
 * 1 4
 * 2 3
 * 1 3
 *
 * 输出：
 * 3 //最少需要一心三用
 *
 */
public class yuanfudao_dlj {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = 0, b = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (n > 0) {
            a = sc.nextInt();
            b = sc.nextInt();
            for (int i = a; i < b; i++) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
            n--;
        }

        int max = 0;
        for (int i : map.keySet()){
            if(map.get(i) > max)
                max = map.get(i);
        }
        System.out.println(max);
    }
}
