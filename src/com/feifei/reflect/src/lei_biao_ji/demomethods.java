package lei_biao_ji;

import java.lang.reflect.Method;

public class demomethods {

	public static void main(String[] args) {

		try{
			Class c = Class.forName("java.util.Queue");
			Method [] m = c.getDeclaredMethods();//��ȡ���������ķ���
			
			for(Method str:m)
				System.out.println(str.toString());
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
