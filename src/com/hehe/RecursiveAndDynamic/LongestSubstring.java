package com.hehe.RecursiveAndDynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长不重复子串
 */
public class LongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("arabcacfr"));
        System.out.println(lengthOfLongestSubstring01("arabcacfr"));
    }

    /**
     * 1、
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
