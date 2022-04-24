import java.util.Scanner;
//System.out.println("Hello Word");
public class meituan1 
{
	public static int get(int n)
	{
		int[] flag = new int[4*n];
		for(int i=0;i<flag.length;i++)
			flag[i] = 0;
		int start=0;
		int count=0;
		while(true)
		{
			start = ( start + (n+1) ) % (4*n);
			
			if(flag[start] == 1){
				count++;
				break;
			}
				
			else
			{
				flag[start] = 1;
				count ++;
			}
		}
		return count;
	}
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		int t=input.nextInt();
		int[] n = new int[t];
		for(int i=0;i<t;i++)
			n[i] = input.nextInt();
		for(int i=0;i<t;i++)
			System.out.println( get(n[i]) );
    }

}
