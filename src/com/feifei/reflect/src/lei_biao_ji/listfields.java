package lei_biao_ji;

import java.lang.reflect.Modifier;
import java.text.DateFormat.Field;

//��ĳ�Ա������ ˽�� ���� ��̬�ȵ�
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
				System.out.println("name"+fld.getName());//��ó�Ա����������
				System.out.println("declare class"+fld.getDeclaringClass());//������Ա�������������
				System.out.println("type"+fld.getType());//��Ա����������
				
				int mod = fld.getModifiers();//������η�
				System.out.println("���η�"+Modifier.toString(mod));
			}
		}
		
		catch(Throwable e){
			e.printStackTrace();
		}
	}

}
