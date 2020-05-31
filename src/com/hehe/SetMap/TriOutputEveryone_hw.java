package com.hehe.SetMap;

import java.util.*;

/**
 * 给定一个链表 去重 三倍输出
 */
public class TriOutputEveryone_hw {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] in = sc.nextLine().split(" ");

//        another(in);

        Set<Integer> set = new HashSet();
//        List<Integer> ll = new LinkedList<>();
        List<Integer> ll = new ArrayList<>();
        for (int i = 0; i < in.length; i++) {
            int ii = Integer.parseInt(in[i]);
            if (!set.contains(ii)) {
                ll.add(ii);
            }
            set.add(ii);
        }
        for (int v : ll) {
            System.out.print(v + " " + v + " " + v + " ");
        }
    }

    /**
     * 数组方法
     *
     * @param arrstr
     */
    public static void another(String[] arrstr) {
        int[] help = new int[arrstr.length + 1];
        for (int i = 0; i < help.length; i++) {
            help[i] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < arrstr.length; i++) {
            int tmp = Integer.parseInt(arrstr[i]);
            if (help[tmp] == Integer.MIN_VALUE)
                help[tmp] = tmp;
        }
        if (Integer.parseInt(arrstr[0]) < Integer.parseInt(arrstr[1])) {
            for (int i = 0; i < help.length; i++) {
                if (help[i] != Integer.MIN_VALUE)
                    System.out.print(help[i] + " " + help[i] + " " + help[i] + " ");
            }
        }


    }

}