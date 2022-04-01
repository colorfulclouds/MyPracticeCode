package com.hehe.HuaWei;

import java.util.*;

public class _HuaWeiSelfTest {

    /**
     * 去重排序 输出
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int tem= sc.nextInt();
            if(!list.contains(tem))
                list.add(tem);
        }
        Collections.sort(list);
        for (int i : list) {
            System.out.println(i);
        }
    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNextLine()) {
//            int i = sc.nextInt();
//            if ( i == 0) {
//                return;
//            }
//            System.out.println(Calculate(i));
//        }
//    }
//
//    public static int Calculate(int num) {
//       return num/2;
//    }
}
