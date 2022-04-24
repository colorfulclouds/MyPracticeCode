package lei_biao_ji;

import java.lang.reflect.Constructor;

//列出构造方法的相关信息
public class listconstructor extends circle{

	public listconstructor(){}
	public listconstructor(int i,double d){}
	
	public static void main(String[] args) {

		try{
			Class cls = Class.forName("lei_biao_ji.listconstructor");
			Constructor [] ctorlist = cls.getDeclaredConstructors();
			
			for(Constructor m:ctorlist){
				
				System.out.println("********");
				System.out.println("name"+m.getName());//构造方法的名称
				
				System.out.println("declared class"+m.getDeclaringClass());//所定义的类
				
				Class []pvec = m.getParameterTypes();//构造方法的参数 类型
				
				for(int j = 0;j<pvec.length;j++)
					System.out.println("参数"+pvec[j]);
				
				Class[] evec = m.getExceptionTypes();//构造方法所抛出的异常
				for(int j = 0;j<evec.length;j++)
					System.out.println("异常类型:"+evec[j]);
			}
			
		}
		
		catch(Throwable e){
			e.printStackTrace();
		}
	}

}
