package throw_exception;

class divid{
	
	void func(int a,int b) throws ArithmeticException{
		int c = 0;
		c = a/b;
	}
	
}

public class test {
	
	public static void main(String[] args){
		//try{
			new divid().func(5, 0);
	
		//}
/*
		catch(ArithmeticException e){
			System.out.println("haha");
			e.printStackTrace();
		}
		catch(Exception e){
			System.out.println("you computer is very slow!");
			e.printStackTrace();
		}*/
	}

}
