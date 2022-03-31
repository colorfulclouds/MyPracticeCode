package com.hehe.HuaWei;

import java.util.Scanner;

public class Number7 {
    /*
        7的倍数或含有7
        数组 打乱的喊过7次数
        请按正确顺序排序
        个数 = 人数
        index 位置无所谓，刚开始打乱的
        HashMap
        1 0
        2 0
        3 0
        4 2
        5 1
        计算总次数，到达总次数就输出顺序累计结果
        //第一步 计算总次数
        total+=str[i];
        //第二步 模拟游戏，符合条件 cnt++,cnt>=total则游戏结束，按顺序输出m
        int[] m = new int[str.length];
        int cnt=0;
        while(cnt<total){
            if(cnt/(m[i]+1)==7 || cnt/(m[i]+1)%10==7){
                m[i] = m[i]+1;
                cnt++;
            }
        }
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split("\\s+");
        //第一步 计算总次数
        int total = 0; //喊7总次数
        for (String s : split) {
            total += Integer.parseInt(s);
        }

        //第二步 模拟游戏，符合条件 cnt++,cnt>=total则游戏结束，按顺序输出m
        int[] m = new int[split.length];
        int cnt = 0; //喊7次数
        int pos = 0; //位次
        for (int i = 1; i <= 200; i++) {
            if (pos == m.length)
                pos = 1;
            else
                pos++; //位次从编号1开始到人数上限，然后再重回编号1

            if (i % 7 == 0 || i % 10 == 7) {
                m[pos - 1] = m[pos - 1] + 1;
                cnt++;
            }
            if (cnt == total) break; //喊7次数等于总次数则结束
        }

        StringBuilder bu = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            bu.append(m[i]).append(" ");
        }
        System.out.println(bu.toString().trim());

    }
}
