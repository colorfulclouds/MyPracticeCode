package com.hehe.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> res = get();
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    public static List<String> get() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String[] str = new String[num];
        sc = new Scanner(System.in);
        for (int i = 0; i < num; i++) {
            String s = new String(sc.nextLine());
            str[i] = s;
        }

        ArrayList<String> res = new ArrayList<String>();
        for (int i = 0; i < num; i++) {
            String s = str[i];
            if (s.length() % 8 != 0)
                s = s + "00000000";
            while (s.length() >= 8) {
                res.add(s.substring(0,8));
                s = s.substring(8);
            }
        }
        return res;
    }
}
