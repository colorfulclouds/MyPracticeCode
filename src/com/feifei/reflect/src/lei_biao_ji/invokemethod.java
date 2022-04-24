package lei_biao_ji;

import java.lang.reflect.Method;

//根据方法的名称来执行方法
public class invokemethod {

	public int add(int a,int b){
		
		return a+b;
	}
	
	public static void main(String[] args){
		
		try{
			Class cls = Class.forName("lei_biao_ji.invokemethod");
			Class [] partypes = new Class[2];
			
			partypes[0] = Integer.TYPE;
			partypes[1] = Integer.TYPE;
			
			Method meth = cls.getMethod("add",partypes );
			invokemethod methobj = new invokemethod();
			
			Object argist[] = new Object[2];
			
			argist[0] = new Integer(37);
			argist[1] = new Integer(47);
			
			Object retobj = meth.invoke(methobj, argist);
			Integer retval = (Integer)  retobj;
			System.out.println(retval.intValue());
		}
		
		catch(Throwable e){
			e.printStackTrace();
		}
	}
}
