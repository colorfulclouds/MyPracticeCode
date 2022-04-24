package question2;

public class answer2 {
	
	public static void main(String [] args){
		
		int i = 1;
		
		int temp = 0;
		
		int sum = 0;
		//Integer.MAX_VALUE
		
		
		for(;i<9999999;i++){
		//	System.out.print(i+"*");
			temp = i*i*i;
			
			sum = 0;
			while(temp!=0){
				
				sum+=(temp%10);
				temp/=10;
				
			}
			
			if(sum == i)
				System.out.println(i);
			
		}
		
	}

}
