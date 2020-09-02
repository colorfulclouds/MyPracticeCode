package com.interview;

import java.util.Arrays;
import java.util.Scanner;

public class Main22 {
    public static void main(String[] args) {

//        System.out.println(house(new int[]{5, 1, 4, 3, 2, 1}));
        System.out.println(house01(new int[]{5, 1, 4, 3, 2, 1}));
    }


    public static int house(int[] person) {
//        if (person.length <= 1)
//            return person.length;
//        if (person.length == 2 && person[0] != person[1])
//            return 3;
        int[] tmp = new int[person.length];
        Arrays.fill(tmp, 1);
        for (int i = 1; i < person.length; i++) {
            if (person[i] > person[i - 1])
                tmp[i] = tmp[i - 1] + 1;
        }
        if (person[0] > person[1])
            tmp[0] = tmp[1] + 1;
        int sum = 0;
        for (int num : tmp) {
            sum += num;
        }

        return sum;

    }

    public static int house01(int[] person) {
//        if (person.length <= 1)
//            return person.length;
//        if (person.length == 2 && person[0] != person[1])
//            return 3;
        int[] tmp = new int[person.length];
        Arrays.fill(tmp, 1);

        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < person.length; i++) {
                if (i != person.length - 1 && person[i] > person[i + 1] && tmp[i] <= tmp[i + 1]) {
                    tmp[i] = tmp[i + 1] + 1;
                    flag = true;
                }
                if (i > 0 && person[i] > person[i - 1] && tmp[i] <= tmp[i - 1]) {
                    tmp[i] = tmp[i - 1] + 1;
                    flag = true;
                }
            }
        }
        int sum = 0;
        for (int num : tmp) {
            sum += num;
        }

        return sum;

    }
}
