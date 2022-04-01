package com.hehe.HuaWei;

import java.util.*;

public class CharactorCount {
    /**
     * 统计各种字符的个数
     */
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            int isLetter = 0, isDigit = 0, isWhitespace = 0, isQt = 0;
//            char[] str = sc.nextLine().toCharArray();
//            for (int i = 0; i < str.length; i++) {
//                char a = str[i];
//                if (Character.isLetter(a))
//                    isLetter++;
//                else if (Character.isDigit(a))
//                    isDigit++;
//                else if (Character.isWhitespace(a))
//                    isWhitespace++;
//                else isQt++;
//            }
//            System.out.println(isLetter);
//            System.out.println(isWhitespace);
//            System.out.println(isDigit);
//            System.out.println(isQt);
//        }
//    }


    /**
     * 输入 n 个整数，输出其中最小的 K 个
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            for (int i = 0; i < k; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

}