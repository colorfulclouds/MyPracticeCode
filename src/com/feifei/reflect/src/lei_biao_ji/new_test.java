package lei_biao_ji;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class stu{
	
	public int x = 9;
	public int y = 2;
	
	public void output(){
		System.out.println(x+".."+y);
	}
	public stu(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
}

public class new_test {

	public static void main(String[] args) {
		
//		try {
//			Class c = Class.forName("lei_biao_ji.stu");
//			stu s = (stu)c.newInstance();
//			System.out.println(s.x+".."+s.y);
//		} 
//		catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
//			e.printStackTrace();
//		}
		
		try {
			Class c = Class.forName("lei_biao_ji.stu");
			Constructor[] cons = c.getDeclaredConstructors();
			Class[] params = cons[0].getParameterTypes();
			Object[] paravalues = new Object[params.length];
			for(int i = 0;i<params.length;i++){
				if(params[i].isPrimitive())
					paravalues[i] = new Integer(i+3);
			}
			
			Object o = cons[0].newInstance(paravalues);
			Method[] ms = c.getDeclaredMethods();
			ms[0].invoke(o, null);//执行output()方法 没有参数 所以为null
		} 
		catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}
}

