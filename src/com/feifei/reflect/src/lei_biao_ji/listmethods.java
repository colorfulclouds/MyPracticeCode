package lei_biao_ji;
import java.lang.reflect.*;
//�г���Ա�����������Ϣ
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
				System.out.println("name:"+m.getName());//���з�������
				System.out.println("���巽���������� :"+m.getDeclaringClass());//���巽����������
				
				Class []pvec = m.getParameterTypes();
				
				for(int j = 0;j<pvec.length;j++)
					System.out.println("����:"+pvec[j]);//�����Ĳ�������
				
				Class [] evec = m.getExceptionTypes();
				for(int j = 0;j<evec.length;j++)
					System.out.println("�쳣:"+evec[j]);//�����׳����쳣
				
				System.out.println("����ֵ����:"+m.getReturnType());//�����ķ���ֵ����
				
			}
			
 		}
		catch(Throwable e){
			//e.printStackTrace();
			System.err.println(e);
		}
	}
	
}
