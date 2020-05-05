package com.hehe.Stack_Pra;

import java.util.Scanner;
import java.util.Stack;

public class _Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<String> chars = new Stack<>();
        Stack<Integer> nums = new Stack<>();

        String res = "";
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c))
                num = num * 10 + (c - '0');
            else if (Character.isLetter(c))
                res += c;
            else if (c == '[') {
                nums.push(num);
                chars.push(res);
                res = "";
                num = 0;
            } else {
                int times = nums.pop();
                String temp = "";
                for (int j = 0; j < times; j++) {
                    temp += res;
                }
                res = chars.pop() + temp;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<res.length();i++){
            sb.append(res.charAt(i));
        }
        System.out.println(sb.reverse());
//		return res;
    }


}