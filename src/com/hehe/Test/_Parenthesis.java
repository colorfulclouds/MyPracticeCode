package com.hehe.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _Parenthesis {

    public static List<String> list = new ArrayList<String>();

    public static void algorithm(int num, int n, int len, String s) {
        if (num == 0 && len == n) {
            list.add(s);
            return;
        }
        if (len < n) {
            algorithm(num + 1, n, len + 1, s + '(');
        }
        if (num > 0) {
            algorithm(num - 1, n, len, s + ')');
        }
    }

    public static List<String> generateParenthesis(int n) {

//		Set<String> set = new HashSet<String>();
        algorithm(1, n, 1, "(");
        Scanner sc =new Scanner(System.in);
//		sc.next

        return list;
    }



    public static void main(String[] args) {
        List<String> list = generateParenthesis(4);
        System.out.println(list.size());
        for(String l:list){
            System.out.println(l);

        }
        int n = 3;
        int k = 2;

    }

    // static void printParenthesis(int pos , int n , int open ,int close
    // ,char[] buffer){
    // if(close == n){
    // //System.out.println("over");
    // System.out.println(new String(buffer));
    //
    // return;
    // }
    // if(open >close){
    // buffer[pos]=')';
    // printParenthesis(pos+1, n, open, close+1, buffer);
    //
    // }
    //
    // if(open <n){
    // buffer[pos] = '(';
    // printParenthesis(pos+1, n, open+1, close, buffer);
    // }
    //
    // }
    // public static void main(String[] args) {
    // int n = 4;
    // char[] cs = new char[8];
    // printParenthesis(0, 4, 0, 0, cs);
    // }

}
