package com.hehe.String;
/**
 * 大数问题
 * 输入n 打印从 1 到 最大的 n 位数
 * n:2
 * 1 2 3 ... 99
 */
public class PrintNumber01 {
    public static void main(String[] args) {
        int[] res = printNumbers(2);
        for(int r : res){
            System.out.print(r+ " ");
        }

    }

    static int[] res;
    static int nine = 0, count = 0, start;
    static char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    /**
     * 递归回溯法  【不懂！！！】
     * @param n
     * @return
     */
    public static int[] printNumbers(int n) {
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
