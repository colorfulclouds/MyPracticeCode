import java.util.Scanner;


public class q2 {

	static int flag = 0;
	
	private static int bin_find(int [] array , int left , int right , int value)
	{
		if(left > right)
			return left;
		
		int mid = left + (right-left)/2;
		
		if(array[mid] > value)
			return bin_find(array , left , mid-1 , value);
		else if(array[mid] < value)
			return bin_find(array , mid+1 , right , value);
		else
		{
			flag = 1;
			return mid;
		}
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		String str_trim = "";
		
		for(int i=1;i<str.length()-1;i++)
		{
			str_trim += str.charAt(i);
		}
		
		String[] number = str_trim.split(",");
		
		
		int [] array = new int[number.length];
		
		for(int i=0;i<number.length;i++)
		{
			array[i] = Integer.valueOf(number[i]);
		}
		
		
		int find_index = bin_find(array , 0 , array.length-1 , 19);
		
		if(find_index == array.length || flag == 0)
		{
			System.out.println(-1);
			return ;
		}
		
		System.out.println(find_index+1);
	}

}
