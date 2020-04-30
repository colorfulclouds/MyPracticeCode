package com.hehe.ArrayAndList;

import java.util.ArrayList;

/**
 * ArrayList循环遍历删除 因为其删除的方法里面使用的是删除后 将后续元素往前复制，故对于连续的两个元素，删除第一个，
 * 第二个会被移动到当前位置，导致第二个元素删除失败，倒序删除可以解决该问题
 */

public class ArrayListRemove {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("c");
        list.add("c");
        list.add("c");
        for (String s : list) {
            System.out.println("element : " + s);
        }
        System.out.println();

        remove(list);
    }

    public static void remove(ArrayList<String> list) {

//        for (String s : list) {  //并发修改异常 Exception in thread "main" java.util.ConcurrentModificationException
//            if(s.equals("b")){
//                list.remove("b");
//            }
//        }

        for (int i = list.size()-1; i > 0; i--) { //可以删除所有为 b 的元素
            if(list.get(i).equals("b")){
                list.remove("b");
            }
        }

        //remove and print
        for (String s : list) {
            System.out.println("element : " + s);
        }

    }
}
