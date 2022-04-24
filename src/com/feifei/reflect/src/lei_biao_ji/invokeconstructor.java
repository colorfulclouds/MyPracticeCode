package lei_biao_ji;

import java.lang.reflect.Constructor;

//创建新的对象

public class invokeconstructor {
	
	public invokeconstructor(){
		System.out.println("this is a p");
	}
	
	public invokeconstructor(int a,int b){
		System.out.println(a +" "+b);
	}
	

	public static void main(String[] args) {

		try{
			
			Class cls = Class.forName("lei_biao_ji.invokeconstructor");
			Class []partypes = new Class[2];
			partypes[0] = Integer.TYPE;
			partypes[1] = Integer.TYPE;
			
			Constructor ct = cls.getConstructor(partypes);
			Object [] arglist = new Object[2];
			arglist[0] = new Integer(37);
			arglist[1] = new Integer(47);
			Object retobj = ct.newInstance(arglist);
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
