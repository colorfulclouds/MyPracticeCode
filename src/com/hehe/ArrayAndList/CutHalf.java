package com.hehe.ArrayAndList;

public class CutHalf {

    /**标题：切面条

     一根高筋拉面，中间切一刀，可以得到2根面条。

     如果先对折1次，中间切一刀，可以得到3根面条。

     如果连续对折2次，中间切一刀，可以得到5根面条。

     那么，连续对折10次，中间切一刀，会得到多少面条呢？
     */

    public static void CutNoodles(int i){
        int res = (int)Math.pow(2, i)+1;
        System.out.println(i+"次对折后，"+"中间切一刀，可以得到"+ res +"根面条。");
    }

    public static void SplitPlat(int i){
        int res = i*(i+1)/2+1;
        System.out.println(i+"根线条，最多可以得到"+ res +"个平面");
    }
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int i = sc.nextInt();
        int i = 3;
        CutNoodles(i);

        SplitPlat(i);
    }
//	n条直线，最多可以把平面分为多少个区域.

}
