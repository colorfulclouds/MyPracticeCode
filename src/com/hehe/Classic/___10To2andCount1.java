package com.hehe.Classic;

import java.util.Scanner;

public class ___10To2andCount1 {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int count = 0;
        while(n>0){
            if((n&1)>0){  //与1的与操作
                count++;
            }
            n=n>>1;  //右移
        }
        System.out.println(count);
    }


    //Drop 60%
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int input = Integer.parseInt(sc.nextLine());
//        int count = 0;
//        while(input/2 != 1){
//            if(input%2 == 1)
//                count++;
//            input/=2;
//        }
//        System.out.println(count+1);
//
//
//    }
}
