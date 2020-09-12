package com.hehe.QsSol;

import java.util.Scanner;

/**美团--2019春笔试
 * n*n的跑圈，跑n+1个单位时做个标记，当重复标记的时候，结束跑步
 * 当n确定时，求标记的次数
 */
public class RunAndTag {

    public static int runAndTag(int n){
        int flag[] = new int[4*n];
        for (int i = 0; i < 4*n; i++){  //全部赋初值为0
            flag[i] = 0;
        }
        int start = 0;  //起始点是每次标记的点
        int count = 0;

        while(true){
            start = (start+(n+1)) % (4*n);   //将总长度作为模的底数
            if(flag[start] == 1){
                count++;
                break;
            }else{
                flag[start] = 1;
                count++;
            }
        }
        return count;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(runAndTag(num));

    }

}
