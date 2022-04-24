
import java.util.Scanner;


public class question2 {

	/**
	 * @param args
	 */
	
	public static boolean comp(String [] v)
	{
		String first = v[0];
		String last = v[v.length-1];
		
		if(first.charAt(0) != last.charAt(last.length()-1))
			return false;

			
		for(int i=0;i<v.length-1;i++)
		{
			String temp = v[i];
			String next = v[i+1];
			
			if(temp.charAt(temp.length()-1) != next.charAt(0))
				return false;
		}
		
		return true;
		
	}
	
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		String all = sc.nextLine();
		
		String [] voc = all.split(" ");
		
		if(comp(voc) == true)
		{
			System.out.print("true");
			return ;
		}
		
		for(int i=0;i<voc.length-1;i++)
		{
			String temp1 = voc[i];
			
			for(int j=i+1;j<voc.length;j++)
			{
				String temp2 = voc[j];
				
				voc[i] = temp2;
				voc[j] = temp1;
				
				if(comp(voc) == true)
				{
					System.out.print("true");
					return ;
				}
				else
				{
					voc[i] = temp1;
					voc[j] = temp2;
				}
			}
		}
		
		System.out.print("false");
		
		
	}

}
