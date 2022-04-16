package com.hehe.HuaWei;

public class TimeOfProcessNumber {
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4, 5};
        int[] num1 = {1, 2, 3};
        System.out.println(process(num, 3));
        System.out.println(process(num1, 3));
        System.out.println("+++++++++++++ diff speed +++++++++++++++");
        int[] num2 = {1, 2, 3, 4, 5};
        int[] num3 = {1, 2, 3};
        System.out.println(process(num2, 6));
        System.out.println(process(num3, 6));
    }

    private static int process(int[] num, int speed) {
        int task = 0;
        int count = 0;
        for (int i = 0; i < num.length; i++) {
            task += num[i];
            task = task < speed ? 0 : task - speed;
            count++;
        }
        while (task > speed) {
            count++;
            task -= speed;
        }
        if (task > 0)
            count++;

        return count;
    }


}
