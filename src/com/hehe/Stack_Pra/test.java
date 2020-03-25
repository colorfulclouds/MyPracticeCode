package com.hehe.Stack_Pra;

import java.util.HashMap;

import org.junit.Test;

public class test {

    /**
     *
     */
    public static void main(String[] args) {


        StringBuilder sbuilder = new StringBuilder();

        sbuilder.appendCodePoint(0x5b57); // 0x5b57是“字”的unicode编码
        sbuilder.appendCodePoint(0x7b26); // 0x7b26是“符”的unicode编码
        sbuilder.appendCodePoint(0x7f16); // 0x7f16是“编”的unicode编码
        sbuilder.appendCodePoint(0x7801); // 0x7801是“码”的unicode编码

        System.out.printf("%s\n\n", sbuilder);

        String num = "13456";
        char[] list = num.toCharArray();

        Object num1 = list[3];
        if (num1 instanceof Character) {
            System.out.println(num1);
        }else {
            System.out.println("判断失败");
        }


//		string 和int之间的转换
        String s = "123456";
        int i = Integer.parseInt(s);
        int i2 = Integer.valueOf(s);

        String s1 = String.valueOf(i);

//		char和int之间的转换 首先将char转换成string
        String ss = String.valueOf('3');
        int ii = Integer.valueOf(ss);



    }

    /**
     * StringBuilder 的append()示例
     */
    @Test
    private static void testAppendAPIs() {

        System.out.println("-------------------------------- testAppendAPIs -------------------------------");

        StringBuilder sbuilder = new StringBuilder();

        // 追加字符数组
        sbuilder.append(new char[]{'a','b','c','d','e'});
        // 追加字符数组。0表示字符数组起始位置，3表示长度
        sbuilder.append(new char[]{'A','B','C','D','E'}, 0, 3);
        // 追加float
        sbuilder.append(1.414f);
        // 追加double
        sbuilder.append(3.14159d);
        // 追加boolean
        sbuilder.append(true);
        // 追加char
        sbuilder.append('\n');
        // 追加int
        sbuilder.append(100);
        // 追加long
        sbuilder.append(12345L);
        // 追加StringBuilder对象
        sbuilder.append(new StringBuilder("StringBuilder"));
        // 追加StringBuilder对象。6表示被追加对象的起始位置(包括)，13是结束位置(不包括)
        sbuilder.append(new StringBuilder("STRINGBUILDER"), 6, 13);
        // 追加StringBuffer对象。
        sbuilder.append(new StringBuffer("StringBuffer"));
        // 追加StringBuffer对象。6表示被追加对象的起始位置(包括)，12是结束位置(不包括)
        sbuilder.append(new StringBuffer("STRINGBUFFER"), 6, 12);
        // 追加String对象。
        sbuilder.append("String");
        // 追加String对象。1表示被追加对象的起始位置(包括)，6是结束位置(不包括)
        sbuilder.append("0123456789", 1, 6);
        sbuilder.append('\n');

        // 追加Object对象。此处以HashMap为例
        HashMap map = new HashMap();
        map.put("1", "one");
        map.put("2", "two");
        map.put("3", "three");
        sbuilder.append(map);
        sbuilder.append('\n');

        // 追加unicode编码
        sbuilder.appendCodePoint(0x5b57);    // 0x5b57是“字”的unicode编码
        sbuilder.appendCodePoint(0x7b26);    // 0x7b26是“符”的unicode编码
        sbuilder.appendCodePoint(0x7f16);    // 0x7f16是“编”的unicode编码
        sbuilder.appendCodePoint(0x7801);    // 0x7801是“码”的unicode编码

        System.out.printf("%s\n\n", sbuilder);
    }

}
