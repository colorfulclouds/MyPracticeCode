package lei_biao_ji;

public class getclassname {

	public static void main(String [] args){
		
		showname(new shape());
		showname(new circle());
	}
	
	public static void showname(shape _shape){
		
		Class c1 = _shape.getClass();
		System.out.println(c1.getName());
		//if(c1 == shape.class)//Ҳ����
		//if(_shape instanceof shape)//Ҳ����
		if(c1.isInstance(new shape()))
			System.out.println("shape object");
		else
			//if(c1 == circle.class)
			//if(_shape instanceof circle)//Ҳ����
			if(c1.isInstance(new circle()))
				System.out.println("circle object");
		
	}
}
