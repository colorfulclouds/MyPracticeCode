package com.hehe.Stack_Pra;

import java.util.Stack;

/**
 * 栈
 * 解码3[a]2[a2[bc]]
 * aaa +abcbc +abcbc
 */
public class Decoding {

    public static void main(String[] args) {
        Decoding s = new Decoding();
        String decodedString = s.decoding("3[a]2[a2[bc]]");
        System.out.println(decodedString);
    }

    /**
     * 对输入的符合要求的字符串 s 进行解码
     * @param s
     * @return
     */
    public String decoding(String s){
        Stack<String> chars = new Stack<String>();
        Stack<Integer> nums = new Stack<Integer>();

        String res = "";
        int num = 0;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            //处理两个连续的0-10的数字
            if (Character.isDigit(c)) {
                //源码 ： return getType(codePoint) == Character.DECIMAL_DIGIT_NUMBER;
                // class Character 中定义的final 变量（数字，大小写字母 都有对应的final变量）
                num = num * 10 + (c-'0');
            }else if (Character.isLetter(c)) {
                res += c;
            }else if (c == '[') {
                //res没有值的话入栈为空串  不会导致chars.pop()出现异常
                chars.push(res);
                nums.push(num);

                res = "";
                num = 0;
            } else {
                int times = nums.pop();
                String tmp = "";
                for (int j = 0; j < times; j++) {
                    tmp += res ;
                }
                res = chars.pop()+ tmp;
            }


        }

        return res;

    }

}