package com.hehe.Stack_Pra;

import java.util.Stack;


/*
 * 用栈判断输入的括号序列是否有效
 *
 * */
public class IsValid_Stack {

    public static void main(String[] args) {
        String s = "()[]{}";
        boolean b = IsValid(s);
        System.out.println(b);

    }

    public static boolean IsValid(String s) {
        //栈
        Stack<Character> stk = new Stack();

        //字符串转化为字符数组
        char[] chars = s.toCharArray();

        for (char c : chars) {
            if (c == '(' || c == '{'|| c == '[') {
                stk.add(c);
            }else {
                if(stk.isEmpty())
                    return false;
                if(c == ')' && stk.pop() != '(')
                    return false;
                if(c == '}' && stk.pop() != '{')
                    return false;
                if(c == ']' && stk.pop() != '[')
                    return false;
            }
        }
        return stk.isEmpty();
    }
}