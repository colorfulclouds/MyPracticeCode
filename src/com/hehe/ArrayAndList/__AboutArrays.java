package com.hehe.ArrayAndList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class __AboutArrays {

//    Arrays的常用方法：
//
//            1.排序方法
//
//    原型：static void sort(int [] a)
//
//    功能：对指定的int型数组按数字升序进行排序
//
//2.查找方法
//
//    原型：static int binarySearch(Object[] a,Object Key)
//
//    功能：使用二分搜索法搜索指定数组，已获得制定对象
//
//3.拷贝方法
//
//    原型：static int[] copyOfRange(int [] original,int from,int to)
//
//    功能：将指定数组的指定范围复制到一个新数组
//
//4.填充方法
//
//    原型：static void fill(Object[] a,Object val)
//
//    功能：将指定的Object引用分配给指定Object数组的每个元素
//
//5.返回方法
//
//    原型：static String toString(int[] arr)
//
//    功能：返回指定数组内容的字符串表示形式

    public static void main(String[] args){
        int[] arr={9,8,3,5,2};
        int[] copied= Arrays.copyOfRange(arr, 1, 3); //复制数组
        System.out.println("复制数组："+Arrays.toString(copied));

        int[] arr2 = Arrays.copyOf(arr,4);
        System.out.println(Arrays.toString(arr2));


        Arrays.sort(arr);                          //排序数组
        System.out.println("排序后："+Arrays.toString(arr));
        Arrays.fill(arr,8);                        //填充数组
        System.out.println("填充数组："+Arrays.toString(arr));



        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();

        Collections.sort(list2);  //List的排序
    }

}
