package com.interview;

import java.util.Scanner;


public class T20200913_sf1 {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            boolean b = true;
            while (b){
                b = false;
                for (int i = 0; i < s.length() - 1; i++) {
                    if(s.charAt(i) == s.charAt(i+1)){
                        s = s.substring(0,i) + s.substring(i+2);
                        i++;
                        b = true;
                    }
                }
            }
            System.out.println(s.isEmpty()?"empty" : s);


//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();

//        int i ;
//        for (i = 0; i < str.length() - 1; i++) {
//            if(str.charAt(i) == 'Y' || str.charAt(i) == 'X' && str.charAt(i+1) != 'X')
//                sb.append(str.charAt(i));
//            else if(str.charAt(i) == 'X' && str.charAt(i+1) == 'X')
//                i++;
//        }
//        if(i == str.length()-1)
//            sb.append(str.charAt(i));
//
//        StringBuilder sb2 = new StringBuilder();
//        int j ;
//        for (j = 0; j < sb.length()-1 ; j++) {
//            if(sb.charAt(j) == 'X' || sb.charAt(j) == 'Y' && sb.charAt(j+1) != 'Y')
//                sb2.append(sb.charAt(j));
//            else if(sb.charAt(j) == 'Y' && sb.charAt(j+1) == 'Y')
//                j++;
//        }
//        if(j == sb.length() -1)
//            sb2.append(sb.charAt(j));
//
//        if(sb.length() != 0)
//            System.out.println(sb2);
//        else
//            System.out.println("empty");

    }
}
