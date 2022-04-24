package lei_biao_ji;

import java.lang.reflect.Modifier;
import java.text.DateFormat.Field;

//类的成员属性如 私有 共有 静态等等
public class listfields {

	private double d;
	public static final int i = 37;
	String s = "yufeifei";
	
	
	public static void main(String[] args) {

		try{
			
			Class cls = Class.forName("lei_biao_ji.listfields");
			java.lang.reflect.Field[] fieldlist = cls.getDeclaredFields();
			
			for(java.lang.reflect.Field fld:fieldlist){
				
				System.out.println("********");
				System.out.println("name"+fld.getName());//获得成员变量的名字
				System.out.println("declare class"+fld.getDeclaringClass());//包含成员方法的类的名字
				System.out.println("type"+fld.getType());//成员变量的类型
				
				int mod = fld.getModifiers();//获得修饰符
				System.out.println("修饰符"+Modifier.toString(mod));
			}
		}
		
		catch(Throwable e){
			e.printStackTrace();
		}
	}

}
