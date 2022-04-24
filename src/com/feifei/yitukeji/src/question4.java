import java.util.Scanner;


public class question4 {

	/**
	 * @param args
	 */

	public static Integer [] get_count(String str)
	{
		Integer [] min_count = new Integer[str.length()];
		
		for(int k=0;k<str.length();k++)
		{			
			min_count[k] = get_min_count(str , k);
		}
		
		return min_count;
	}
	
	public static int get_min_count(String str , int k)
	{
		return 1;
	}
	
	
	public static int xor(String sub_str)
	{
		int sum=0;
		
		for(int i=1;i<sub_str.length();i++)
		{
			sum += ( Integer.parseInt(Character.toString(sub_str.charAt(i))) ^ Integer.parseInt(Character.toString(sub_str.charAt(i-1))) ) ;
		}
		
		return sum;
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i=0;i<T;i++)
		{
			int n = sc.nextInt();
			String str = sc.nextLine();
		}
	}

}
