package class_fan_xing;


class generic<T>{
	
	T ob;
	public generic(T ob) {

		this.ob = ob;
		
	}
	
	T getob(){
		return ob;
	}
	
	void showtype(){
		
		System.out.println(ob.getClass().getName());
	}
}
public class _class_fan_xing {

	
	public static void main(String [] args){
		
		generic<String> iobj = new generic<String>("yufeifei");
		generic<Integer> iiobj = new generic<Integer>(55);
		int j = iiobj.getob().intValue();
		System.out.println(j);
		String k = iobj.getob();
		System.out.println(k);
		iobj.showtype();
	}
}
