package com.hehe.HuaWei;

import java.util.Scanner;

/**
 * 玩牌游戏：要当前的牌 就加到总值里面 不要当前的值 回到三局前的总值
 * 前三局如果不要，总值变为 0
 *
 * 1 -5 -6 4 3 6 -2
 * 11
 *
 * -1 -2 -3
 * 0
 *
 */
public class PlayCard {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String[] s = sc.nextLine().split(" ");
//        int[] arr = new int[s.length + 1];
//        for (int i = 1; i < s.length; i++) {
//            arr[i] = Integer.valueOf(s[i - 1]);
//            System.out.print(" " + arr[i]);
//        }
//        System.out.println(play(arr));
//
        int[] arr = {-5, -6, 4, 3, 6, -2};
        int[] arr01 = {-5, -6, -4, -3, -6, -2};
        System.out.println(play(arr));
        System.out.println(play(arr01));

        System.out.println("++++++++++++++play01++++++++++++");
        int[] arr03 = {0, 1, -5, -6, 4, 3, 6, -2};
        System.out.println(play01(arr03));
    }

    private static int play(int[] arr) {
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i < 3 && total + arr[i] > 0 || i >= 3 && total + arr[i] > arr[i - 3]) {
                total += arr[i];
                arr[i] = total;
            } else if (i < 3 && total + arr[i] < 0) {
                arr[i] = 0;
                total = 0;
            } else {
                arr[i] = total;
            }
        }
        return total;
    }

    //==========================================================================
    private static int play01(int[] arr) {
        int[] step = new int[arr.length];
        for (int i = 1; i < arr.length; i++) {
            int tem = step[i - 1] + arr[i];

            int last = i < 4 ? 0 : step[i - 3];
            step[i] = Math.max(tem, last);
        }
        return step[step.length - 1];
    }
}
