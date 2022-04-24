package class_two_p_fan_xing;

class twogen<T,V>{
	T obj1;
	V obj2;
	
	twogen(T obj1,V obj2){
		this.obj1 = obj1;
		this.obj2 = obj2;
	}
	
	void showtype(){
		System.out.println("T type :"+obj1.getClass().getName());
		System.out.println("V type :"+obj2.getClass().getName());
	}
	
	T getobj1(){
		return obj1;
	}
	
	V getobj2(){
		return obj2;
	}
}

public class _class_two_p_fan_xing {

	public static void main(String[] args){
		
		twogen<Integer,String> two;
		two = new twogen<Integer,String>(52, "yufeifei");
		int v = two.getobj1();
		System.out.println(v);
		
		String str;
		str = two.getobj2();
		System.out.println(str);
	}
}
