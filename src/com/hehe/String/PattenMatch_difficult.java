package com.hehe.String;



/**
 *请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 *
 */
public class PattenMatch_difficult {
    public static void main(String[] args) {
//        System.out.println(isMatch("aaa", "a.a"));
//        System.out.println(isMatch("aaa", "ab*ac*a"));
//        System.out.println(isMatch("aaa", "aa.a"));
//        System.out.println(isMatch("aaa", "ab*a"));
//        System.out.println(isMatch("aaa", ".*"));
        System.out.println(isMatch("a", "ab*"));
        System.out.println(isMatch("ab", ".*c"));
        System.out.println("=====================");

//        true
//        true
//        false
//        false
//        true

        System.out.println(match("aaa".toCharArray(), "a.a".toCharArray()));
        System.out.println(match("aaa".toCharArray(), "ab*ac*a".toCharArray()));
        System.out.println(match("aaa".toCharArray(), "aa.a".toCharArray()));
        System.out.println(match("aaa".toCharArray(), "ab*a".toCharArray()));
        System.out.println(match("aaa".toCharArray(), ".*".toCharArray()));

    }

    public static boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        int strIndex = 0;
        int patternIndex = 0;
        return matchCore(str, strIndex, pattern, patternIndex);
    }

    public static boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        //有效性检验：str到尾，pattern到尾，匹配成功
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }
        //pattern先到尾，匹配失败
        if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }
        //模式第2个是*，且字符串第1个跟模式第1个匹配,分3种匹配模式；如不匹配，模式后移2位
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
                return matchCore(str, strIndex, pattern, patternIndex + 2)//模式后移2，视为x*匹配0个字符
                        || matchCore(str, strIndex + 1, pattern, patternIndex + 2)//视为模式匹配1个字符
                        || matchCore(str, strIndex + 1, pattern, patternIndex);//*匹配1个，再匹配str中的下一个
            } else {
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }
        //模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
        if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }

    static boolean isMatch(String str, String patten) {
        if (str.isEmpty() && patten.isEmpty())
            return true;
        return MatchCore(str, patten);
    }


    private static boolean MatchCore(String str, String patten) {
            if (str.isEmpty() && patten.isEmpty())
                return true;
            if(!str.isEmpty() && patten.isEmpty())
                return str.isEmpty();

        if (patten.length() > 1 && patten.charAt(1) == '*' ) { //patten 至少为 q*样子

            if (str.length() > 0 && (str.charAt(0) == patten.charAt(0) || patten.charAt(0) == '.'))
                return MatchCore(str, patten.substring(2)) //patten后面可能有 x* 去匹配 0+ 个str中的字符
                        || MatchCore(str.substring(1), patten)
                        || MatchCore(str.substring(1), patten.substring(2));
            else
                return MatchCore(str, patten.substring(2));
        }
        if (str.length() >= 1 && patten.length() >= 1 && (str.charAt(0) == patten.charAt(0)
                || patten.charAt(0) == '.' ) && str.length() >= 1 && patten.length() >= 1 )
            return MatchCore(str.substring(1), patten.substring(1));
        else
            return false;
    }


    public boolean isMatch01(String s, String p) {
        //如果正则串p为空字符串s也为空这匹配成功，如果正则串p为空但是s不是空则说明匹配失败
        if (p.isEmpty()) return s.isEmpty();
        //判断s和p的首字符是否匹配，注意要先判断s不为空
        boolean headMatched = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if (p.length() >= 2 && p.charAt(1) == '*') {//如果p的第一个元素的下一个元素是*
            //则分别对两种情况进行判断
            return isMatch01(s, p.substring(2)) ||
                    (headMatched && isMatch(s.substring(1), p));
        } else if (headMatched) {//否则，如果s和p的首字符相等
            return isMatch01(s.substring(1), p.substring(1));
        } else {
            return false;
        }
    }


}
