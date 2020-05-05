package com.hehe.ArrayAndList;

//给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
//不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
// 示例 1:
//给定数组 nums = [1,1,2],
//函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
//你不需要考虑数组中超出新长度后面的元素。

class RemoveDuplicates_lk26 {
    public static int removeDuplicates(int[] nums) {
        if(nums.length==0){
            return 0;
        }else{
            int len = nums.length;
            int cur_value = nums[0];
            int cur_index = 0;
            for (int i = 1; i < nums.length; ) {
                if(nums[i] != cur_value){
                    nums[cur_index+1] = nums[i];
                    cur_index++;
                    cur_value = nums[cur_index];
                    i++;
                }else{
                    i++;
                    len--;
                }
            }
            return len;
        }

    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,2};
        System.out.println(removeDuplicates(nums));

    }





}