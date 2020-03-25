package com.hehe.Date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateDemo {
    public static void main(String[] args) {

//        month是从0开始的，而月份是从1开始的，所以month需要加一。

        //protected Calendar() :由于修饰符是protected，所以无法直接创建该对象。需要通过别的途径生成该对象。
        Calendar cal = Calendar.getInstance();  //	使用默认时区和区域设置获取日历。通过该方法生成Calendar对象。
        Date date = cal.getTime();
//        System.out.println(date.toString());
//        System.out.println(date);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = df.format(date);
        System.out.println(time);

        cal.set(2015, 9, 23, 13, 24, 15);  //month会多1 ！
        date = cal.getTime();
        System.out.println(df.format(date));   //

        cal.add(Calendar.DAY_OF_MONTH, -3);
        Date date1 = cal.getTime();
        System.out.println(df.format(date1));

        System.out.println("=======================????????  为什么calendar 被set第二次year就会加1=========================");

        Calendar calendar = Calendar.getInstance();
        int year = 2017;
        int month = 1;
        int day = 2;
        calendar.set(year, month, day);
        System.out.println(calendar.getTime());

        int year1 = 2015;
        int month1 = 12;
        int day1 = 21;
        calendar.set(year1, month1, day1);
        System.out.println(calendar.getTime());

//        Sat Jan 21 22:08:23 CST 2017
//        Thu Jan 21 22:08:23 CST 2016
//        22:08:23是运行代码的时间

        System.out.println("=======================test=========================");
        int year2 = 2017;
        int month2 = 1;
        int day2 = 2;
        cal.set(year2, month2, day2);
        System.out.println(cal.getTime());

        int year3 = 2015;
        int month3 = 10;
        int day3 = 4;
        cal.set(year3, month3, day3);
        System.out.println(cal.getTime());

//        Thu Feb 02 13:24:15 CST 2017
//        Wed Nov 04 13:24:15 CST 2015


    }
}
