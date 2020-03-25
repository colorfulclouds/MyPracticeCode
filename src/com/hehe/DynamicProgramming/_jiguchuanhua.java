package com.hehe.DynamicProgramming;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _jiguchuanhua {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            String[] temp=str.split(" ");
            int people = Integer.valueOf(temp[0]);
            int times =Integer.valueOf(temp[1]);
            Solution(people, times);//传入人数，次数

        }
    }
    private static void Solution(int people, int times) {
        int[][] jihe =new int[times+1][people];//构成环状
        //jihe[0][0]=0;
        //动态规划：dp[i][j] = dp[i-1][(n-j-1)%n]+dp[i-1][(n-i+1)%n];
        for (int i=1;i<=times;i++){
            if (i==1){//第一次击鼓
                jihe[i][(1+people)%people]=1;
                jihe[i][(-1+people)%people]=1;
                continue;
            }
            for (int j = 0; j < people; j++) {
                jihe[i][j] = jihe[i - 1][(people-j-1) % people] + jihe[i - 1][(people-j+1) % people];
            }

        }
        System.out.println(jihe[times][0]%1000000007);
    }
}