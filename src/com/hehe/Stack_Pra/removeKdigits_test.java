package com.hehe.Stack_Pra;

import java.util.ArrayList;
import java.util.List;

//import org.hamcrest.core.IsEqual;

public class removeKdigits_test {

    public static void main(String[] args) {
        rmKdigits(new String("3400236"), 3);

    }


    /* 思路：
     *栈空入栈  非空判断  当前数字比栈顶小 && 删除标记大于零（可删）：top--  删除标记k--
     *
     * */
    public static void  rmKdigits(String num, int k) {

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
            char[] stk = new char[len]; // 模拟栈

            for (int i = 0; i < len; i++) {
                char c = num.charAt(i);
                while (top > 0 && stk[top - 1] > c && _k > 0) {
                    top--;
                    _k--;
                }
                stk[top++] = c;
            }

            // 从头开始查找头个不为0的元素位置
            int idx = 0;
            int digits = len-k;
            while (idx < digits && stk[idx] == '0') {
                idx++;
            }
//			for (int i = 0; i <digits; i++) {
//				System.out.print(stk[i]);
//			}
            if(idx == digits){
                System.out.println(0);
            }else{
                System.out.println(new String(stk, idx,digits - idx));
            }
            // 如果0的长度=所需长度（即剩下的都是0）则输出0，否则输出前digits长度的字符串

        }

    }

    // 将剩余字符串 强制转化为整数

    public static String rmKdigits1(String num, int k) {

        List<Character> charlist = new ArrayList<Character>();
        char[] chars = num.toCharArray();
        for (char c : chars) {
            while (charlist.size() > 0 && k > 0
                    && charlist.get(charlist.size() - 1) > c) {
                charlist.remove(charlist.size() - 1);
                k--;
            }
            charlist.add(c);
        }
        // k可能大于0，那么将res中后面的k个元素移除
        for (int i = 0; i < k; i++) {
            charlist.remove(charlist.size() - 1);
        }

        StringBuilder res = new StringBuilder();

        boolean flag = false;
        for (int i = 0; i < charlist.size(); i++) {
            if (charlist.get(i) != '0') {
                res.append(charlist.get(i));
                flag = true;
            } else {
                if (flag) {
                    res.append(charlist.get(i));
                }
            }
        }
        // 代表结果全为0，返回0
        if (!flag) {
            return "0";
        }
        return res.toString();
    }
}