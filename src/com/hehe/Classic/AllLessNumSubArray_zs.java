package com.hehe.Classic;

import java.util.LinkedList;

public class AllLessNumSubArray_zs {

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};
        System.out.println(getNumByLinkedList(arr, 2));
        System.out.println(getNum(arr, 2));

    }

    /**
     * 求所有子数组中 max - min <= num 的个数
     * 双端队列
     * O(n)
     *
     * @param arr
     * @param num
     * @return
     */
    public static int getNumByLinkedList(int[] arr, int num) {
        int res = 0;
        if (arr == null || arr.length == 0) {
            return 0;
        }

        LinkedList<Integer> qmin = new LinkedList<>();
        LinkedList<Integer> qmax = new LinkedList<>();
        int L = 0, R = 0;

        while (L < arr.length) {
            while (R < arr.length) {
                while (!qmin.isEmpty() && arr[R] <= arr[qmin.peekLast()])
                    qmin.pollFirst();
                qmin.addLast(R);
                while (!qmax.isEmpty() && arr[R] >= arr[qmax.peekLast()])
                    qmax.pollFirst();
                qmax.addLast(R);
                if (arr[qmax.peekFirst()] - arr[qmin.peekFirst()] > num)
                    break;
                R++;
            }
            if (L == qmin.peekFirst())
                qmin.pollFirst();
            if (R == qmax.peekFirst())
                qmax.pollFirst();

            res += R - L;
            L++;
        }
        return res;
    }


    /**
     * 暴力 很复杂
     * O（n^3）
     *
     * @param arr
     * @param num
     * @return
     */
    public static int getNum(int[] arr, int num) {
        int res = 0;
        for (int start = 0; start < arr.length; start++) {
            for (int end = start; end < arr.length; end++) {
//                arr[i]...arr[j]
                if (isValid(arr, start, end, num))
                    res++;
            }
        }
        return res;
    }

    private static boolean isValid(int[] arr, int start, int end, int num) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        return max - min <= num;

    }
}
