package com.hehe.RecursiveAndDynamic;

/**
 * 把数字翻译成字符串
 * 0 : a
 * 1 : b
 * ...
 * 25 : z
 * <p>
 * 注意读题和分析：翻译规则只有a-z : (0-25)
 * 截取的 2 位数字 ，有前导为 0 的子串，需要丢弃
 * translateNum01 是考虑了 前导为零的转为整型后在合法区间的情况
 */
public class TranslateNum {
    public static void main(String[] args) {
        System.out.println(translateNum(12258));
        System.out.println(translateNum(10402));
        System.out.println(translateNum(1402));

        System.out.println("===========================");
        System.out.println(translateNum01(12258));
        System.out.println(translateNum01(10402));
        System.out.println(translateNum01(1402));

//        5
//        2
//        2
//        ===========================
//        5
//        6
//        4
    }

    /**
     * 丢弃了 前导为零的 即使转为整型后在合法区间的情况
     *
     * @param num
     * @return
     */
    public static int translateNum(int num) {
        String s = String.valueOf(num);
        int a = 1, b = 1;
        for (int i = s.length() - 2; i > -1; i--) {
            String tmp = s.substring(i, i + 2);
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }
        return a;
    }

    /**
     * 考虑了 前导为零的转为整型后在合法区间的情况
     *
     * @param num
     * @return
     */
    public static int translateNum01(int num) {
        String s = String.valueOf(num);
        int a = 1, b = 1;
        for (int j = 2; j < s.length(); j++) {
            for (int i = s.length() - j; i > -1; i--) {
                String tmp = s.substring(i, i + j);
                int c = Integer.parseInt(tmp) >= 0 && Integer.parseInt(tmp) <= 25 ? a + b : a;
                b = a;
                a = c;
            }
        }
        return a;
    }
}
