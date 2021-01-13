package com.hehe.ArrayAndList;

public class ArrayQs {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        int[] newArr = reOrderArray(arr);
        System.out.println("++++++++++++++按奇偶排序数组(辅助数组不改变顺序)+++++++++++++++");
        for (int i : newArr) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("+++++++++++++按奇偶排序数组(三个while)++++++++++++++++");
        int[] res = sortArrayByParity(arr);
        for (int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("++++++++++++++移除重复的元素+++++++++++++++");
        int[] nums = {1, 1, 2, 2};
        int[] res01 = removeDuplicates(nums);
        for (int i : res01) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("++++++++++++++删除数组(有正有负)的一个数 使其它的数字乘积最大+++++++++++++++");
        int[] remove = {1, 3, 4, 5, -1, 0, -3};
        System.out.println(findRemoveIndex(remove));
        System.out.println();
    }


    /**
     * 按奇偶排序数组
     *
     * @param arr
     * @return
     */
    public static int[] sortArrayByParity(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            if (arr[i] % 2 < arr[j] % 2) { //A[i] % 2 == 1 &&  A[j] % 2 == 0
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
            while (i < arr.length && arr[i] % 2 == 1)
                i++;
            while (j > 0 && arr[j] % 2 == 0)
                j--;
        }
        return arr;
    }

    /**
     * 按奇偶排序数组 --辅助数组返回 不改变相对顺序
     *
     * @param array
     * @return
     */
    public static int[] reOrderArray(int[] array) {
        if (array.length == 0 || array == null)
            return new int[]{};
        int[] newArray = new int[array.length];
        int len = array.length;
        int k = 0;
        for (int i = 0; i < len; i++) {
            if (array[i] % 2 == 1) {
                newArray[k++] = array[i];
            }
        }
        for (int i = 0; i < len; i++) {
            if (array[i] % 2 == 0) {
                newArray[k++] = array[i];
            }
        }
        return newArray;
    }

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                nums[p++] = nums[i];
        }
        for (int i = p; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 移除重复数字
     * <p>
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * 示例 1:
     * 给定数组 nums = [1,1,2],
     * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
     * 你不需要考虑数组中超出新长度后面的元素。
     *
     * @param nums
     * @return
     */
    public static int[] removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return new int[0];

        int value = nums[0];
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != value) {
                nums[++index] = nums[i];
                value = nums[i];
            } else {
                len--;
            }
        }
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = nums[i];
        }
        return res;
    }

    /**
     * 删除数组(有正有负)的一个数 使其它的数字乘积最大
     * 分情况讨论
     *
     * @param nums
     * @return tempIndex 下标
     */
    public static int findRemoveIndex(int[] nums) {

        // 统计负数的个数
        int negativeCount = 0;
        for (int i = 0; i < nums.length; i++) {
            // 有负数就+1
            if (nums[i] < 0) {
                negativeCount++;
            }
        }

        //根据不同的情况，选择要删除的元素（）
        int tempIndex = 0;

        if ((negativeCount & 1) == 1) {
            //情况1： 负数个数是奇数,就移除最大的负数(最小的数)
            for (int i = 1; i < nums.length; i++) {
//                int cur = nums[i];
                if (nums[i] < 0 && nums[i] < nums[tempIndex]) {
                    tempIndex = i;
                }
            }
            return tempIndex;

        } else {  //情况2： 负数个数是偶数 移除最小的非负数（绝对值最小的数）
            for (int i = 1; i < nums.length; i++) {
//                if (nums[i] >= 0 && nums[i] < nums[tempIndex]) {  //正确的
//                    tempIndex = i;
//                }
                if( Math.abs(nums[i]) < Math.abs(nums[tempIndex]) )
                    tempIndex = i;
            }
            return tempIndex;
        }
    }

}
