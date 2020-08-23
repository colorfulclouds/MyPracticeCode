package com.hehe.Classic;
import java.awt.*;  //第一次使用这个包
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 给你一个字符串 path，其中 path[i] 的值可以是 'N'、'S'、'E' 或者 'W'，分别表示向北、向南、向东、向西移动一个单位。
 * 机器人从二维平面上的原点 (0, 0) 处开始出发，按 path 所指示的路径行走。如果路径在任何位置上出现相交的情况，
 * 也就是走到之前已经走过的位置，请返回 True ；否则，返回 False 。
 *
 * 输入描述
 * 一个字符串 path，其中 path[i] 的值可以是 'N'、'S'、'E' 或者 'W'，分别表示向北、向南、向东、向西移动一个单位。
 *
 * 输出描述
 * 如果路径在任何位置上出现相交的情况，也就是走到之前已经走过的位置，请返回 True ；否则，返回 False 。
 *
 * 样例输入
 * ESSWNEE
 * 样例输出
 * True
 */

/**
 * T20200823_aiqy2
 * java.awt.Point;
 */
public class WalkCross {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] char_array = sc.nextLine().toCharArray();
        if(char_array.length == 0){
            System.out.println("False");
            return;
        }
        Set<Point> points = new HashSet(); //Set去重Point
        Point p = new Point(0,0);
        points.add(p);

        int i = 0;
        while (i < char_array.length){
            Point tmp_Point = null;
            if(char_array[i] == 'N'){
                tmp_Point = new Point(p.x,p.y+1);
                if(!points.add(tmp_Point)){
                    System.out.println("True");
                    return;
                }
            }else if(char_array[i] == 'S'){
                tmp_Point = new Point(p.x,p.y-1);
                if(!points.add(tmp_Point)){
                    System.out.println("True");
                    return;
                }
            }else if(char_array[i] == 'W'){
                tmp_Point = new Point(p.x-1,p.y);
                if(!points.add(tmp_Point)){
                    System.out.println("True");
                    return;
                }
            }else if(char_array[i] == 'E'){
                tmp_Point = new Point(p.x+1,p.y);
                if(!points.add(tmp_Point)){
                    System.out.println("True");
                    return;
                }
            }

            i++;
            p = tmp_Point;
        }
        System.out.println("False");
    }



}
