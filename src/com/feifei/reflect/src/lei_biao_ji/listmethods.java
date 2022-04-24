package lei_biao_ji;
import java.lang.reflect.*;
//列出成员方法的相关信息
public class listmethods extends circle{

	private int onlytest(Object p,int x) throws NullPointerException{
		if(p == null)
			throw new NullPointerException();
		return x;
	}
	
	public static void main(String [] args){
		
		try{
			Class cls = Class.forName("lei_biao_ji.listmethods");
			Method  [] methlist = cls.getDeclaredMethods();
			
			for(Method m:methlist){
				System.out.println("***********");
				System.out.println("name:"+m.getName());//类中方法名称
				System.out.println("定义方法的类名称 :"+m.getDeclaringClass());//定义方法的类名称
				
				Class []pvec = m.getParameterTypes();
				
				for(int j = 0;j<pvec.length;j++)
					System.out.println("参数:"+pvec[j]);//方法的参数类型
				
				Class [] evec = m.getExceptionTypes();
				for(int j = 0;j<evec.length;j++)
					System.out.println("异常:"+evec[j]);//方法抛出的异常
				
				System.out.println("返回值类型:"+m.getReturnType());//方法的返回值类型
				
			}
			
 		}
		catch(Throwable e){
			//e.printStackTrace();
			System.err.println(e);
		}
	}
	
}
