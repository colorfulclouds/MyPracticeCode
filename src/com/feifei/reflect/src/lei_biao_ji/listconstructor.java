package lei_biao_ji;

import java.lang.reflect.Constructor;

//�г����췽���������Ϣ
public class listconstructor extends circle{

	public listconstructor(){}
	public listconstructor(int i,double d){}
	
	public static void main(String[] args) {

		try{
			Class cls = Class.forName("lei_biao_ji.listconstructor");
			Constructor [] ctorlist = cls.getDeclaredConstructors();
			
			for(Constructor m:ctorlist){
				
				System.out.println("********");
				System.out.println("name"+m.getName());//���췽��������
				
				System.out.println("declared class"+m.getDeclaringClass());//���������
				
				Class []pvec = m.getParameterTypes();//���췽���Ĳ��� ����
				
				for(int j = 0;j<pvec.length;j++)
					System.out.println("����"+pvec[j]);
				
				Class[] evec = m.getExceptionTypes();//���췽�����׳����쳣
				for(int j = 0;j<evec.length;j++)
					System.out.println("�쳣����:"+evec[j]);
			}
			
		}
		
		catch(Throwable e){
			e.printStackTrace();
		}
	}

}
