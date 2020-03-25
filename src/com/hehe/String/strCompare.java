package com.hehe.String;

/**
 * 字符串比较，并返回字符串中第一个不同字母ASCII的差值
 * 定义 ： ascii码大的字符串比较大
 */
public class strCompare {

    //两个都是字符串比较 看下一个方法吧 ： myCompareTo
    public static int strCmp(String s1, String s2) {
        char[] char1 = s1.toCharArray();
        char[] char2 = s2.toCharArray();
        int flag = 0;  //默认返回值
        int m = s1.length();
        int n = s2.length();
		int ll = m > n ? n : m;  //循环截止点(以短的那个串为截止点)

        for (int i = 0; i < ll; i++) {
            if (char1[i] == char2[i]) {
                continue;
            } else if (char1[i] < char2[i]) {
                flag = -1;
                break;
            } else if (char1[i] > char2[i]) {
//                System.out.println(char1[i]);
//                System.out.println((int)char1[i]);
                flag = 1;
                break;
            } else if (char1[i] == '\n' || char2[i] == '\n') {
                return flag;
            }
        }
        return flag;
    }

   // 仿写 String的内置字符串比较方法
    public static int myCompareTo(String str1,String anotherString) {
        int len1 = str1.length();
        int len2 = anotherString.length();
        int lim = Math.min(len1, len2);
        char v1[] = str1.toCharArray();
        char v2[] = anotherString.toCharArray();

        int k = 0;
        while (k < lim) {
            char c1 = v1[k];
            char c2 = v2[k];
            if (c1 != c2) {
                return c1 - c2;
            }
            k++;
        }
        return len1-len2;
    }

    public static void main(String[] args) {
        String s1 = "123B3445";
        String s2 = "123A";
        System.out.println("两字符串的比较结果："+s1.compareTo(s2));
        System.out.println("输出结果解释：");
        System.out.println(s1 + " 和 " + s2 + " " + "字符串中第一个不同字母ASCII的差值（s1 - s2）:"+s1.compareTo(s2));
//      int flag = strCmp(s1, s2);

//      System.out.println("");
//      System.out.println(flag);


        System.out.println(myCompareTo(s1,s2));
        System.out.println(strCmp(s1,s2));
    }
}


//A :65  B :66
//a :97