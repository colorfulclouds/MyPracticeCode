package com.hehe.ArrayAndList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 两个数组，找出第一个中逆序的数值  并用第二个数组中的数值替换
 */
public class FindAndReplace {

    /**
     * 判断给定的数组是否是正序的
     * @param list
     * @return
     */
    public static boolean compareto (List<Integer> list) {
        for (int i = 0,j = 1; i < list.size()-1 && j<list.size(); i++,j++) {
            if(list.get(i)>list.get(j))
                return false;
        }
        return true;
    }


    /**
     * 返回非正序的值的下标
     * @param list
     * @return
     */
    public static int compare (List<Integer> list) {
        for (int i = 0,j = 1; i < list.size()-1 && j<list.size(); i++,j++) {
            if(list.get(i)>list.get(j))
                return j;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String in1 = sc.nextLine();
        String[] a1 = in1.split(" ");

        String in2 = sc.nextLine();
        String[] a2 = in2.split(" ");

        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();

        for (int i = 0; i < a1.length; i++) {
            list1.add(Integer.parseInt(a1[i]));
        }
        for (int i = 0; i < a2.length; i++) {
            list2.add(Integer.parseInt(a2[i]));
        }

//        System.out.println("list2 size: " + list2.size());
//        System.out.print("list2 : ");
//        for (int i = 0; i < list2.size(); i++) {
//            System.out.print(list2.get(i) + " ");
//        }
//        System.out.println();

        Collections.sort(list2);
        int x = compare(list1);  //乱序下标

        if(x!=-1){
            int yy = list1.get(x);
//            System.out.println(x + "  ==乱序下标==  ");
//            System.out.println(yy+ "  ++乱序位置的值++  ");

            for (int i = list2.size()-1; i >= 0; i--) {
//                System.out.println(list2.get(i)+ "  --list2的值--  ");
                list1.set(x, list2.get(i));
                if(compareto(list1)){
//				System.out.println(list2.get(i));
                    System.out.println(list1);
                    return ;
                }
                list1.set(x, yy);
            }

            System.out.println("NO");  //循环中没找到，没有return  就会运行到此 输出“NO”
        }

    }
}

//1 3 7 4 10
//2 1 5 8 9

