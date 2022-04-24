package interface_fan_xing;

public class demogenlf {

	public static void main(String[] args){
		
		Integer [] inums = {2,5,4,25,1,2,0,2};
		Character [] chs = {'y','u','f','e','i','l'};
		
		myclass <Integer> iob = new myclass<Integer> (inums);
		myclass <Character> cob = new myclass<Character> (chs); 
		System.out.println("num max:"+iob.max());
		System.out.println("num min:"+iob.min());
		System.out.println("char max:"+cob.max());
		System.out.println("char min:"+cob.min());
		
		
	}
}
