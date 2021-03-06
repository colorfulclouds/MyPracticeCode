package com.hehe.ArrayAndList;

import java.util.ArrayList;
import java.util.List;

public class SumToTarget {

    public static void main(String[] args) {
        //3、和为 s 的连续正数序列
        System.out.println("=====3-1=====");
        List<int[]> res1 = sumToS(9);
        for (int[] i : res1) {
            System.out.print(i[0] + "~" + i[1]);
            System.out.println();
        }
        System.out.println("=====3-2 滑动窗口=====");
        List<int[]> res2 = sumToS01(9);
        for (int[] i : res2) {
            for (int j = 0; j < i.length; j++) {
                System.out.print(i[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("======================");
//        for (int[] i : res2) {
//            System.out.print(i[0] + "~" + i[1]);
//            System.out.println();
//        }

        System.out.println("==========getArraysToTarget==========");
        int[] oneArr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(getArraysToTarget(oneArr, 9));
        System.out.println("====================");

        System.out.println("sum");
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(is(arr, 7));
    }

    /**
     * 3-1、和为 s 的连续正数序列
     *
     * @param s
     * @return
     */
    public static List<int[]> sumToS(int s) {
        int i = 1, j = 2;
        List<int[]> list = new ArrayList<>(); //List<List<Integer>> result = new ArrayList<>();

        while (i < (1 + s) / 2) {// 因为序列至少要有两个数字，需要将i 增加到 （1+s）/2  的位置
            //差为1的连续序列，那么求和公式是(a0+an)*n/2
            int sum = (j - i + 1) * i + (j - i + 1) * (j - i) / 2;
            if (sum == s) {
                list.add(new int[]{i, j}); //List<Integer> list = new ArrayList<>(); 把 i->j 元素 全加进去
                j++;
            } else if (sum < s && i < ((1 + s) / 2)) {
                j++;
            } else if ((sum > s && i < ((1 + s) / 2)))
                i++;
        }
        return list;
    }


    /**
     * 3-2、和为 s 的连续正数序列  (滑动窗口)
     *
     * @param s
     * @return
     */
    public static List<int[]> sumToS01(int s) {
        int i = 1, j = 2;
        List<int[]> list = new ArrayList<>();
        int curSum = i + j;
        while (i < (1 + s) / 2) {
            if (curSum == s) {
                // 也可以 记录结果 详细到数字是哪些
                int[] arr = new int[j - i + 1];
                for (int k = i; k <= j; k++) {
                    arr[k - i] = k;
                }
                list.add(arr);

                //可以是添加序列的区间
                //list.add(new int[]{i, j});
                j++;
                curSum += j;
            } else if (curSum < s) { //&& i < (1 + s) / 2
                j++;
                curSum += j;
            } else if (curSum > s) { //&& i < (1 + s) / 2
                curSum -= i;
                i++;
            }
        }
        return list;
    }


    /**
     * 连续递增数列的 和为某一target值的 连续子序列
     *
     * @param arr
     * @param target
     * @return
     */
    public static int getArraysToTarget(int[] arr, int target) {
        int res = 0;
        int len = arr.length;
        int i = 0, j = 1;
        int sum = arr[i] + arr[j];
        while (i < (1 + arr.length) / 2) {
            if (sum == target) {
                res++;
                j++;
                sum += arr[j];
            } else if (sum < target) {
                j++;
                sum += arr[j];
            } else {
                sum -= arr[i];
                i++;
            }
        }

        return res;
    }

    public static boolean is(int[] a, int tar) {
        int sum = 0;
        int i = 0;
        boolean b = isExist(a, i, sum, tar);
        return b;
    }

    public static boolean isExist(int[] arr, int i, int sum, int tar) {
        while (i < arr.length) {
            if (sum == tar)
                return true;
            return isExist(arr, i + 1, sum, tar) || isExist(arr, i + 1, sum + arr[i], tar);
        }
        return false;

    }


}

