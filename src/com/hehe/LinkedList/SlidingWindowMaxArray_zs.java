package com.hehe.LinkedList;

import java.util.LinkedList;

/** 滑动窗口最大最小值的更新结构的应用：
 * AllLessNumSubArray_zs
 */
public class SlidingWindowMaxArray_zs {

    /**
     * 所有窗口的最大值的求解
     * O(n) : 因为 每个元素都会进出队列各一次
     * @param arr
     * @param w 已知的窗口大小
     * @return
     */
    public static int[] getMaxWindow(int[] arr, int w) {
        int[] res = new int[arr.length - w + 1];
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        int index = 0;

        if (arr.length < w || arr == null || w < 1)
            return null;

        for (int i = 0; i <arr.length; i++) {
            while(!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i])  //队尾比当前值小 出队 直到比当前值大
                qmax.pollLast();

            qmax.addLast(i);  //进队
            if(qmax.peekFirst() == i-w) //过期出队
                qmax.pollFirst();
            if(i >= w-1) //窗口到额定长度时 每次出最大值 加入最大窗口值数组
                res[index++] = arr[qmax.peekFirst()];
        }

        return res;
    }


    public static void main(String[] args) {
        int[] arr = {4,3,5,4,3,3,6,7};
        int[] res = getMaxWindow(arr,3);
        for (int i:res) {
            System.out.print(i +" ");
        }
    }

}
