package enum_practice;

public class annotation {

	public static void main(String []  args){
		
		student s = new student();
		s.eat();
		s.walk();
		//@SuppressWarnings("unused")屏蔽警告
		int i;
	}
	
	
}


class student extends people{

	@Override
	public void eat(){
		System.out.println("xuesheng chi");
	}
	@Override
	//public void walk(){不加@Override不能通过
	public void walk(){
		System.out.println("xuesheng zou");
	}
}

class people{
	@Deprecated//就是下面num上的横线
	int num = 0;
	
	
	
	public void eat(){
		System.out.println("ren chi");
	}
	@myannotation("haha")//自定义的注解
	public void walk(){
		System.out.println("ren zou");
	}
}
