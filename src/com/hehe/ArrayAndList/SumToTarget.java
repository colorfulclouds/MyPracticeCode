package com.hehe.ArrayAndList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 两数之和等于既定的目标数字，找出这两个数，返回在数组的中的下标
 * */
public class SumToTarget {

    public static void main(String[] args) {

        //1、任意数组中的两个数等于既定的target值：暴力O（n^2）
        int[] nums = {3, 9, 8, 1};
        int target = 9;
        int[] rst = twoSum(nums, target);
//		for(int i:rst){
//			System.out.print(i);
//		}
        System.out.print("[" + rst[0] + "," + rst[1] + "]");
        System.out.println();

        //2、排序数组中的两个数等于既定的target值 :双指针 O（n）
        int[] nums1 = {1, 2, 4, 7, 11, 15};
        int[] res = twoSumInOrdered(nums1, 15);
        for (int i : res)
            System.out.print(i + " ");

        System.out.println();
        //3、和为 s 的连续正数序列
        System.out.println("=====3-1=====");
        List<int[]> res1 = sumTos(9);
        for (int[] i : res1) {
            System.out.print(i[0] + "~" + i[1]);
            System.out.println();
        }
        System.out.println("=====3-2=====");
        List<int[]> res2  = sumTos01(9);
        for (int[] i : res2) {
            System.out.print(i[0] + "~" + i[1]);
            System.out.println();
        }

    }

    /**
     * 3-1、和为 s 的连续正数序列
     *
     * @param s
     * @return
     */
    public static List<int[]> sumTos(int s) {
        int i = 1, j = 2;
        List<int[]> list = new ArrayList<>();

        while (i < (1 + s) / 2) {  //因为序列至少要有两个数字，需要将i 增加到 （1+s）/2  的位置
            if (Sum(i, j) == s) {
                list.add(new int[]{i, j});
                j++;
            } else if (Sum(i, j) < s && i < ((1 + s) / 2)) {
                j++;
            } else if ((Sum(i, j) > s && i < ((1 + s) / 2)))
                i++;
        }
        return list;
    }

    private static int Sum(int i, int j) {
        return (j - i + 1) * i + (j - i + 1) * (j - i) / 2;
    }


    /**3-2、和为 s 的连续正数序列
     * 滑动窗口
     * @param s
     * @return
     */
    public static List<int[]> sumTos01(int s) {
        int i = 1, j = 2;
        List<int[]> list = new ArrayList<>();
        int curSum = i + j;
        while (i < (1 + s) / 2) {
            if(curSum == s){
                list.add(new int[]{i, j});
                j++;
                curSum += j;
            }else if(curSum < s &&  i < (1 + s) / 2){
                j++;
                curSum += j;
            }else if(curSum > s &&  i < (1 + s) / 2){
                curSum -= i;
                i++;
            }
        }
        return list;
    }

    /**
     * 2、求排序数组中的两个数等于既定的target值
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumInOrdered(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] == target)
                return new int[]{nums[i], nums[j]};
            else if (nums[i] + nums[j] > target)
                j--;
            else
                i++;
        }
        return null;

    }

    /**
     * 1、无序数组中两数之和等于target，并输出两数下标（数组类型）
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
//        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }
        return null;

//        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//
//        //依次加入map
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], i);
//        }
//
//        //对每一个数字遍历寻找其另一半
//        for (int i = 0; i < nums.length; i++) {
//            int complement = target - nums[i];
//
//            //若存在一个值等于另一半，而且不是当前i的角标
//            if (map.containsKey(complement) && map.get(complement) != i) {
//                //返回两个数字下标的数组形式
//                return new int[]{i, map.get(complement)};
//            }
//        }
////		    throw new IllegalArgumentException("No two sum solution");
//        return null;
    }


}

