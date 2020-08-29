package com.hehe.Stack_Pra;

import java.util.*;

import static javafx.scene.input.KeyCode.R;

/**
 * n个矩形箱子宽度、高度均在【1，100】之间
 * 就n个矩形块的最大矩形面积
 * [1,1,1,1,2,1,1],[5,2,5,4,5,1,6]
 */
public class MaxRect {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int index = str.indexOf(']');

        if (index == -1 || index == str.length() - 1) {
            System.out.println("0");
            return;
        }
        /*if(str.charAt(0) != '[' || str.charAt(index+1) != ',' || str.charAt(index+2) != '[' || str.charAt(str.length()-1) != ']'){
            System.out.println("0");
            return;
        }*/
        String w = str.substring(1, index);
        String h = str.substring(index + 3, str.length() - 1);
        String[] wStr = w.split(",");
        String[] hStr = h.split(",");

        int[] width = new int[wStr.length];
        for (int i = 0; i < wStr.length; i++) {
            width[i] = Integer.parseInt(wStr[i]);
            if (width[i] < 1 || width[i] > 100) {
                System.out.println("0");
                return;
            }
        }
        int[] height = new int[hStr.length];
        for (int i = 0; i < hStr.length; i++) {
            height[i] = Integer.parseInt(hStr[i]);
            if (height[i] < 1 || height[i] > 100) {
                System.out.println("0");
                return;
            }
        }
        System.out.println(helper(width, height));
    }

    public static int helper(int[] width, int[] height) {
        int n = width.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Arrays.fill(right, n);  //? all 7
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {  //单调栈（求每个数左右比其小的第一个数）
                right[stack.peek()] = i;
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        int res = 0;
        for (int i = 0; i < n; ++i) {
            int totalWidth = 0;
            for (int index = left[i] + 1; index <= right[i] - 1; index++) {
                totalWidth += width[index];
            }
            res = Math.max(res, totalWidth * height[i]);
        }
        return res;
    }

}
