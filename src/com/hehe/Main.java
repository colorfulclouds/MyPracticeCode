package com.hehe;

import java.lang.reflect.Type;
import java.util.*;

public class Main {
    public static void main(String[] args) {


		/**
		 * boolean 类型的数组 初始化后是false类型的
		 */

		/**
		 * 转化日期
		 */
//        Calendar c = Calendar.getInstance();
//        c.setTime(new Date());
//        //c.add(Calendar.HOUR_OF_DAY, -8);
//        Date bendTimeAdd8Hours = c.getTime();
//        System.out.println(bendTimeAdd8Hours);


		/**列表和Array
		 *
		 * 本类演示了Arrays类中的asList方法
		 * 通过四个段落来演示,体现出了该方法的相关特性.
		 *
		 * (1) 该方法对于基本数据类型的数组支持并不好,当数组是基本数据类型时不建议使用
		 * (2) 当使用asList()方法时，数组就和列表链接在一起了.
		 *     当更新其中之一时，另一个将自动获得更新。
		 *     注意:仅仅针对对象数组类型,基本数据类型数组不具备该特性
		 * (3) asList得到的数组是的没有add和remove方法的
		 *
		 * 阅读相关:通过查看Arrays类的源码可以知道,asList返回的List是Array中的实现的
		 * 内部类,而该类并没有定义add和remove方法【UnsupportedOperationException】.另外,为什么修改其中一个,另一个也自动
		 * 获得更新了,因为asList获得List实际引用的就是数组
		 */
//        List list = Arrays.asList("其它");
//        System.out.println(list.getClass());
//        System.out.println(list);
//        System.out.println("其它");

//		System.out.println("=============实验列表、数组 start==================");
//		String[] arr = {"aa","bb","cc"};
//        Integer[] ii = {1,2,3,4,5};
//        //列表转化为Array
//		List<Integer> list = Arrays.asList(ii);
//		List<Integer> target = new ArrayList<>();
//		target.addAll(list);
//		//list转化为字符串输出
//		System.out.println(target.toString());
//		//取第一位上的值
//		System.out.println(arr[1]);
//		System.out.println(target.get(1));
//		System.out.println(list.get(1));
//		System.out.println("=============实验列表、数组 end==================");
//		System.out.println("=============博客列表、数组 start==================");
//		String[] s = {"aa","bb","cc"};
//		List<String> strlist = Arrays.asList(s);  //  <--!
//		for(String str:strlist){
//			System.out.println(str);
//		}
//		System.out.println("------------------------");
//		//基本数据类型结果打印为一个元素 【该方法不适用于基本数据类型（byte,short,int,long,float,double,boolean）】
//		int[] i ={11,22,33};
//		List intlist = Arrays.asList(i);  //  <--!
//		for(Object o:intlist){
//			System.out.println(o.toString());
//		}
//		System.out.println("------------------------");
//		Integer[] ob = {11,22,33};
//		List<Integer> oblist = Arrays.asList(ob); //  <--!
////		UnsupportedOperationException
////		oblist.remove(1);
////		oblist.add(1);
//		for(int a:oblist){
//			System.out.println(a);
//		}
//		System.out.println("------------------------");
//		System.out.println("=============博客列表、数组 end==================");


		/**画圆圈地
		 *
		 * n^2  与  Math.pow(n,2)
		 */
//		int n = 3;
////		int slid0 = (int) Math.floor(Math.sqrt((n^2)/2));  //n^2 表示n与2进行异或(注意不是n的平方)
//		int slid = (int) Math.floor(Math.sqrt((n*n)/2));
//		int slid1  = (int) Math.floor(Math.sqrt((Math.pow(n, 2))/2));
//		System.out.println(slid*slid*4);
//		System.out.println(slid1*slid1*4);




    }
}



//快捷键-->用于快速生成main方法，循环，输出语句
    //psvm
    //fori
    //sout
