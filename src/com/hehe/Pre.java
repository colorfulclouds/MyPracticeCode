package com.hehe;


import java.io.*;
import java.util.Arrays;

public class Pre {

    public static void main(String[] args) throws IOException {
        //读取该文件内容，存储到一个字符串中
        BufferedReader br = new BufferedReader(new FileReader("s.txt"));

        String str = br.readLine();
        br.close();

        //转换为字符数组
        char[] ch = str.toCharArray();
        Arrays.sort(ch);

        //字符数组转字符串
        String st = new String(ch);
        System.out.println(st);
        BufferedWriter bw = new BufferedWriter(new FileWriter("ss.txt"));
        bw.write(st);
        bw.close();
    }
}
