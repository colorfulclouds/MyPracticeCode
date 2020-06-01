package com.hehe.ArrayAndList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 数组中是否有重复数字
 */
public class isDuplicationInArray {
    public static void main(String[] args) {

        //三种情况的测试用例
        int[] arr = {2,3,1,0,2,5,3};
        int[] arr1 = {};
        int[] arr2 = {2, 1, 3, 4};

//        System.out.println(DuplicationInArray(arr));
//        System.out.println(DuplicationInArray(arr1));
//        System.out.println(DuplicationInArray(arr2));

        System.out.println(DupInArr(arr));
        System.out.println(DupInArr(arr1));
        System.out.println(DupInArr(arr2));


    }

    /**
     * 时复：O(n)
     * 空复：O(n)
     * @param arr
     * @return
     */
    public static String DupInArr(int[] arr){
        //不需要
//        if (arr.length == 0 || arr == null)
//            System.out.println();

        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])){
                sb.append(arr[i]+" ");
                continue;
            }
            map.put(arr[i],arr[i]);
        }
        return sb.toString();
    }

    /**
     * 数组中是否有重复数字（不能用！！！）
     *
     * @param arr
     * @return 假设长度固定
     */
    public static boolean DuplicationInArray(int[] arr) {
        if (arr.length == 0 || arr == null)
            return false;

        //排序 找出最大的那个值 来确定辅助数组的大小
        Arrays.sort(arr);
        int len = arr[arr.length - 1]; //辅助数组的长度
        int[] help = new int[len + 1];

        for (int i = 0; i < help.length; i++) {
            help[i] = -1;
        }
        for (int i = 0; i < arr.length; i++) {
            help[arr[i]] = arr[i];
        }

        int tmp = -1;
        for (int i = 0; i < help.length; i++) {
            while (help[i] != i && help[i] != -1) {
                if (help[i] == help[help[i]])
                    return true;
                tmp = help[i];
                help[help[i]] = tmp;
                help[i] = tmp;
            }
        }
        return false;
    }



}
