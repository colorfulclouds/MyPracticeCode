package com.hehe.SortAndSearch;

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
            arr[loc]--;
        }
        //其余数字放置：若奇数位未完 先按照奇数位放置 再按照偶数位放置
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
