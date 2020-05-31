package com.hehe.Stack_Pra;


import java.util.LinkedList;

/**
 *去掉K位数字  使剩下的数字组合的值最小
 */


/*
 * 成功
显示详情
执行用时 : 4 ms, 在Remove K Digits的Java提交中击败了98.25% 的用户
内存消耗 : 38.1 PMB, 在Remove K Digits的Java提交中击败了15.38% 的用户
 *
 *
 * */
public class removeKdigits {

    public static void main(String[] args) {
        rmKdigits(new String("3400236"), 3);

    }


    public String removeKdigits(String num, int k) {
        LinkedList<Character> stack = new LinkedList<Character>();

        for(char digit : num.toCharArray()) {
            while(stack.size() > 0 && k > 0 && stack.peekLast() > digit) {
                stack.removeLast();
                k -= 1;
            }
            stack.addLast(digit);
        }

        /* remove the remaining digits from the tail. */
        for(int i=0; i<k; ++i) {
            stack.removeLast();
        }

        // build the final string, while removing the leading zeros.
        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        for(char digit: stack) {
            if(leadingZero && digit == '0') continue;
            leadingZero = false;
            ret.append(digit);
        }

        /* return the final string  */
        if (ret.length() == 0) return "0";
        return ret.toString();
    }


    private static void rmKdigits(String num, int k) {
        int len = num.length(); // 原串的总长度

        // 特殊情况
        if (k >= len || len == 0) {
            System.out.println(0);
        } else if (k <= 0) {
            System.out.println(num);
        } else {
            //见思路
            int top = 0;
            int _k = k;
            char[] stk = new char[len];    // 模拟栈

            for (int i = 0; i < len; i++) {
                char c = num.charAt(i);
                while (top > 0 && stk[top - 1] > c && _k > 0) {
                    top--;
                    _k--;
                }
                stk[top++] = c;
            }
            // 从头开始查找头个不为0的元素位置,并从当前位置开始输出到指定位数
            int idx = 0;
            int digits = len - k;
            while (idx < digits && stk[idx] == '0') {
                idx++;
            }
            if (idx == digits) {
                System.out.println(0);
            } else {
                System.out.println(new String(stk, idx, digits - idx));
            }
            // 如果0的长度=所需长度（即剩下的都是0）则输出0，否则输出前digits长度的字符串
        }
    }



}



