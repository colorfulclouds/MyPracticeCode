import java.util.Scanner;


public class q1 {

	public static boolean isunique(int [] b)
	{
		for(int i=1;i<b.length;i++)
			for(int j=0;j<i;j++)
				if(b[i] == b[j])
					return false;
		
		return true;
	}
	
	public static int min = Integer.MAX_VALUE;
	
	public static void pro(int [] b , int idx , int count)
	{
		if(idx == b.length)
		{
			if(isunique(b))
			{
				if(count<min)
				min = count;
			
				return ;
			}
			else
				return ;
		}
		
		pro(b , idx+1 , count);
		
		int tmp = b[idx];
		b[idx] = tmp+1;
		pro(b , idx+1 , count+1);
		b[idx] = tmp;
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String [] str = sc.nextLine().split(",");
		
		int [] b = new int[str.length];
		
		for(int i=0;i<str.length;i++)
			b[i] = Integer.valueOf(str[i]).intValue();
		
		pro(b , 0 , 0);
		
		System.out.println(min);
	}
	

}
