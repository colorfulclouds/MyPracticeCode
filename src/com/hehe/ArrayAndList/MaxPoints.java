package com.hehe.ArrayAndList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
//《字节跳动》

/*
 * 您的代码已保存
运行超时:您的程序未能在规定时间内运行结束，请检查是否循环有错或算法复杂度过大。
case通过率为70.00%
 **/

/*
 * 一组点，在坐标中若右上方无其他点则为最大点
 * 找出所有的最大点
 * */

// 输入    2      //两组点
//        1 2
//        3 4
// 输出
//        3 4

public class MaxPoints {
    //功能：找出一组点的所有的最大点，在坐标中若右上方无其他点则为
    //最大点定义：在坐标中若右上方无其他点则为
    public static void findMaxPoints(int num,Point[] points){
        Arrays.sort(points,new SortByX());
//        测试代码段：
//		for (int i = 0; i < num; i++) {
//			System.out.println("====" + points[i].x+" "+points[i].y);
//		}
        // 按照 X 从大到小排列最大点
        //最大点满足 x比前一个最大点的y值要大
        int fore = points[0].y;    //points[0]是第一个最大点
        int len = 1;  // 利用数组可覆盖的性质 使用原数组进行结果存储 有len个就遍历到len个
        for (int i = 1; i < num; i++){  //依次遍历其它点
            if (points[i].y > fore){   //满足条件的亦为最大点
                points[len].x = points[i].x;    //使用原Points类型的points数组
                points[len].y = points[i].y;
                fore = points[i].y;
                len += 1;
            }
        }
        //遍历（按x从小到大）
        for (int i = len - 1; i >= 0; i--){
            System.out.println(points[i].x + " " +points[i].y);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Point[] points = new Point[num];
        for (int i = 0; i < num; i++){
            points[i] = new Point(sc.nextInt(), sc.nextInt());
        }
        //
        findMaxPoints(num,points);

    }

    //坐标点的类
    public static class Point{
        public int x;
        public int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return this.x;
        }
        public int getY() {
            return this.y;
        }

    }


    //自定义坐标中点的排序方法  继承Comparator<Type>
    public static class SortByX implements Comparator<Point>{
        public int compare(Point o1, Point o2) {
            return o2.x - o1.x;
        }
    }


}
