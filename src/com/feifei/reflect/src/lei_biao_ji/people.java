package lei_biao_ji;

public class people {

	public int a;
	String str;
	public people(){
		super();
		//System.out.println("û�в���");
	}
	
	public people(String str,int a){
		this.str = str;
		this.a = a;
	}
	
	public void print(){
		
		System.out.println("û�в���print");
	}
	
	public void print(int num){
		System.out.println("��һ��������print");
	}
	
	public int add(int a,int b){
		return a + b ;
	}
	public void show(){
		System.out.println(str+" "+a);
	}
	
	public int show(String str){
		System.out.println(str);
		return 552;
	}
}
