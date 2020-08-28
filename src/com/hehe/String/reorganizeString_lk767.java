package com.hehe.String;

/**
 *给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 *zzzzaabbb
 * zazbzbzba
 *
 * 思路：
 * 1 new 一个26个长的int数组, 讲所有字符放入数组中
 * 2 找出数量最多的字符
 * 3 将最多的字符放在偶数为
 * 4 将其与字符补位在偶数位后,在补齐所有奇数位
 * 5 输出结果
 */

public class reorganizeString_lk767 {
    public static void main(String[] args) {
        String sss = recognizeString(new String("zzzzaabbb"));
        System.out.println(sss);

    }

    public static String recognizeString(String s) {
        char[] chars = s.toCharArray();
        int[] arr = new int[26];

        //统计 并找到最大数量元素的那个下标
        int count = 0, loc = -1;
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            arr[index]++;
            if (count < arr[index]) {
                count = arr[index];
                loc = index;
            }
        }
        //最大元素个数 若超过总元素个数的一半 返回空串
        int len = chars.length;
        if (len % 2 == 0 && count > len / 2)
            return "";
        if (len % 2 != 0 && count > len / 2 + 1)
            return "";
//        System.out.println(loc);
//        System.out.println(count);

        //先奇数位 后偶数位 放置元素
        //偶数位置元素的放置
        int evenIndex = 0;
        char maxNumChar = (char) (loc + 'a');
        while (arr[loc] > 0) {
            chars[evenIndex] = maxNumChar;  //复用原字符数组
            evenIndex += 2;
            arr[loc]--;  //！
        }
        //其余数字放置：若奇数位未完 先将奇数位填充完 再按照偶数位放置
        int oddIndex = 1;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            char cur = (char) (i + 'a');
            while (num > 0) {  //+ 注意条件变量变化的把控 +
                if (evenIndex < chars.length) {
                    chars[evenIndex] = cur;
                    evenIndex += 2;
                } else {
                    chars[oddIndex] = cur;
                    oddIndex += 2;
                }
                num--;
            }
        }
        return new String(chars);
    }
}
