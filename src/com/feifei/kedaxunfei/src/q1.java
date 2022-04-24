import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class q1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		int flag=0;
		
		ArrayList<Integer> number = new ArrayList();
		
		for(int i=0;i<str.length();i++)
		{
			if( Character.isDigit( str.charAt(i) ) )
			{
				number.add(str.charAt(i) -'0' );
				flag = 1;
			}
		}
		
		if(flag == 0)
		{
			System.out.println(-1);
			return ;
		}
		
		int [] sorted_number = new int[number.size()];
		
		for(int i=0;i<number.size();i++)
			sorted_number[i] = number.get(i);
		
		Arrays.sort(sorted_number);
			
		for(int i=0;i<sorted_number.length;i++)
			System.out.print(sorted_number[i]);

	}

}
