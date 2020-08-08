package com.interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 20200808
 */
public class T20200808_wangyi3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ns = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++){
            ns[i] = sc.nextInt();
            sum += ns[i];
        }
        String str = String.valueOf(sum);
        Arrays.sort(ns);
        int i = 0;
        while(str.contains("5") && i < n){
            sum -= ns[i];
            str = String.valueOf(sum);
            i++;
        }
        System.out.println(sum);
    }



}

//1
//5
//0

//5
//5 15 5 15 8
//48

//5
//5 15 5 15 5
//40

//3
//25 15 10
//40