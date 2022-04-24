package extendS;

public class supergen<T> {

	T ob;
	public supergen(T ob){
		this.ob = ob;
	}
	
	public supergen(){
		ob = null;
	}
	
	public T getob(){
		return ob;
	}
	
}
