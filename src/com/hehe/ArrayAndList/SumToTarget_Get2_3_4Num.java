package com.hehe.ArrayAndList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 1、两数之和等于target
 * 2、输出数组中三个数字之和等于0，的所有组合
 * 3、输出数组中四个数字之和等于0，的所有组合
 *
 * 4、给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合
 * package com.hehe.RecursiveAndDynamic.CombinationSum;
 * */
public class SumToTarget_Get2_3_4Num {

    /**
     * 无序数组中两数之和等于target，并输出两数下标（数组类型）
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }
        return null;//   return new int[0];
    }

    /**
     * 求排序数组中的两个数等于既定的target值
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumInOrdered(int[] nums, int target) {
        int a = 0, b = nums.length - 1;
        while (a < b) {
            if (nums[a] + nums[b] == target)
                return new int[]{nums[a], nums[b]};
            else if (nums[a] + nums[b] > target)
                b--;
            else
                a++;
        }
        return null;

    }

    /**
     * 递增排序数组和为S的两个数，如果有多对结果，输出两个数的乘积最小的
     *
     * 注意：乘积最小的，递增的序列，外层的乘积小于内层
     *       故，夹逼找到的第一个就可以返回了 即为最小的那对
     * @param array
     * @param sum
     * @return
     */
    public List<Integer> FindNumbersWithSum(int[] array, int sum) {
        int a = 0;
        int b = array.length - 1;
        List<Integer> list = new ArrayList<>();
        while (a < b) {
            if (array[a] + array[b] == sum) {
                list.add(array[a]);
                list.add(array[b]);
            } else if (array[a] + array[b] > sum) {
                b--;
            } else
                a++;
        }
        return list;
    }



    /**
     * 输出数组中四个数字之和等于0，的所有组合
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum(int[] nums,int target) {
        Arrays.sort(nums);
        List<List<Integer>> allList = new ArrayList<>();
        if(nums.length < 4)
            return allList;
        for (int i = 0; i < nums.length - 3; i++) {
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            for (int j = i + 1; j < nums.length - 2;j++) {
                if(j > i+1 && nums[j] == nums[j-1])
                    continue;;

                int start = j + 1;
                int end = nums.length - 1;
                while (start < end) {
                    if(nums[i] + nums[j] +nums[start] + nums[end] == target ){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[start]);
                        list.add(nums[end]);
                        allList.add(list);
                        start++;
                        end--;
                        while(start< end && nums[start] == nums[start-1]){
                            start++;
                        }
                        while (nums[end] == nums[end + 1] && start < end) {
                            end--;
                        }

                    }else if(nums[i] + nums[j] +nums[start] + nums[end] < target){
                        start++;
                        while (nums[start] == nums[start - 1] && start < nums.length - 1) {
                            start++;
                        }
                    }else{
                        end--;
                        while (nums[end] == nums[end + 1] && end > 3) {
                            end--;
                        }
                    }
                }
            }
        }
        return allList;
    }

    /**
     * 输出数组中三个数字之和等于0，的所有组合
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        //给定数组排序
        Arrays.sort(nums);
//        for (int i = 0; i <nums.length ; i++) {
//            System.out.print(nums[i]+" ");
//        }
        List<List<Integer>> allList = new ArrayList<>();

        //设i为start指针与end指针的和 --的相反数
        for (int i = 0; i < nums.length - 2; ) { //i++ 一个一个自增 会有重复的序列 故需要特殊处理
            //start指针对应起始位置
            int start = i + 1;
            //end指针对应结束位置
            int end = nums.length - 1;
            while (start < end) {
                if (nums[start] + nums[end] == -nums[i]) {   //同 ：nums[start] + nums[end] +nums[i] == 0
                    List<Integer> list = new ArrayList<>(3);
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    allList.add(list);
                    start++;
                    end--;
                    //除去end指针的重复值(是否和上一个相同)
                    while (nums[end] == nums[end + 1] && start < end) {
                        end--;
                    }
                    //除去start指针的重复值
                    while (nums[start] == nums[start - 1] && start < end) {
                        start++;
                    }
                } else if (nums[start] + nums[end] > -nums[i]) { //3值的和大于0时，重新检测end指针是否重复后降值
                    end--;
                    while (nums[end] == nums[end + 1] && start < end) {
                        end--;
                    }
                } else {//3值的和小于0时，重新检测start指针是否重复后升值
                    start++;
                    while (nums[start] == nums[start - 1] && start < end) {
                        start++;
                    }
                }
            }
            i++; //特殊处理i 将重复序列去掉
            while (nums[i] == nums[i - 1] && i < nums.length - 2) {
                i++;
            }
        }
        return allList;
    }

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


        int nums2[] = {-4, -2, 1, 0, 0, -2, 3, 1, -5, 0};

        List<List<Integer>> ends = threeSum(nums2);
        for (List<Integer> i : ends) {
            System.out.println(i);
        }
    }

}

/* ArrayList 难度：***
 *
 * java.util.Arrays 类能方便地操作数组，它提供的所有方法都是静态的。
		具有以下功能：
		给数组赋值：通过 fill 方法。
		对数组排序：通过 sort 方法,按升序。
		比较数组：通过 equals 方法比较数组中元素值是否相等。
		查找数组元素：通过 binarySearch 方法能对排序好的数组进行二分查找法操作。
 *
 * */
