package com.hehe.Classic;


/**.下一个排列
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 */
public class nextPermutation {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int[] nums1 = {1,3,2};
//        nextPermutation(nums);
//        for(int c : nums){
//            System.out.print(c + " "); //1 3 2
//        }
        System.out.println("++++++++++++++++++");
        nextPermutation(nums1);
        for(int c : nums1){
            System.out.print(c + " "); //2 1 3
        }
    }


    public static void nextPermutation(int[] nums) {

//        int i = nums.length - 1; //此法找到的时从右到左升序的最后一个 需要多一句 i--
//        while(i >0  && nums[i] <= nums[i-1])
//            i--;

        int i = nums.length - 2; //此法找到的时从右到左升序的最后一个 的下一个
        while (i >= 0 && nums[i] >= nums[i+1]) {
            i--;
        }
        if(i >= 0){
            int j = nums.length-1;
            while(j >= 0 && nums[j] <= nums[i])
                j--;
            swap(nums,i,j);
        }

        reverse(nums,i+1);
    }

    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
