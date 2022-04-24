import java.util.Scanner;


public class question4 {

	/**
	 * @param args
	 */
	public static void cal(int [] seq , int x , int ii , int q)
	{
		int  count=0;
		
		for(int i=0;i<seq.length;i++)
		{
			if(seq[i]>=x)
			{
				seq[i]--;
				count ++;
			}
		}
		if(ii<q-1)
			System.out.println(count);
		else
			System.out.print(count);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int q=sc.nextInt();
		
		int[] se = new int[n+1];
		
		for(int i=0;i<n;i++)
		{
			se[i]=sc.nextInt();
			
		}
		
		for(int i=0;i<q;i++)
		{
			int x=sc.nextInt();
			cal(se,x , i , q);
		}
	}

}
