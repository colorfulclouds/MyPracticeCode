package com.interview;

import java.util.Scanner;
import java.util.Stack;


public class T20200823_aiqy2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        boolean b = IsValid(s);
        if(b)
            System.out.println("True");
        else
            System.out.println("False");

    }

    public static boolean IsValid(String s) {

        Stack<Character> stk = new Stack();
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
