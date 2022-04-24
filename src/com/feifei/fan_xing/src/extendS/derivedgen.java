package extendS;

public class derivedgen <T,U> extends supergen<T>{

	U dob;
	public derivedgen(T ob,U dob){
		super(ob);
		this.dob = dob;
	}
	
	public U getdob(){
		return dob;
	}
	
}
