package com.hehe.String;

/**
 * 大数问题
 * 输入n 打印从 1 到 最大的 n 位数
 * n:2
 * 1 2 3 ... 99
 */
public class PrintNumber {

    public static void main(String[] args) {
        System.out.println("================溢出判断的大数打印===============");
        int[] res = printNumbers(1);

        for (int x : res)
            System.out.print(x + " ");
        System.out.println();

        //==============================递归回溯法  ======================================
//        int[] dfs = printNumbers01(2);
//        for (int r : dfs) {
//            System.out.print(r + " ");
//        }
//        System.out.println();
        //==============================暴力 简单大数打印 ======================================
        int[] print = printNumbers02(2);
        for (int r : print) {
            System.out.print(r + " ");
        }
    }

    /**
     * 简单大数打印
     *
     * @param n
     * @return
     */
    public static int[] printNumbers02(int n) {
        int end = (int) Math.pow(10, n) - 1;
        int[] res = new int[end];
        for (int i = 0; i < end; i++)
            res[i] = i + 1;
        return res;
    }

    /**
     * 溢出判断的大数打印
     *
     * @param n
     * @return
     */
    public static int[] printNumbers(int n) {
        if (n <= 0) {
            return new int[]{-1};
        }

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


    //===============================================================================================================
    static int[] res;
    static int nine = 0, count = 0, start;
    static char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    /**
     * 递归回溯法  【不懂！！！】
     *
     * @param n
     * @return
     */
    public static int[] printNumbers01(int n) {
//        this.n = n;
        res = new int[(int) Math.pow(10, n) - 1];
        num = new char[n];
        start = n - 1;
        dfs(0, n);
        return res;
    }

    static void dfs(int x, int n) {
        if (x == n) {
            String s = String.valueOf(num).substring(start);
            if (!s.equals("0"))
                res[count++] = Integer.parseInt(s);
            if (n - start == nine)
                start--;
            return;
        }
        for (char i : loop) {
            if (i == '9')
                nine++;
            num[x] = i;
            dfs(x + 1, 2);
        }
        nine--;
    }


}
