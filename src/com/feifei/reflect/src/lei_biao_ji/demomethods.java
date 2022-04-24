package lei_biao_ji;

import java.lang.reflect.Method;

public class demomethods {

	public static void main(String[] args) {

		try{
			Class c = Class.forName("java.util.Queue");
			Method [] m = c.getDeclaredMethods();//获取类中声明的方法
			
			for(Method str:m)
				System.out.println(str.toString());
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
