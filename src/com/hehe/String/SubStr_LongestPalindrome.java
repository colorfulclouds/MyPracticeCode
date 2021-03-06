package com.hehe.String;

public class SubStr_LongestPalindrome {
    public static void main(String[] args) {

        System.out.println("=============中心扩展法==============");
        String s = "abbbaacd";
//        String s = "abad";
        System.out.println("回文串的个数：" + numOfPalindrome(s)[0]);
        System.out.println("回文串的长度：" + numOfPalindrome(s)[1]);
        System.out.println("最长回文串是：" + longestPalindrome(s));

        System.out.println("=============暴 力 法==============");
        System.out.println(LongeastPalindrome01(s));
        System.out.println(LongeastPalindrome02(s));

        System.out.println("=============最长回文子串 Manacher==============");
        System.out.println(LongeastPalindrome03("abccccdd"));
        System.out.println(LongeastPalindrome03(s));


        System.out.println("==============未看=================");
        System.out.println(longestPalindromeX(s));
        String str1 = "abc1234321ab";
        System.out.println(maxLcpsLength(str1));
    }

    /**
     * 1、zf 中心扩展法
     * 回文串的个数和最长回文子串
     *
     * @param s
     * @return
     */
    public static int[] numOfPalindrome(String s) {
        int[] res = new int[2];
        int n = 2 * s.length() - 1;  //从第一个到最后一个字母 依次以一个或者连续两个元素为中心扩展
        int maxLen = 0;
//        String ss = "";
        for (int i = 0; i < n; i++) {
            int left = i / 2;
            int right = left + i % 2;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right - left > 0) //记录所有的回文子串的个数
                    res[0]++;
//                if(right - left + 1 > maxLen)  //截取最长的回文子串本串
//                    ss = s.substring(left,right+1);
                maxLen = Math.max(maxLen, right - left + 1); //最长的回文子串的长度

                left--;
                right++;

            }
        }
        res[1] = maxLen;
        return res;
    }

    /**
     * 最长的回文子串，只返回 回文串
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int n = 2 * s.length() - 1; //遍历时 需要中心扩展的次数，即所有的中心点（两个或者一个字符都可以作为中心点）
        int maxLen = 0;
        String res = "";

        for (int i = 0; i < n; i++) {
            int left = i / 2;
            int right = left + i % 2;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if ((right - left + 1) > maxLen) {
                    res = s.substring(left, right + 1);
                    maxLen = right - left + 1;
                }
                left--;
                right++;
            }
        }

        return res;
    }


    /**
     * 2 、最长回文子串 --暴力
     *
     * @param s
     * @return
     */
    public static String LongeastPalindrome01(String s) {
        String res = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String t = s.substring(i, j);
                String rt = new StringBuffer(t).reverse().toString();
                if (t.equals(rt) && t.length() > res.length()) {
                    res = t;
                }
            }
        }
        return res;
    }


    /**
     * 最长回文子串 暴力
     * O（n^3）
     *
     * @param s
     * @return
     */
    public static String LongeastPalindrome02(String s) {
//        if (s == null || s.length() <= 0)
//            return null;
        if (s.length() < 2) {
            return s;
        }
        int maxLen = 0;
        int begin = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 1; j < chars.length; j++) {
                if (j - i + 1 > maxLen && validPalindromic(chars, i, j)) {  //i ~ j的字符串是否是回文串
                    begin = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(begin, begin + maxLen);

    }

    /**
     * 验证子串 s[left..right] 是否为回文串
     */
    private static boolean validPalindromic(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right])
                return false;
            left++;
            right--;
        }
        return true;
    }


    /**
     * 3、最长回文子串 Manacher
     * O（N^2）
     *
     * @param s
     * @return
     */
    public static String LongeastPalindrome03(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        String str = addBoundaries(s, '#');   //加边界
        int sLen = 2 * len + 1;
        int maxLen = 1;

        int start = 0;
        for (int i = 0; i < sLen; i++) {
            int curLen = centerSpread(str, i);   //中心扩散求长度
            if (curLen > maxLen) {
                maxLen = curLen;
                start = (i - maxLen) / 2;
            }
        }
        return s.substring(start, start + maxLen);
    }

    /**
     * 中心扩散求长度
     *
     * @param s
     * @param center
     * @return
     */
    private static int centerSpread(String s, int center) {
        int len = s.length();
        int i = center - 1;
        int j = center + 1;
        int step = 0;
        while (i >= 0 && j < len && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
            step++;
        }
        return step;
    }

    /**
     * 创建预处理字符串
     *
     * @param s      原始字符串
     * @param divide 分隔字符
     * @return 使用分隔字符处理以后得到的字符串
     */
    private static String addBoundaries(String s, char divide) {
        int len = s.length();
        if (len == 0) {
            return "";
        }
        if (s.indexOf(divide) != -1) {
            throw new IllegalArgumentException("参数错误，您传递的分割字符，在输入字符串中存在！");
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(divide);
            sb.append(s.charAt(i));
        }
        sb.append(divide);
        return sb.toString();
    }


    //===============================================未看============================================================

    /**
     * 4、最长回文子串 Manacher
     * O（N）
     *
     * @param s
     * @return
     */
    public static String longestPalindromeX(String s) {
        // 特判
        int len = s.length();
        if (len < 2) {
            return s;
        }

        // 得到预处理字符串
        String str = addBoundaries(s, '#');
        // 新字符串的长度
        int sLen = 2 * len + 1;

        // 数组 p 记录了扫描过的回文子串的信息
        int[] p = new int[sLen];

        // 双指针，它们是一一对应的，须同时更新
        int maxRight = 0;
        int center = 0;

        // 当前遍历的中心最大扩散步数，其值等于原始字符串的最长回文子串的长度
        int maxLen = 1;
        // 原始字符串的最长回文子串的起始位置，与 maxLen 必须同时更新
        int start = 0;

        for (int i = 0; i < sLen; i++) {
            if (i < maxRight) {
                int mirror = 2 * center - i;
                // 这一行代码是 Manacher 算法的关键所在，要结合图形来理解
                p[i] = Math.min(maxRight - i, p[mirror]);
            }

            // 下一次尝试扩散的左右起点，能扩散的步数直接加到 p[i] 中
            int left = i - (1 + p[i]);
            int right = i + (1 + p[i]);

            // left >= 0 && right < sLen 保证不越界
            // str.charAt(left) == str.charAt(right) 表示可以扩散 1 次
            while (left >= 0 && right < sLen && str.charAt(left) == str.charAt(right)) {
                p[i]++;
                left--;
                right++;

            }
            // 根据 maxRight 的定义，它是遍历过的 i 的 i + p[i] 的最大者
            // 如果 maxRight 的值越大，进入上面 i < maxRight 的判断的可能性就越大，这样就可以重复利用之前判断过的回文信息了
            if (i + p[i] > maxRight) {
                // maxRight 和 center 需要同时更新
                maxRight = i + p[i];
                center = i;
            }
            if (p[i] > maxLen) {
                // 记录最长回文子串的长度和相应它在原始字符串中的起点
                maxLen = p[i];
                start = (i - maxLen) / 2;
            }
        }
        return s.substring(start, start + maxLen);
    }


    //======================================================================================================
    public static char[] manacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }

    public static int maxLcpsLength(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] charArr = manacherString(str);
        int[] pArr = new int[charArr.length]; //回文半径数组
        int index = -1;
        int pR = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i != charArr.length; i++) {
            pArr[i] = pR > i ? Math.min(pArr[2 * index - i], pR - i) : 1;
            while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
                if (charArr[i + pArr[i]] == charArr[i - pArr[i]])
                    pArr[i]++;
                else {
                    break;
                }
            }
            if (i + pArr[i] > pR) {
                pR = i + pArr[i];
                index = i;
            }
            max = Math.max(max, pArr[i]);
        }
        return max - 1;
    }
}
