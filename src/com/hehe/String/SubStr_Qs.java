package com.hehe.String;

import java.util.*;

public class SubStr_Qs {

    public static void main(String[] args) {
        System.out.println("+++++++++++ 最长不重复子串++++++++++++++");
        System.out.println(lengthOfLongestSubstring("arabcacfr"));
        System.out.println(lengthOfLongestSubstring("awwke"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        //System.out.println(repeatedSubstringPattern("abaababaab"));


        System.out.println("==========最长完美字串===========================");
        String s = "aabbaabaa";
        int res = characterReplacement(s, 2);
        int res1 = characterReplacement(s, 1);
        System.out.println(res);
        System.out.println(res1);

        System.out.println("==========一串字符能组成的 最长回文串============");
        String ss = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        System.out.println(longestPalindrome(ss));
        System.out.println(longestPalindrome("abaaccccddd"));


        System.out.println("=====================最长公共子串===========================");
        String a = "abcdefg";
        String b = "cdefg";
        String res2 = getLCS(a, b);
        int res3 = getLCS01(a, b);
        System.out.println(res2);
        System.out.println(res3);
        System.out.println("===============================================");
        String c = "cdeg";
        String res4 = getLCS(a, c);
        int res5 = getLCS01(a, c);
        System.out.println(res4);
        System.out.println(res5);
        System.out.println("===============================================");
        String d = "";
        String res6 = getLCS(a, d);
        int res7 = getLCS01(a, d);
        System.out.println(res6);
        System.out.println(res7);

        System.out.println("+++++++++++++++++++++参数顺序测试+++++++++++++++++++++++++++");
        System.out.println(getLCS(b, a));
        System.out.println(getLCS01(b, a));
//
        System.out.println("=====================循环左移======================");
        System.out.println(leftCycleMoveStrings("helloword", 5));
        System.out.println(leftCycleMoveStrings("helloword", 6));

    }

    /**
     * 字符串循环左移 n个字符
     * @param s
     * @param n
     * @return
     */
    public static String leftCycleMoveStrings(String s, int n) {
        int len = s.length();
        if (len < 2)
            return s;
        if (n > len)
            n = n % len;
        String tmp = s.substring(0, n);
        s = s.substring(n, len);
        s += tmp;
        return s;
    }

    /**
     * 最长不重复子串
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int res = 0, tmp = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int index = map.getOrDefault(s.charAt(i), -1);

            //tmp只记录当前的不重复的子串的长度 小于成立说明不重复 大于说明当前非最长
            //而tmp只记录以当前字符结尾的无重复字符的长度 故 赋给它i-index
            tmp = tmp < i - index ? tmp + 1 : i - index; // dp[j - 1] -> dp[j]

            res = Math.max(tmp, res);  // max(dp[j - 1], dp[j])
            map.put(s.charAt(i), i); //更新哈希表
        }
        return res;
    }

    /**
     * 一串字符能组成的 最长回文串
     *
     * @param s
     * @return
     */
    public static int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        Set<Character> set = map.keySet();
        int totalLen = 0;
        for (Character c : set) {
            int num = map.get(c);
            totalLen += num / 2 * 2;
            if (totalLen % 2 == 0 && num % 2 != 0)
                totalLen++;
        }
        return totalLen;

    }

    /**
     * 最长完美字串
     * 滑动窗口
     *
     * @param s
     * @param k
     * @return
     */
    public static int characterReplacement(String s, int k) {
        int[] map = new int[26];
        if (s == null) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        int historyCharMax = 0;

//        int res = 0; //可以定义结果变量 方便理解
        for (right = 0; right < chars.length; right++) { //窗口右侧一直往右移
            int index = chars[right] - 'a';
            map[index]++;
            historyCharMax = Math.max(historyCharMax, map[index]);
            if (right - left + 1 > historyCharMax + k) {
                //窗口内替换后仍无法达到历史最大完美子串长度 故窗口左侧边界收缩
                map[chars[left] - 'a']--;
                left++;
            }
        }
        return chars.length - left;  //返回的是历史最大的窗口大小
//        return res;
    }


    /**
     * LCS 最长公共子串（非最优解法）
     *
     * @param str2
     * @param str1
     * @return
     */
    public static String getLCS(String str2, String str1) {
        if (str1 == null || str2 == null) {
            return new String();
        }
        str1 = " " + str1;
        str2 = " " + str2;
        int[][] record = new int[str2.length()][str1.length()];
        int maxLen = 0, maxEnd = 0;

        for (int i = 1; i < str2.length(); ++i)
            for (int j = 1; j < str1.length(); ++j) {
                if (str2.charAt(i) == str1.charAt(j)) {
                    record[i][j] = record[i - 1][j - 1] + 1;
                } else {
                    record[i][j] = 0;
                }
                if (record[i][j] > maxLen) {
                    maxLen = record[i][j];
                    maxEnd = j; //若记录i,则最后获取LCS时是取str1的子串
                }
            }
        return str1.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }

    /**
     * LCS 最长公共子串 （经典解法）
     *
     * @param s
     * @param t
     * @return
     */
    public static int getLCS01(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return 0;
        }
        int result = 0;
        int sLength = s.length();
        int tLength = t.length();
        int[][] dp = new int[sLength][tLength];
        //int end = 0;

        for (int i = 0; i < sLength; i++) {
            for (int k = 0; k < tLength; k++) {
                if (s.charAt(i) == t.charAt(k)) {
                    if (i == 0 || k == 0) {
                        dp[i][k] = 1;
                    } else {
                        dp[i][k] = dp[i - 1][k - 1] + 1;
                    }
//                    if(dp[i][k] > result) //记录最长公共子串的末位下标
//                        end = k;
                    result = Math.max(dp[i][k], result);

                }
            }
        }
        //String res = t.substring(end - result + 1,end +1); //截取最长的公共子串
        return result;
    }


    /**
     * 判断字符串是否由重复的子串构成
     *
     * @param s
     * @return
     */
    public static boolean repeatedSubstringPattern(String s) {

        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);

//        return (s + s).indexOf(s, 1) != s.length();
    }


}
