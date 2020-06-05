package com.hehe.RecursiveAndDynamic;

/**jz_14
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为
 * k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，
 * 我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18
 */
public class CutRope {
    public static void main(String[] args) {
        System.out.println("最后的结果是：" + maxMultiPart(6));
        System.out.println("数学方法的最后的结果是：" + maxMultiPart02(6));


        System.out.println("最后的结果是：" + maxMultiPart(9));
        System.out.println("数学方法的最后的结果是：" + maxMultiPart02(9));

    }

    /**
     * dp解法
     *
     * @param n
     * @return
     */
    public static int maxMultiPart(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 4;
        for (int i = 5; i <= n; i++) {
            for (int k = 2; k < i; k++) {
                dp[i] = Math.max(dp[i], Math.max(k * (i - k), k * dp[i - k])); //状态转移方程
            }
        }

        //状态数组输出
//        for (int i = 0; i < n+1; i++) {
//            System.out.print(dp[i] + " ");
//        }

        System.out.println();
        return dp[n];
    }

    /**
     * 除3求解
     * 推论二： 尽可能将绳子以长度 3 等分为多段时，乘积最大。
     * <p>
     * 切分规则：
     * 最优： 33 。把绳子尽可能切为多个长度为 33 的片段，留下的最后一段绳子的长度可能为 0,1,20,1,2 三种情况。
     * 次优： 22 。若最后一段绳子长度为 22 ；则保留，不再拆为 1+11+1 。
     * 最差： 11 。若最后一段绳子长度为 11 ；则应把一份 3 + 1替换为 2 + 2，因为 2 * 2 > 3 * 1。
     * <p>
     * 绳子切分方案乘积结论[https://leetcode-cn.com/problems/jian-sheng-zi-lcof/solution/mian-shi-ti-14-i-jian-sheng-zi-tan-xin-si-xiang-by/]
     * 2=1+1	1 1×1=1	22 不应切分
     * 3=1+2	1 1×2=2	33 不应切分
     * 4=2+2=1+3	2×2=4>1×3=3	44 和 22 等价，且 2+22+2 比 1+31+3 更优
     * 5=2+3=1+4	2×3=6>1×4=4	55 应切分为 2+32+3
     * 6=3+3=2+2+2 3×3=9>2×2×2=8	66 应切分为 3+33+3 ，进而推出 33 比 22 更优
     * >7>7	...	长绳（长度>7）可转化为多个短绳（长度1~6），因此肯定应切分
     *
     * @param n
     * @return
     */
    public static int maxMultiPart02(int n) {
        if (n <= 3) return n - 1;
        int num3 = n / 3;
        if (n % 3 == 1) {
            num3 -= 1;
            return (int) (Math.pow(3, num3) * 4);
        } else if (n % 3 == 2)
            return (int) Math.pow(3, num3) * 2;
        else
            return (int) Math.pow(3, num3);
    }


}
