import java.util.Scanner;


public class q2 {

	/**
	 * @param args
	 */
	public static int get_max(int [] number , int start , int end)
	{
		int max=0;
		//System.out.println(start+" "+end);
		for(int i=start ;i<=end;i++)
		{
			if(number[i]>max)
			{
				max = number[i];
			}
		}
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int [] number = new int[n];
		
		for(int i=0;i<n;i++)
		{
			number[i] = sc.nextInt();
		}
		
		int max_value = 0;
		
		for(int i=1;i<=n;i++)
		{
			int min_value=(int) 10e9;
			
			int j;
			for(j=0;j<number.length  ; j+=i)
				if(j+i-1 < number.length)
				{
					max_value = get_max(number , j , j+i-1);
					if(min_value > max_value)
						min_value = max_value;
				}
			System.out.print(min_value + " ");
		}
		
	}

}
