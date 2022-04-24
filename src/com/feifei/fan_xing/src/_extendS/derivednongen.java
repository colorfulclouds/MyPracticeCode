package _extendS;

public class derivednongen <T> extends nongen{

	T ob;
	
	public derivednongen(T ob,int n){
		super(n);
		this.ob = ob;
	}
	
	public T getob(){
		return ob;
	}
}
