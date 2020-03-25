package com.hehe.String;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int ans = 0;
        for (int i = 0; i < s.length(); ) {

            if (i + 1 < s.length() && map.containsKey(s.substring(i, i + 2))) {  //先截取两个字母  如果包含直接加先最大的
                ans += map.get(s.substring(i, i + 2));
                i += 2;
            } else {
                ans += map.get(s.substring(i, i + 1));
                i += 1;
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        RomanToInt r = new RomanToInt();
        int res = r.romanToInt("XV");
        System.out.println(res);

        /**
         * PRA
         */

//        String ss = "我是中国人!";
//        //返回-1表示没有找到，你定义的ch是int型，indexof括号里的int值是对应字符的ascii码的值，而字符串里没有，所以返回-1
//        Integer d = ss.indexOf('国');  //3
//        Integer d1 = ss.indexOf("国");   //3
//        Integer d2 = ss.indexOf(0); //-1
//        System.out.println(d + " " + d1 + " " + d2);
//        Integer dd = ss.indexOf("33");  // -1
//        Integer ddd = ss.indexOf(33); //  !的ASCII码是33
//        System.out.println(dd.toString() + " " + ddd.toString());
//
//        boolean b = ss.contains("国");
//        System.out.println(b);

    }


}