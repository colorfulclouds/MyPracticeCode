package com.hehe.Date;

import java.text.SimpleDateFormat;
import java.util.*;

public class DateTest {
    public static void main(String[] args) {
        System.out.println("最近一个月的月初和月末的日期：");
        getRecentMonths(1);
        System.out.println("最近两个月的月初和月末的日期：");
        getRecentMonths(2);
    }

    public static synchronized void getRecentMonths(int num) {
        List<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();
        //当前时所在月份的第一天和最后一天
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        //设置startDate
        Calendar c = Calendar.getInstance();
        //设置endDate
        Calendar c2 = Calendar.getInstance();
        for (int i = 0; i < num; i++) {
            HashMap<String, Object> dateMap = new HashMap<String, Object>();
            //设置start
            //设置为1号,当前日期既为本月第一天
            c.set(Calendar.DAY_OF_MONTH, 1);
            //设置为0点0分0秒
            c.set(c.get(c.YEAR), c.get(c.MONTH), c.get(c.DAY_OF_MONTH), 0, 0, 0);
            //存入年月显示
            dateMap.put("yearMonthStr", format.format(c.getTime()));
            dateMap.put("startDate", c.getTime());
            //将c 设置为下个月
            c.add(c.DATE, -1);
            //设置end 为当前月的月底 23时59分59秒
            c2.set(Calendar.DAY_OF_MONTH, 1);
            //设置时间 23时59分59秒
            c2.set(c2.get(c.YEAR), c2.get(c.MONTH), c2.get(c.DAY_OF_MONTH), 23, 59, 59);
            //获得当前月最后一天
            c2.add(Calendar.MONTH, 1);
            c2.set(Calendar.DAY_OF_MONTH, 0);
            //存入map
            dateMap.put("endDate", c2.getTime());
            //获取当前时间的下一个月
            c2.add(Calendar.MONTH, -1);
            //将c2设置为当前时间上一个月
            c2.set(c.get(c.YEAR), c.get(c.MONTH), c.get(c.DAY_OF_MONTH));
            //放入集合
            maps.add(dateMap);

        }
        for (int i = 0;i< maps.size();i++){
            System.out.println(maps.get(i));
        }

    }
}
