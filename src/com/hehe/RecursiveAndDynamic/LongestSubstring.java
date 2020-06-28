package com.hehe.RecursiveAndDynamic;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("arabcacfr"));
    }
    public static int lengthOfLongestSubstring(String s) {
        int res = 0,tmp = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int index = map.getOrDefault(s.charAt(i),-1);

            //tmp只记录当前的不重复的子串的长度 小于成立说明不重复 大于说明当前非最长 而tmp只记录当前长度 故 赋给它i-index
            tmp = tmp < i-index ? tmp + 1 : i - index; // dp[j - 1] -> dp[j]

            res = Math.max(tmp,res);  // max(dp[j - 1], dp[j])
            map.put(s.charAt(i),i); //更新哈希表
        }

        return res;
    }

}
