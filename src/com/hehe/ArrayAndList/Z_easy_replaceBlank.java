package com.hehe.ArrayAndList;

import java.util.Arrays;

/**
 * jz
 * 替换空格 将每个空格 （" "）替换成 "%20"
 * we are family.
 * we%20are%20family.
 *
 * 要求:在原字符串上进行替换 并且保证输入的字符串后面有足够多的空余内存
 *
 * <p>
 * 思路：双指针，p1指向原串末尾，p2指向新串末尾，进行循环复制前移操作，p1遇空格时，p2开始依次填充 0、2、%
 * 【本次循环完要进行 p1--】
 * 循环操作即可
 */


public class Z_easy_replaceBlank {

    public static void main(String[] args) {
//        String str = "Awe are family.";
//        int len = str.length();
        char[] chars = new char[]{'w', 'e', ' ', 'a', 'r', 'e', ' ', 'f', 'a', 'm', 'i', 'l', 'y','.'};
        //java中没有 '\0' 标识一个字符数组的结尾
        char[] chars2 = new char[]{'w', 'e', ' ', 'a', 'r', 'e', ' ', 'f', 'a', 'm', 'i', 'l', 'y','.',' ',' ',' ',' '};

//        System.out.println(new String(replaceBlank(chars, 18,chars2)));
        //we%20are%20family.

        System.out.println(Arrays.toString(replaceBlank(chars, 18,chars2)));
        //[w, e, %, 2, 0, a, r, e, %, 2, 0, f, a, m, i, l, y, .]


    }

    /**
     * 字符数组的总容量
     *
     * @param chars
     * @param len   给定的原数组长度 需要的长度若大于len，即不可完成替换操作
     * @return
     */
    public static char[] replaceBlank(char[] chars, int len,char[] chars2) {
        if (chars == null || chars.length < 0)
            return new char[0];
        int len1 = chars.length;

        int lenOfOriginal = 0, lenOfNew = 0;
        int numOfBlank = 0;
        int i = 0;
        //统计原串（lenOfOriginal）长度，和空格数量（numOfBlank）
        while (i < chars.length) {
            lenOfOriginal++;
            if (chars[i] == ' ')
                numOfBlank++;
            i++;
        }

        lenOfNew = lenOfOriginal + numOfBlank * 2;
        if (lenOfNew > len)
            return new char[0];

        int p1 = lenOfOriginal - 1, p2 = lenOfNew - 1;
        while (p1 >= 0 && p1 < p2) {
            if (chars2[p1] != ' ') {
                chars2[p2--] = chars2[p1];
            } else {
                chars2[p2--] = '0';
                chars2[p2--] = '2';
                chars2[p2--] = '%';
            }
            p1--;
        }

        return chars2;

    }

}
