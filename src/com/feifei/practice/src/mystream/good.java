package mystream;

import java.io.IOException;

public class good {

	public static void main(String[] args) throws IOException{
		
		int count = 0,i;
		boolean first  = true;
		System.out.print("input a string:");
		while((i = System.in.read())!='#'){
			
			if(first){
				
				System.out.print("catch:");
				first = false;
			}
			
			count++;
			System.out.print((char)i);
			
		}
		
		System.out.println("\nnum:"+count);
	}

}
