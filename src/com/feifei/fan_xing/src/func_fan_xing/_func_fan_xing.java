package func_fan_xing;

public class _func_fan_xing {

	public static <T> void showgenmag(T ob,int n){
		
		T jb = ob;
		System.out.println(ob.getClass().getName());
		System.out.println("number : "+n);
		
	}
	
	public static <T> void showgenmsg(T ob){
		System.out.println("here : "+ob.getClass().getName());
		
	}
	
	public static void main(String[] args) {

		String str = "yufeifei";
		Integer num = new Integer(552);
		
		_func_fan_xing.<String>showgenmag(str, 25);
		_func_fan_xing.showgenmsg(str);
		
	}

}
