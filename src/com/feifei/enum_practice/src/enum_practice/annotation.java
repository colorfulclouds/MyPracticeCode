package enum_practice;

public class annotation {

	public static void main(String []  args){
		
		student s = new student();
		s.eat();
		s.walk();
		//@SuppressWarnings("unused")���ξ���
		int i;
	}
	
	
}


class student extends people{

	@Override
	public void eat(){
		System.out.println("xuesheng chi");
	}
	@Override
	//public void walk(){����@Override����ͨ��
	public void walk(){
		System.out.println("xuesheng zou");
	}
}

class people{
	@Deprecated//��������num�ϵĺ���
	int num = 0;
	
	
	
	public void eat(){
		System.out.println("ren chi");
	}
	@myannotation("haha")//�Զ����ע��
	public void walk(){
		System.out.println("ren zou");
	}
}
