package com.hehe.ArrayAndList;

public class MoreThanHalfNum {
    public static void main(String[] args) {
        int[] a = {1, 2, 2, 2, 3, 4, 2};
        System.out.println(MoreThanHalfNum((a)));
    }


    /**
     * 数组中超过一半的数字
     *
     * @param a
     * @return
     */
    public static int MoreThanHalfNum(int[] a) {
        int res = a[0];  //数组中的数字
        int times = 1;  // 次数
        for (int i = 1; i < a.length; i++) {
            if (times == 0) {
                res = a[i];
                times = 1;
            } else if (a[i] == res)
                times++;
            else
                times--;
        }
        return res; //最后一次将 times 置为 1 的那个数，因为要找的那个数字比其他数字数量之和还要多
    }
}
