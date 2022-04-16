package com.hehe.HuaWei;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

  /*
        磁盘的容量单位常用的有
        M G T
        他们之间的换算关系为 1T =1024G 1G=1024M
        现在给定n块磁盘的容量，请对他们按从小到大的顺序进行稳定排序
        例如给定5块盘的容量
        5
        1T
        20M
        3G
        10G6T
        3M12G9M
        排序后的结果为
        20M
        3G
        3M 12G 9M
        1T,10G 6T
        注意单位可以重复出现
        上述3M 12G 9M表示的容量即为 3M 12G 9M 和12M 12G相等
        输入描述、
          输入第一行包含一个整数n
          2<=n<=100 表示磁盘的个数
          接下来的n行
          每行一个字符串
          2<长度<30
          表示磁盘的容量
          由一个或多个格式为MV的子串组成
          其中m表示容量大小
          v表示容量单位
          例如20M 1T
          磁盘容量的范围1~1024的正整数
          单位 M G T
         输出n行
         表示n块磁盘容量排序后的结果
         实例
         输入
         3
         1G
         2G
         1024M
        输出
        1G
        1024M
        2G
        说明：稳定排序要求相等值保留原来位置
        示例2
        3
        2G4m
        3M2G
        1T
        输出
        3M2G
        2G4M
        1T
         */

public class SortDiskSize {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(in.nextLine());
        }
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(calc(o1), calc(o2));
            }
        });

        for (String s : list) {
            System.out.println(s);
        }

        in.close();

    }

    static int calc(String str) {
        int size = 0;
        String upper = str.toUpperCase();
        String[] split = upper.split("[A-Z]");
        int length = 0;
        for (String s : split) {
            length += s.length();
            int num = Integer.parseInt(s);
            String substring = upper.substring(length, length + 1);
            switch (substring) {
                case "M":
                    size += num;
                    break;
                case "G":
                    size += num * 1024;
                    break;
                case "T":
                    size += num * 1024 * 1024;
                    break;
            }
            length++;
        }
        return size;
    }
}
