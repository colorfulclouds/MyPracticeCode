package com.interview;

import java.util.Scanner;

/**
 * 字符串遇到某个字母换行
 */
public class T20200824_360_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
//        int a = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if ((s.charAt(i) == 'n' && i > 0)) {
//                String tmp = s.substring(a, i);
//                tmp = Character.toUpperCase(tmp.charAt(0)) + tmp.substring(1);
//                System.out.println(tmp);
//                a = i;
//            }/*else if(i== s.length()-1){ //&& s.charAt(i) !='n'
//            String tmp = s.substring(a);
//            tmp = (Character.toUpperCase(tmp.charAt(0)))+tmp.substring(1);
//            System.out.println(tmp);
//        }*/
////        }
//        String tmp = s.substring(a);
//        tmp = (Character.toUpperCase(tmp.charAt(0))) + tmp.substring(1);
//        System.out.println(tmp);

        int start = 0;
        s = s.substring(0, 1).toUpperCase() + s.substring(1);
        s = s.replace('n', 'N');
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'N') {
                if (start < i)
                    System.out.println(s.substring(start, i));
                start = i;
            }
        }
        System.out.println(s.substring(start));

    }

//wotainanle
//wotainanlen
}
