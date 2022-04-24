import java.util.Scanner;


public class q1 {

	public static int numde(String s)
	{
		if(s.length()==0 || s==null || (s.length()>1 && s.charAt(0) == '0'))
			return 0;
		
		int [] dp = new int[s.length()+1];
		dp[0]=1;
		
		for(int i=1;i<dp.length;i++)
		{
			if(s.charAt(i-1)=='0')
				dp[i]=0;
			else
				dp[i]=dp[i-1];
			
			if((i>1 &&s.charAt(i-1)<='6' && s.charAt(i-2)=='2')||(i>1 && s.charAt(i-2)=='1'))
				dp[i]+=dp[i-2];
		}
		
		return dp[s.length()];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		System.out.println(numde(str));
		
	}

}
