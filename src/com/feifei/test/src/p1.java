import java.util.Scanner;
public class p1 {
	func1(){
		
	}
	
	func2(){
		
	}
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		
		String s=input.nextLine();
		String t=input.nextLine();
		int count = 0;
		
		for(int i=0;i<=s.length()-t.length();i++)
		{
			if(s.charAt(i) == t.charAt(0) || s.charAt(i) == '?')
			{
				int k;
				
				for(k=0;k<t.length();k++)
				{
					if( s.charAt(i+k) != '?' && s.charAt(i+k) != t.charAt(k))
					{
						//break ;
						goto loop;
					}
				}
				
				//if(k==t.length())
					count ++;
			}loop:;
			
		}
		System.out.println(count);
	}
}