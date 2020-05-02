package com.hehe.Classic;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

/**
 * IP地址匹配
 *
 * 202.112.14.137 202.112.14.128 255.255.255.224
 * [202, 112, 14, 137]
 * [202, 112, 14, 128]
 * [255, 255, 255, 224]
 * 1 202.112.14.128   1 代表匹配 后者是网段
 */
public class IPTest {
    static boolean judge(String s, IP ip) {
        String[] split = s.split("\\.");
        System.out.println(Arrays.toString(split));
        ip.a = Integer.parseInt(split[0]);
        if (ip.a > 255) return false;

        ip.b = Integer.parseInt(split[1]);
        if (ip.b > 255) return false;

        ip.c = Integer.parseInt(split[2]);
        if (ip.c > 255) return false;

        ip.d = Integer.parseInt(split[3]);
        return ip.d <= 255;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //s1是IP1 ，s2是IP2, s3是子网掩码
        String s1, s2, s3;
        while (in.hasNext()) {
            s1 = in.next();
            s2 = in.next();
            s3 = in.next();
            IP t1 = new IP(), t2 = new IP(), t3 = new IP();
            if (judge(s1, t1) && judge(s2, t2) && judge(s3, t3)) {
                t1.a = t3.a & t1.a;
                t1.b = t3.b & t1.b;
                t1.c = t3.c & t1.c;
                t1.d = t3.d & t1.d;

                t2.a = t3.a & t2.a;
                t2.b = t3.b & t2.b;
                t2.c = t3.c & t2.c;
                t2.d = t3.d & t2.d;

                if (t1.equals(t2))
                    System.out.print(1);
                else
                    System.out.print(0);
            } else {
                System.out.print(0);
            }
            System.out.println(" " + t1.a + '.' + t1.b + '.' + t1.c + '.' + t1.d);
        }
    }


}

class IP {

    int a, b, c, d;
    @Override
    public int hashCode() {
        return Objects.hash(a, b, c, d);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(o == null) return false;
        if (!(o instanceof IP)) return false;
        if (o == null || getClass() != o.getClass()) return false;  //自动生成的equals方法里面的 o.getClass()获取类的定义信息
        IP ip = (IP) o;
        return a == ip.a &&
                b == ip.b &&
                c == ip.c &&
                d == ip.d;
    }

    public IP() {
    }
}