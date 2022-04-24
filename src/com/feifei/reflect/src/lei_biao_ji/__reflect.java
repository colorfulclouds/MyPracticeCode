package lei_biao_ji;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;



public class __reflect<__reflect> {
	
	 
	public  void dd() throws Exception{
		//类加载器得到类的实例
		
			
			ClassLoader classloader = this.getClass().getClassLoader();
		Class cls5 = classloader.loadClass("lei_biao_ji.people");
		//System.out.println(cls5.getName());
		
		
	}
	
	
	public  static void main(String [] args) throws Exception{
		//获取Class的实例
		Class  cls1 = people.class;
		//System.out.println(cls1);
		
		people p = (people) cls1.newInstance();
		/*
		Field first = cls1.getField("a");
		first.set(p,10);
		Field second = cls1.getDeclaredField("str");//凡是声明的成员变量 都可以这么获得
		second.setAccessible(true);//可以访问
		second.set(p, "yufeifei");
		p.show();
		
		//反射活得方法
		Method m1 = cls1.getDeclaredMethod("show",String.class);//除过public getDeclaredMethod
		m1.setAccessible(true);//除过public
		Object value = m1.invoke(p,"i am happy");//携带返回值
		System.out.println(value);
		*/
		Constructor cons = cls1.getDeclaredConstructor(String.class,int.class);
		cons.setAccessible(true);
		people p_p = (people) cons.newInstance("i am happy",2552);
		p_p.show();
		
		/*
		Constructor[] anno = cls1.getConstructors();
		for(Constructor a:anno)
			System.out.println(a);
		
		*/
		
		/*
		Class cls2 = String.class;
		System.out.println(cls2);
		
		
		people p = new people();
		Class cls3 = p.getClass();
		System.out.println(cls3);
		
		Class cls4 = Class.forName("lei_biao_ji.people");
		System.out.println(cls4);*/
		
		//类加载器得到类的实例
		//dd();
		
		
		/*
		Class cls1 = Class.forName("lei_biao_ji.people");
		Object p1 = cls1.newInstance();
		people pp1 = (people) p1;
		System.out.println(pp1);
		*/
	}
}
