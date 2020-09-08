package com.hehe.String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 最长不重复子串
 */
public class LongestSubstring {

    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring("arabcacfr"));
//        System.out.println(lengthOfLongestSubstring01("arabcacfr"));

        System.out.println("+++++++++++++++++++++++++");
//        System.out.println(lengthOfLongestSubstring("awwke"));
//        System.out.println(lengthOfLongestSubstring("bbbbb"));
//        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println("===========================");
        System.out.println(lengthOfLongestSubstring03("awwke"));
//        System.out.println(lengthOfLongestSubstring03("bbbbb"));
//        System.out.println(lengthOfLongestSubstring03("abcabcbb"));
    }


    /**
     * 有点难懂！！
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring03(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < s.length() && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    /**
     * 1、
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
     * 2、
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring01(String s) {
        if (s.length() == 0)
            return 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;

    }

}
