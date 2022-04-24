import java.util.Scanner;


public class q3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner  sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int [] a = new int[n];
		int [] b = new int[n];
		int [] c = new int[n];
		
		for(int i=0;i<n;i++)
		{
			
			
			a[i]=sc.nextInt();
			b[i]=sc.nextInt();
			c[i]=sc.nextInt();

			
		}
		
		int [] res=new int[n];
		int sum=0;
		
		boolean flag = true;
		
		for(int i=0;i<n;i++)
		{
			if(flag)
			{
				if(a[i]+c[i]<b[i])
				{
					flag=false;
					res[i]=a[i]+c[i];
				}
				else
					res[i]=b[i];
				
				sum+=res[i];
			}
			else
			{
				if(b[i]+c[i]<a[i])
				{
					flag=true;
					res[i]=b[i]+c[i];
				}
				else
					res[i]=a[i];
				
				sum+=res[i];
			}
		}
		
		System.out.println(sum);
	}
	

}
