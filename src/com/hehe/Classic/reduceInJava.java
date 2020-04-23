package com.hehe.Classic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class reduceInJava {
    /**
     * 输入
     *
     * 4  input
     * 0 1  s( "0 1" ) => sArr( [0,1] )
     * 0 2
     * 1 2
     * 3 4
     * 输出  arrs
     *
     * 0 3
     * 1 2
     * 3 4
     * @param args
     * @throws IOException
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
        String input, s, sArr[];
        int[] arrs;

        while ((input = bufr.readLine()) != null) {
            int n = Integer.parseInt(input);
            arrs = new int[n + 1];
            //n次接收
            while (n > 0) {
                s = bufr.readLine();
                sArr = s.split(" ");
                if (sArr.length == 2)  //忽略 异常个数的输入行
                    arrs[Integer.parseInt(sArr[0])] += Integer.parseInt(sArr[1]);
                n--;
            }

            //arr的长度输出
            for (int i = 0; i < arrs.length; i++) {  //换成 n+1报错：详见下方
                if (arrs[i] != 0)
                    System.out.println(i + " " + arrs[i]);
            }
        }

//        Exception in thread "main" java.lang.NumberFormatException: For input string: ""
//        at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
//        at java.lang.Integer.parseInt(Integer.java:592)
//        at java.lang.Integer.parseInt(Integer.java:615)
//        at com.hehe.Classic.reduceInJava.main(reduceInJava.java:15)


    }
}
