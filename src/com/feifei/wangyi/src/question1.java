import java.util.Scanner;


public class question1 {

	/**
	 * @param args
	 */
	
	
	
	public static void sq(int []arr , int n)
	{
		if(n == arr.length)
		{
			for(int i=0;i<arr.length;i++)
			{
				System.out.print(arr[i]+" ");
			}
			System.out.println();
		}
		
		for(int i=n;i<arr.length;i++)
		{
			int temp = arr[n];
			arr[n] = arr[i];
			arr[i] = temp;
			
			sq(arr , n+1);
		
			temp = arr[n];
			arr[n] = arr[i];
			arr[i] = temp;
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n;
		
		
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		int [] number = new int[n];
		
		for(int i=0;i<n;i++)
		{
			number[i] = sc.nextInt();
		}
		
		sq(number , 0);
		
	}

}
