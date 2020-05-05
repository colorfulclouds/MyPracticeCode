package com.hehe.ArrayAndList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*输出数组中三个数字之和等于0，的所有组合
 *
 *
 * */
public class get3Num {

    public static List<List<Integer>> threeSum(int[] nums) {
        //给定数组排序
        Arrays.sort(nums);
        for (int i = 0; i <nums.length ; i++) {
            System.out.print(nums[i]+" ");
        }
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
        int nums[] = {-4, -2, 1, 0, 0, -2, 3, 1, -5, 0};

        List<List<Integer>> ends = threeSum(nums);
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
