package com.hehe.String;

/**
 * 大数问题
 * 输入n 打印从 1 到 最大的 n 位数
 * n:2
 * 1 2 3 ... 99
  */
public class PrintNumber {
    public static void main(String[] args) {
        int n = 2;
        int[] res = printNumbers(n);

        for (int x : res)
            System.out.print(x + " ");
    }

    public static int[] printNumbers(int n) {
        int[] res = new int[(int) Math.pow(10, n) - 1];
        int cur = 0;
        StringBuilder str = new StringBuilder();
        // 将str初始化为n个'0'字符组成的字符串
        for (int i = 0; i < n; i++) {
            str.append('0');
        }
        while (!increment(str)) { //判断是否溢出 无溢出 将其加入到结果数组里面
            // 去掉左侧的0 (使用截取字符串的方法)
            int index = 0;
            while (index < str.length() && str.charAt(index) == '0') {
                index++;
            }
//            System.out.println(str.toString().substring(index));
            res[cur++] = Integer.parseInt(str.toString().substring(index));
        }
        return res;
    }


    public static boolean increment(StringBuilder str) { //判断上一个字符串是否达到最大 不到最大加 1 操作
        boolean isOverflow = false;

        for (int i = str.length() - 1; i >= 0; i--) {
            char s = (char) (str.charAt(i) + 1);  //加 1 操作
            // 如果s大于'9'则发生进位
            if (s > '9') {
                str.replace(i, i + 1, "0");
                if (i == 0) {
                    isOverflow = true;
                }
            }
            // 没发生进位则跳出for循环
            else {
                str.replace(i, i + 1, String.valueOf(s));
                break;
            }
        }
        return isOverflow;
    }



}
