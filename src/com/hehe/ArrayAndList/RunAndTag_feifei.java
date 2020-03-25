package com.hehe.ArrayAndList;

import java.util.Scanner;

/**美团--2019春笔试
 * n*n的跑圈，跑n+1个单位时做个标记，当重复标记的时候，结束跑步
 * 当n确定时，求标记的次数
 */

public class RunAndTag_feifei {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] n = new int[t];
        for (int i = 0; i < t; i++) {   //？？？？？？？当时为什么这样？？？？？？
            n[i] = sc.nextInt();
        }
        for (int i = 0; i < t; i++) {
            int[] flag =new int[4*n[i]];
            for (int j = 0; j < flag.length; j++) {
                flag[j] = 0;
            }
            int start = 0;
            int count = 0;
            while (true) {
                start = (start + (n[i]+1)) % (4*n[i]);
                if(flag[start] == 1){
                    break;
                }else{
                    flag[start] = 1;
                    count++;
                }
            }
            System.out.println(count+1);
        }


    }
}
