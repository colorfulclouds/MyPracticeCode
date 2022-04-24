import java.util.Scanner;
import java.util.Stack;


public class question1 {

	/**
	 * @param args
	 */
	
	public static void decoding(String s)
	{
		Stack<String> chars = new Stack<String>();
		Stack<Integer> nums = new Stack<Integer>();
		
		String res="";
		int num=0;
		
		for(int i=0;i<s.length();i++)
		{
			char c=s.charAt(i);
			
			if(Character.isDigit(c))
			{
				num = num*10+(c-'0');
			}else if(Character.isLetter(c) && i>0 && Character.isDigit(s.charAt(i-1)))
			{
				for(int j=0;j<num;j++)
				{
					res += c;
				}
				num=0;
			}else if(Character.isLetter(c))
			{
				res += c;
			}else if(c=='(')
			{
				chars.push(res);
				nums.push(num);
				
				res="";
				num=0;
			}else
			{
				int times=nums.pop();
				String tmp = "";
				for(int j=0;j<times;j++)
				{
					tmp += res;
				}
				res = chars.pop()+tmp;
			}
			
		}
		
		StringBuffer res_rev = new StringBuffer(res);
		
		System.out.print(new String(res_rev.reverse()));
		
		
	}
	
	public static String del_0(String s)
	{
		String bak="";
		
		for(int i=0;i<s.length();i++)
		{
			char temp = s.charAt(i);
			
			if(temp != '0')
				temp = s.charAt(i);
			
			if(temp == '(')
				temp = ')';
			else if(temp == ')')
				temp = '(';
				
			
			bak += temp;
			
		}
		
		StringBuffer bak_rev = new StringBuffer(bak);
		
		return new String( bak_rev.reverse() );
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		
		String [] str = new String[n];
		sc = new Scanner(System.in);
		for(int i=0;i<n;i++)
		{
			str[i] = sc.nextLine();
			
			
		}
		
		
		for(int i=0;i<n;i++)
		{
			decoding(del_0(str[i]));
			
			if(i<n-1)
				System.out.println();
			
		}
		
	}

}
