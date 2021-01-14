package com.tmp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 1、老鹰抓小鸡
 *
 * 4 3
 * 40 30 20 10
 * 2 1 2 1 1 1
 */


public class T20210113_ry01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt(); //小鸡个数
        int N = sc.nextInt();  // N轮游戏
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            list.add(sc.nextInt());
        }
        int[] attack = new int[N];
        int[] protect = new int[N];
        for (int i = 0; i < N; i++) {
            attack[i] = sc.nextInt();
            protect[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            if (list.size() <= 1) {
                System.out.println("Fail! " + list.get(0));
                return;
            }
            if (attack[i] > list.size())  //超过list长度 攻击无效
                continue;
            if(attack[i] == protect[i])
                continue;
            list.remove(attack[i] - 1);
        }
        if(list.size() <= 1){
            System.out.println("Fail! "+list.get(0));
            return;
        }
        Integer[] res = new Integer[list.size()];
        list.toArray(res);
        Arrays.sort(res);
        System.out.print("Succeess! ");
        for (Integer i : res) {
            System.out.print(" " + i);
        }


//        Integer[][] arr = new Integer[m][2];
//        for (int i = 0; i < m; i++) {
//            arr[i][0] = sc.nextInt();
//            arr[i][1] = sc.nextInt();
//        }
//        int times = 0;
//        while (list.size()>1 && times < m){
//            int i = arr[times][0];
//            int j = arr[times][1];
//            times++;
//            if(i>list.size())
//                continue;
//            if(i ==j)
//                continue;
//            list.remove(i-1);
//            if (list.size() >1){
//                System.out.print("Succeess! ");
//                for (int k = 0; k < list.size(); k++) {
//                    System.out.print(list.get(k) + " ");
//                }
//                System.out.println();
//            }else
//                System.out.print("Fail! " + list.get(0));
//        }
    }
}
